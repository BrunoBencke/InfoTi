package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Bencke
 */
public class Servidor implements Runnable{
    
    private static List<Atendente> atendentes;
    private ServerSocket server;
    private boolean inicializado;
    private boolean executando;
    private Thread thread;
    
    public Servidor(int porta) throws Exception{
        atendentes = new ArrayList<Atendente>();
        inicializado = false;
        executando = false;        
        open(porta);
    }
    

    
    private void open(int porta) throws Exception{
        server = new ServerSocket (porta);
        inicializado = true;
    }
    
    private void close() {
        for (Atendente atendente : atendentes) {
            try {
                atendente.stop();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            server.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        server = null;
        inicializado = false;
        executando = false;
        thread = null;
    }

    public void start(){
        if (!inicializado || executando) {
            return;
        }
        executando = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop() throws Exception{
        executando = false;
        if (thread != null) {
            thread.join();
        }        
    }

    @Override
    public void run() {
        System.out.println("Aguardando Conexão.");
        while (executando) {
            try {
                server.setSoTimeout(2500);
                Socket socket = server.accept();
                System.out.println("Conexao Estabelecida");                
                Atendente atendente = new Atendente(socket);
                atendente.start();
                atendentes.add(atendente);
            } catch (SocketTimeoutException e) {
                //System.out.println("Tempo de Conexão Excedido!");
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        close();
    }
    
    //servidor síncrono de uma única thread.atendende um único cliente de cada vez e as mensagens trocadas são sincronizadas: 
    //quando o socket cliente grava, o socket server lê; 
    //quando o socket server grava, o socket cliente lê;    
    
    //servidor tcp/ip
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando Servidor");

        //server socket assoocia o servico a uma porta
        Servidor servidor = new Servidor(2525);
        servidor.start();

        System.out.println("Pressione ENTER para encerrar o servidor");

        new Scanner(System.in).nextLine();

        System.out.println("Encerrando Servidor");
        servidor.stop();
    }

    public static boolean alertarEstoque(String pMsg)
    {
        String wmsg = "CLIE: " + pMsg;
        for (Atendente atendente : atendentes) {
            atendente.escreverMensagem("Testexxx");
        }
        return true;
    }
    
    
}
