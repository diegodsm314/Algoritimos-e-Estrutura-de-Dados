package src;

import java.util.Random;

public class App {
    public static void main(String[] args) throws NullPointerException {
        ArvoreSBB arvore = new ArvoreSBB();
        ArvoreSBB arvore2 = new ArvoreSBB();
        Random rand = new Random();
        int random;

        //Arvore Ordenada
        System.out.println("Arvore Ordenada:");
        for(int i = 1000; i<10000; i+=1000){
            Item it = new Item(i);
            arvore.inserir(it);
        }

        System.out.println("Ordenados:");
        arvore.imprimir();

        //Teste de tempo e iteraçoes de pesquisa

        //Arvore Não Ordenada
        for (int i = 0; i < 9; i++) {
            random = ((1+rand.nextInt(9))*1000);
            Item it = new Item(random);
            try {
                arvore2.inserir(it);
            } catch (NullPointerException e) {
                i--;
            }
        }

        //Teste de tempo e iteraçoes de pesquisa

        System.out.println("Desordenados:");
        arvore2.imprimir();


    }
}
