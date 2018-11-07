package cliente;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Bruno Bencke
 */
public class Cliente {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando Cliente");


        //localhost ou IP da máquina ex "127.0.0.1"
        Socket socket = new Socket("localhost", 2525);
        System.out.println("Conexao Estabelecida");

        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //faz a leitura dos dados em String      
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        //interface para gravacao de strings
        PrintStream out = new PrintStream(output);
        
        //le uma mensagem do teclado
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite uma Mensagem");
            String mensagem = scanner.nextLine();
            
            out.println(mensagem);

            if ("FIM".equals(mensagem)) {//se a mensagem for FIM encerra a conexao
                break;
            }

            mensagem = in.readLine();
            System.out.println("mensagem recebida do servidor "+mensagem);
        }
        System.out.println("Encerrando conexao");
        in.close();
        out.close();
        socket.close();
    }

}
