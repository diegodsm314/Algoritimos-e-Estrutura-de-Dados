public class Pagina {
    int n;
    Item it[];
    Pagina pg[];

    public Pagina(int mm) {
        this.n = 0;
        this.it = new Item[mm];
        this.pg = new Pagina[mm+1];
    }
    
}
