import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class App {
    public static void main (String[] args) {
      //declaração das variaveis gerais
      ArvorePatricia patricia = new ArvorePatricia (128);
      String nomeArqTxt = "/mnt/c/Users/digod/OneDrive/Documentos2/CEFET/Algoritimos-e-Estrutura-de-Dados/TrabalhoI/ArvorePatricia/src/exemplo2.txt";
      HashMap <String, ArrayList<Integer>> hash = new HashMap<>();          //para fazer o mapeamento das posições das palavras
      int posicao = 0;
      boolean parar = false;                                                //para para a estrutura de repetição

      try {
        ExtraiPalavra palavra = new ExtraiPalavra(nomeArqTxt);

        while (!parar) {
          ArrayList<Integer> index = new ArrayList<>();
          String retornoPalavra = palavra.proximaPalavra().toLowerCase();    //variavel da proxima palavra 

          if (!retornoPalavra.equals("") && !Character.isDigit(retornoPalavra.toCharArray()[0])
              && !retornoPalavra.equals("pararcodigo")) {
            //atualiza a posição a cada iteração
            posicao++;
            //VERIFICAÇÃO DA PALAVRA NO HASHMAP:
            if (Objects.isNull(hash.get(retornoPalavra))) {                   
              index.add(posicao);
              hash.put(retornoPalavra, index);
              Binario bin = new Binario();
              retornoPalavra = bin.getbin(retornoPalavra);
              patricia.insere(retornoPalavra);
            } else {                                                //Se não, apenas adiciona a outra posição no ArrayList
              hash.get(retornoPalavra).add(posicao);
            }
          }
          if (retornoPalavra == "pararcodigo") {
            parar = true;
          }
        }
      //TRATAMENTO DE ERROS
      } catch (FileNotFoundException e) {       
        System.out.println("File error");
      } catch (NullPointerException e) {
        System.err.println("Null error");
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }

      //TESTE DO RELATORIO
      String plv[] = {"sociedade","software", "ideia", "pessoa", "informatica", "etica", 
        "muito", "ciencia", "computacao", "que", "area", "moral"};
      
      for (String i : plv) {
        Binario pesqbin = new Binario();
        System.out.println("Palavra: "+i);
        String pesq = pesqbin.getbin(i);
        patricia.pesquisa(pesq);
        for (int j = 0; j < hash.get(i).size() ; j++) {
          System.out.print(hash.get(i).get(j)+"; ");
        }
        System.out.println("\n");
      }

    }
}