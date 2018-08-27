package apoio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LerArquivoLog {

    FileReader fileReader;
    BufferedReader bufferedReader;
    
    public LerArquivoLog(){
        
        try {
            fileReader = new FileReader("arquivo.txt");
            bufferedReader = new BufferedReader(fileReader);
            
            while(bufferedReader.ready()){
                
                System.out.println(bufferedReader.readLine());         
            }
            
            bufferedReader.close();
        } catch (FileNotFoundException ex) {

        }
        catch(IOException er){
            
        }
    }
    
}
