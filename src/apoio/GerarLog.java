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
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerarLog {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter1;
    BufferedWriter bufferedWriter;

    public GerarLog(String erros) {

        EscreverLog(erros);
    }

    private void EscreverLog(String erros) {
        try {
            fileReader = new FileReader(arquivo);
            arquivo = new File("Exceptions.lg");

        } catch (FileNotFoundException ex) {
            
            
        }
        bufferedReader = new BufferedReader(fileReader);
    }

}
