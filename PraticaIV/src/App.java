
public class App {
    public static void main(String[] args) throws Exception {
        int[] vet = {1,2,3,4,5,6,7,8,9,10};
        Item[] v = new Item[10];

        //Ordenados crescentes
        for (int i = 0; i < 10; i++) {
            v[i]=new Item(vet[i]*10000);
            System.out.print(v[i].getChave()+" ");
        }
        System.out.println();

        Heap h = new Heap(v);
        h.heapsort(v,v.length-1);
        h.imprimir();
        System.out.println();

        //Ordenados decrescentes
        for (int i = 9; i >= 0; i--) {
            v[i]=new Item(vet[i]*10000);
            System.out.print(v[i].getChave()+" ");
        }
        System.out.println();

        Heap h2 = new Heap(v);
        h2.heapsort(v,v.length-1);
        h2.imprimir();
        System.out.println();

        //Aleatorio
        int[] vet2 = {2,3,1,9,4,5,8,10,7,6};
        for (int i = 0; i < 10; i++) {
            v[i]=new Item(vet2[i]*10000);
            System.out.print(v[i].getChave()+" ");
        }
        System.out.println();

        Heap h3 = new Heap(v);
        h3.heapsort(v,v.length-1);
        h3.imprimir();
        System.out.println();

    }
}
