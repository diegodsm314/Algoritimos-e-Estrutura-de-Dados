package src;

import java.util.Random;

public class App {
    public static void main(String[] args) throws NullPointerException {
        ArvoreBinaria arvore = new ArvoreBinaria();
        ArvoreBinaria arvore2 = new ArvoreBinaria();
        Random rand = new Random();
        int random, aux, aux2;

        //Arvore Ordenada
        for(int i = 1000; i<10000; i+=1000){
            Item it = new Item(i);
            arvore.inserir(it);
        }

        System.out.println("Ordenados:");
        //arvore.imprimir();

        //Teste para gerar o grafico
        long tempoInicial;
        long tempoFinal;
        for (int i = 500; i < 10000; i+=1000) {
            Item reg = new Item(i);
            aux = reg.getContador();
            tempoInicial = System.nanoTime();
            arvore.pesquisar(reg);
            tempoFinal= System.nanoTime();
            aux2 = reg.getContador();
            System.out.println("n: "+ i+" Iterações: " + (aux2-aux));
            System.out.println("O metodo executou em " + (tempoFinal - tempoInicial)+"ns");
        }
        

        //Não ordenada
        for (int i = 0; i < 9; i++) {
            random = ((1+rand.nextInt(9))*1000);
            Item it = new Item(random);
            try {
                arvore2.inserir(it);
            } catch (NullPointerException e) {
                i--;
            }
        }

        System.out.println("Desordenados:");
        //arvore2.imprimir();

        //Teste para gerar o grafico
        for (int i = 500; i < 10000; i+=1000) {
            tempoInicial = System.nanoTime();
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
