package src;
public class Item {
    private int chave;
    public static int contador;
    
    public Item(int chave) {
        this.chave = chave;
    }

    public int compara(Item it) {
        Item item = it;
        contador++;
        if (this.chave < item.chave)
            return -1;
        else if (this.chave > item.chave)
            return 1;
        return 0;
    }
    
    public int getChave() {
        return chave;
    }

    public int getContador() {
        return Item.contador;
    }
}
