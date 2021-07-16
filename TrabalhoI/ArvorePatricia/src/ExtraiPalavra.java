import java.util.StringTokenizer;
import java.io.*;
public class ExtraiPalavra {
  private BufferedReader arqTxt;
  private StringTokenizer palavras;
  private String delimitadores;

  public ExtraiPalavra (String nomeArqTxt) 
  throws Exception {
    this.arqTxt = new BufferedReader (new FileReader (nomeArqTxt));
    // @{\it Os delimitadores devem estar juntos em uma \'unica linha do arquivo}@ 
    this.delimitadores = "\r\n\t "; 
    this.palavras = null;
  }  
  
  public String proximaPalavra () throws Exception{
    if (palavras == null || !palavras.hasMoreTokens()) {
      String linha = arqTxt.readLine();
      if (linha == null) return null; 
      this.palavras = new StringTokenizer (linha, this.delimitadores);
      if (!palavras.hasMoreTokens()) return ""; // @{\it ignora delimitadores}@
    }
    return this.palavras.nextToken ();
  }  
  public void fecharArquivos () throws Exception {
    this.arqTxt.close();
  }
}