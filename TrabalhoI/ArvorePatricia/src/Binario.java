public class Binario {
    String str;

    public Binario() {
        this.str = "";
    }

    public String getStr() {
        return str;
    }

    //metodo para pegar a palavra e retornar em binario
    public String getbin(String plv) {
        transformaBin(plv);
        return this.str;
    }

    //Função que transforma a palavra em binario
    public void transformaBin(String plv){
        char vect[] = plv.toCharArray();
        for(int j = 0 ; j<vect.length && j<16; j++){
            int bin = (int)vect[j];
            if(vect[j] < 58){               //hifens e numeros
                this.str += "00";
            }
            else this.str += "0";           //letras
            this.str += Integer.toBinaryString(bin);   
        }
        if(vect.length<16){
            int restante = 16 -vect.length;
            for(int i =0; i< restante ; i++){
                this.str += "00000000";     //completar palavra de 128 bits
            }
        }
    }
}