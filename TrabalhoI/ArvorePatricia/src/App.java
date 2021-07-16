import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main (String[] args) {
      ArvorePatricia dicionario = new ArvorePatricia (128);
      String nomeArqTxt = "exemplo1.txt";
      HashMap <String, ArrayList<Integer>> hash = new HashMap<>();
      
      try {
          System.out.println(nomeArqTxt);
        ExtraiPalavra palavra = new ExtraiPalavra(nomeArqTxt);
        ArrayList<Integer> index = new ArrayList<>();
        String retornoPalavra = palavra.proximaPalavra();
        System.out.println(retornoPalavra);
      } catch (FileNotFoundException e) {
          System.out.println("Errou");
      }
      catch(Exception e){
        System.out.println("O erro não é o arquivo");
      }
      


/*
      int min = 32, max = 126;
      
      char vetor[] = new char[max-min+1];
  
      for (int i = min; i <= max; i++)
        vetor[i-min] = (char)i;
  
      // @{\it Gera uma permuta\c{c}\~ao aleat\'oria de chaves dos caracteres UNICODE 32 a  126}@
      PermutacaoRandomica.permut (vetor, vetor.length);
      
      // @{\it Insere cada chave na \'arvore}@
      for (int i = 0; i < vetor.length; i++) { 
        char c = vetor[i];
        dicionario.insere (c);
        System.out.println ("Inseriu chave"+ i + ": " + (int)c + " -- char:" + c);
      }
      dicionario.imprime ();
  
      // @{\it Gera outra permuta\c{c}\~ao aleat\'oria de chaves}@
      PermutacaoRandomica.permut (vetor, vetor.length);
  
      // @{\it Pesquisa cada chave na \'arvore}@
      for (int i = 0; i < vetor.length; i++) {
        char c = vetor[i];
        System.out.println ("Pesquisando chave" + i + ": " + c);
        dicionario.pesquisa (c);
      }
          */
    }
}