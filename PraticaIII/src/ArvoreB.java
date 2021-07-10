import java.util.Objects;

public class ArvoreB {
    private Pagina pg;
    private int m, mm;
    private static int contador = 0;

    public ArvoreB(int m) {
        this.pg = null;
        this.m = m;
        this.mm = 2*m;
    }

    private Item pesquisa(Item reg, Pagina apg) {
        if (apg == null)
            return null;
        else{
            contador++;
            int i = 0;
            while((i < apg.n-1) && (reg.compara(apg.it[i])>0)){
                i++;
            }
            if(reg.compara(apg.it[i])==0){
                return apg.it[i];
            } else if(reg.compara(apg.it[i])<0)
                return pesquisa(reg, apg.pg[i]);
            else return pesquisa(reg, apg.pg[i+1]); 
        }
    }


    public void inserir(Item reg) {
        Item regR[] = new Item[1];
        boolean cresceu[] = new boolean[1];

        Pagina apgR =  this.insere(reg, this.pg, regR, cresceu);
        if (cresceu[0]) {
            Pagina apgT = new Pagina(this.mm);
            apgT.it[0] = regR[0];
            apgT.pg[0] = this.pg;
            apgT.pg[1] = apgR;

            this.pg = apgT;
            this.pg.n++;
        } else
            this.pg = apgR;
    }

    private Pagina insere(Item reg, Pagina bpg, Item[] regR, boolean[] cresceu) {
        Pagina bpgR = null;
        if (Objects.isNull(bpg)) {
            cresceu[0] = true;
            regR[0] = reg;
        }
        else{
            int i = 0;
            while((i < bpg.n-1)&&(reg.compara(bpg.it[i])>0)) i++;
            if(reg.compara(bpg.it[i])==0){
                cresceu[0] = false;
                throw new NullPointerException();
            }
            else{
                if(reg.compara(bpg.it[i])>0)
                    i++;
                bpgR = insere(reg, bpg.pg[i], regR, cresceu);
                if (cresceu[0])
                    if (bpg.n<this.mm) {
                        this.insereNaPagina(bpg,regR[0],bpgR);
                        cresceu[0] = false;
                        bpgR = bpg;
                    } 
                    else {                                    //Overflow
                        Pagina bpgT = new Pagina(mm);
                        bpgT.pg[0] = null;
                        if (i<=this.m) {
                            this.insereNaPagina(bpgT,bpg.it[this.mm-1], bpg.pg[this.mm]);
                            bpg.n-=1;
                            this.insereNaPagina(bpg,regR[0],bpgR);
                        } else this.insereNaPagina(bpgT,regR[0],bpgR);

                        for (int j = this.m+1; j < this.mm; j++) {
                            this.insereNaPagina(bpgT,bpg.it[j],bpg.pg[j+1]);
                            bpg.pg[j+1]=null;                   //transfere a memoria
                        }
                        bpg.n = this.m;
                        bpgT.pg[0] = bpg.pg[this.m+1];
                        regR[0] = bpg.it[this.m];
                        bpgR = bpgT; 
                    }
            }
        }
        return (cresceu[0] ? bpgR : bpg);
    }

    private void insereNaPagina(Pagina apg, Item reg, Pagina apgD) {
        int i = apg.n - 1;
        while ((i >= 0) && (reg.compara(apg.it[i]) < 0)) {
            apg.it [i+1] = apg.it[i];
            apg.pg[i+2] = apg.pg[i+1]; 
            i-=1;
        }
        apg.it[i+1] = reg; 
        apg.pg[i+2] = apgD; 
        apg.n++;
    }

    public Item pesquisar(Item reg) {
        return this.pesquisa(reg, this.pg);
    }

    public void imprimir() {
        this.imprime(this.pg);
    }

    private void imprime(Pagina pag) {
        int i = 0;
        if (Objects.nonNull(pag)) {
            for (i = 0; i < pag.n; i++) {
                System.out.print("\t" + pag.it[i].getChave());
            }
            int j = 0;
            while (Objects.nonNull(pag.pg[j])) {
                System.out.println("\n-----------------\n");
                imprime(pag.pg[j]);
                j++;
            }
        }
        System.out.println();
    }

    public int getContador() {
        return contador;
    }
    

}
