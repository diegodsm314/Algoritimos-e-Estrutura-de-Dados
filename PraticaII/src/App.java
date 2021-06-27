package src;

import java.util.Random;

public class App {
    public static void main(String[] args) throws NullPointerException {
        ArvoreSBB arvore = new ArvoreSBB();
        ArvoreSBB arvore2 = new ArvoreSBB();
        Random rand = new Random();
        int random, aux, aux2;

        //Arvore Ordenada
        for(int i = 10000; i<100000; i+=10000){
            Item it = new Item(i);
            arvore.inserir(it);
        }

        System.out.println("Arvore Ordenada:");
        //arvore.imprimir();

        //Teste de tempo e iteraçoes de pesquisa
        long tempoInicial;
        long tempoFinal;
        for (int i = 5000; i < 100000; i+=10000) {
            Item reg = new Item(i);
            aux = reg.getContador();
            tempoInicial = System.nanoTime();
            arvore.pesquisar(reg);
            tempoFinal= System.nanoTime();
            aux2 = reg.getContador();
            System.out.println("n: "+ i+" Iterações: " + (aux2-aux));
            System.out.println("O metodo executou em " + (tempoFinal - tempoInicial)+"ns");
        }

        //Arvore Não Ordenada
        for (int i = 0; i < 9; i++) {
            random = ((1+rand.nextInt(9))*10000);
            Item it = new Item(random);
            try {
                arvore2.inserir(it);
            } catch (NullPointerException e) {
                i--;
            }
        }

        

        System.out.println("Arvore Não Ordenada:");
        //arvore2.imprimir();

        //Teste de tempo e iteraçoes de pesquisa

        for (int i = 5000; i < 100000; i+=10000) {
            Item reg = new Item(i);
            aux = reg.getContador();
            tempoInicial = System.nanoTime();
            arvore2.pesquisar(reg);
            tempoFinal= System.nanoTime();
            aux2 = reg.getContador();
            System.out.println("n: "+ i+" Iterações: " + (aux2-aux));
            System.out.println("O metodo executou em " + (tempoFinal - tempoInicial)+"ns");
        }


    }
}
