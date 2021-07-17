public class Heap {
    private Item it[];
    private int n;


    public Heap(Item[] it) {
        this.it = it;
        this.n = this.it.length-1;
    }

    public void refaz(int esq, int dir) {
        int i = esq*2;  
        Item item = this.it[esq];
        while(i<=dir){
            if ((i<dir) && (this.it[i].compara(this.it[i+1])<0)) {
                i++;
            }
            if(item.compara(this.it[i])>=0){
                break;
            }
            this.it[esq]=this.it[i];
            this.it[i]=item;
            esq = i;
            i=esq*2;
        }
    }

    public void constroi() {
        int esq = (n/2)+1;

        while(esq>0){
            esq--;
            this.refaz(esq, this.n);
        }
    }


    public void heapsort(Item v[], int n) {
        Heap heap = new Heap(v);
        int dir = n;
        heap.constroi();
        int i = 1;
        while(dir>i){
            Item item = v[dir-i];
            int inicio = v[i].getContador();
            v[dir-i]=v[dir];
            v[dir] = item;
            dir-=1;
            heap.refaz(i, dir);
            i++;
            int fim = v[i].getContador();
            System.out.println("Numero de comparações: "+(fim-inicio));
        }
    }

    private void imprime(Item[] item) {
        for (int i = 0; i < it.length; i++) {
            System.out.print(it[i].getChave()+" ");
        }
    }

    public void imprimir(){
        imprime(this.it);
    }
    
    
}
