package cliente.servidor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Bruno Bencke
 */
public class Servidor {
    
    //servidor síncrono de uma única thread.atendende um único cliente de cada vez e as mensagens trocadas são sincronizadas: 
    //quando o socket cliente grava, o socket server lê; 
    //quando o socket server grava, o socket cliente lê;    
    
    //servidor tcp/ip
    public static void main(String[] args) throws Exception{
        System.out.println("Iniciando Servidor");
        
        //server socket assoocia o servico a uma porta
        ServerSocket server = new ServerSocket(2525);
        
        //habilitar accept para servidor receber conexoes de clientes,fica esperando conexao
        Socket socket = server.accept();
        System.out.println("Conexao Estabelecida");
        
        //O InputStream do cliente está conectado ao OutputStream do servidor. 
        //E o InputStream do servidor está conectado ao OutputStream do cliente.
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        
        //faz a leitura dos dados      
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        
        //interface para gravacao de strings
        PrintStream out = new PrintStream(output);
        
        while (true){
            String mensagem = in.readLine();
            
            System.out.println("Mensagem recebida do cliente "+socket.getInetAddress().getHostName()+" - "+mensagem);
            
            if ("FIM".equals(mensagem)) {//se a mensagem for FIM encerra a conexao
                break;
            }
            
            out.println(mensagem);
        }
        System.out.println("Encerrando conexao");
        in.close();
        out.close();
        socket.close();
        server.close();
    }
    
}
