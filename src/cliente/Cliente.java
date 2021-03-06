package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 *
 * @author Bruno Bencke
 */
public class Cliente implements Runnable {
    
    private Socket socket;
    private BufferedReader in;
    private PrintStream out;
    private boolean inicializado;
    private boolean executando;
    private Thread thread;
    
    public Cliente(String endereco, int porta) throws Exception{
        inicializado = false;
        executando = false;
        open(endereco, porta);        
    }
    
    private void open(String endereco, int porta) throws Exception {
        try {
            socket = new Socket(endereco, porta);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
            inicializado = true;
        } catch (Exception e) {
            System.out.println(e);
            close();
            throw e;
        }
    }
    
    private void close() {
        if (in != null) {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        in = null;
        out = null;
        socket = null;
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
    
    public boolean isExecutando(){
        return executando;
    }
    
    public void send(String mensagem){
        out.println(mensagem);
    }

    @Override
    public void run() {
        while (executando) {
            try {
                socket.setSoTimeout(2500);
                String mensagem = in.readLine();

//                mensagem.split(":");
//                if (mensagem.split(":")[0] == "PROD") {
//                    break;
//                }
                System.out.println("Servidor enviou: " + mensagem);
            } catch (SocketTimeoutException e) {
                //ignorar
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        close();
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando Cliente ...");
        System.out.println("Iniciando Conexão com o Servidor ...");
        Cliente cliente = new Cliente("localhost", 2525);
        System.out.println("Conexão Estabelecida...");
        cliente.start();
        
        //le uma mensagem do teclado
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite uma Mensagem");
            String mensagem = scanner.nextLine();
            
            if (!cliente.isExecutando()) {
                break;
            }
            
            cliente.send(mensagem);

            if ("FIM".equals(mensagem)) {//se a mensagem for FIM encerra a conexao
                break;
            }
        }
        cliente.stop();
        System.out.println("Encerrando cliente...");
    }
}
