package apoio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javassist.CtMethod.ConstParameter.string;
import javax.persistence.Convert;

public class ArquivoLog {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter1;
    BufferedWriter bufferedWriter;

    public ArquivoLog(String erros) {

        EscreverLog(erros);
    }

    private void EscreverLog(String erros) {
        try {
            arquivo = new File("Exceptions.log");
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);
            Vector texto = new Vector();
            while (bufferedReader.ready()) {

                texto.add(bufferedReader.readLine());
            }

            fileReader = new FileReader(arquivo);
            bufferedWriter = new BufferedWriter(fileWriter1);

            for (int i = 0; i > texto.size(); i++) {

                bufferedWriter.write(texto.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.write(erros);
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException ex) {

            try {
                arquivo.createNewFile();
                EscreverLog(erros);
            } catch (IOException ex1) {

                System.exit(0);
            }
        } catch (IOException er) {

            System.exit(0);
        }
    }
}
