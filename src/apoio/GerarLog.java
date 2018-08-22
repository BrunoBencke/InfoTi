package apoio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class GerarLog {

    private PrintWriter out;

    public GerarLog() {
        try {
            out = new PrintWriter(new FileWriter("Log.txt"));
        } catch (IOException e) {
            /*
			 * Se der algum erro com o arquivo de log, imprime a stacktrace no console, mas a 
			 * aplicação continua funcionando
             */
            e.printStackTrace();
        }
    }

    public void gravaErro(Throwable erro) {
        out.print("Data do erro: ");
        out.println(new Date());
        out.print("Mensagem de erro: ");
        out.println(erro);
        out.print("Stacktrace: ");
        erro.printStackTrace(out);
    }

    public void close() {
        if (out != null) {
            out.flush();
            out.close();
        }
    }

}
