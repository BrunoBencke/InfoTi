package apoio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

public class GravaTxt {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter1;
    BufferedWriter bufferedWriter;
    String linha = new String();

    public void gravaErro(String erro) {
        File log = new File("Log.txt");
        GregorianCalendar gc = new GregorianCalendar();
        try {
            FileWriter escrever = new FileWriter("Log.txt", true);
            if (log.exists()) {
                escrever.write("Data: " + gc.getTime() + "\nErro: " + erro + "\n\n");
                escrever.close();
            } else {
                log.createNewFile();
            }
        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (NullPointerException e) {

            throw new RuntimeException(e);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
    
    public void gravaConfig() {
        File log = new File("config.txt");
        try {
            FileWriter escrever = new FileWriter("config.txt", true);
            if (log.exists()) {
                escrever.write("servidor=localhost\n");
                escrever.close();
            } else {
                log.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void retornaServidor() {
        String path = System.getProperty("user.dir");
        path = path + "\\config.txt";
        String conteudo = "";
        File arq = new File(path);
        System.out.println(arq.getPath());
        if (arq.exists()) {
            try {
                FileReader leitorDeArquivo = new FileReader(arq);
                BufferedReader buffer = new BufferedReader(leitorDeArquivo);
                try{
                    linha = buffer.readLine();
                    while(linha != null){
                        conteudo += linha;
                        linha = buffer.readLine();
                    }
                    leitorDeArquivo.close();
                }catch(IOException ex){
                    conteudo = "Erro: não foi possível ler o arquivo!";
                }                
            } catch (FileNotFoundException e) {
                conteudo = "Erro: arquivo não encontrado!";
            }
            System.out.println(conteudo);
        }
    }

}
