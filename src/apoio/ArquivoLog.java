package apoio;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
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

}
