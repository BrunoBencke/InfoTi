package apoio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador {

    //Constantes
    static final int TAMANHO_BUFFER = 4096; // 4kb

    //método para compactar arquivo
    public static void compactarParaZip(String arqSaida, String arqEntrada)
            throws IOException {
        int cont;
        byte[] dados = new byte[TAMANHO_BUFFER];

        BufferedInputStream origem = null;
        FileInputStream streamDeEntrada = null;
        FileOutputStream destino = null;
        ZipOutputStream saida = null;
        ZipEntry entry = null;

        try {
            File fileSaida = new File(arqSaida);
            destino = new FileOutputStream(fileSaida);
            saida = new ZipOutputStream(new BufferedOutputStream(destino));
            File file = new File(arqEntrada);
            streamDeEntrada = new FileInputStream(file);
            origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
            entry = new ZipEntry(file.getName());
            saida.putNextEntry(entry);

            while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
                saida.write(dados, 0, cont);
            }
            origem.close();
            saida.close();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            //Compactador.compactarParaZip("C:\\Users\\Christian\\Documents\\zipando.zip", "C:\\Users\\Christian\\Documents\\zipando.txt");
            Compactador.compactarParaZip("C:\\tmp\\InfoTi.zip","C:\\tmp\\texto.docx");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
