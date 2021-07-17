public class Item {
    private int chave;
    private static int contador;

    public Item(int chave) {
        this.chave = chave;
    }

    public int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Item.contador = contador;
    }

    public int compara(Item it) {
        contador++;
        Item item = it;
        if (this.chave < item.chave)
            return -1;
        else if (this.chave > item.chave)
            return 1;
        return 0;
    }

    public int getChave() {
        return chave;
    }

    public void alteraChave (Object chave) {
        Integer ch = (Integer) chave;
        this.chave = ch.intValue() ;
    }

    public Object recuperaChave ( ) {
        return this.chave; 
    }
        
}