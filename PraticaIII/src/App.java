//import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        

        System.out.println("Digite o valor de m");
        int m = input.nextInt();
        ArvoreB arvore = new ArvoreB(m);

        input.close();

        //Ordenados
        for (int i = 10000; i < 100000; i+=1000) {
            Item it=new Item(i);
            arvore.inserir(it);
        }

        System.out.println("Arvore Ordenada:");
        arvore.imprimir();

        for (int i = 5500; i < 100000; i+=10000) {
            Item it = new Item(i);
            int inicio = arvore.getContador();
            arvore.pesquisar(it);
            int fim = arvore.getContador();
            System.out.println("Numero de iterações:"+(fim-inicio));
        }

        /*
        Random rand = new Random();
        //ArvoreB arvore2 = new ArvoreB(m);
        //Não ordenados
        for (int i = 1; i < 10; i+=1) {
            int random = 1 + rand.nextInt(9);
            Item it=new Item(random*10000);
            try {
                arvore2.inserir(it);
            } catch (Exception e) {
                i-=1;
            } 
        }

        System.out.println("Arvore Não ordenada:");
        arvore2.imprimir();

        for (int i = 5000; i < 100000; i+=10000) {
            Item it = new Item(i);
            int inicio = arvore.getContador();
            arvore2.pesquisar(it);
            int fim = arvore.getContador();
            System.out.println("Numero de iterações:"+(fim-inicio));
        }
        */

    }
}
