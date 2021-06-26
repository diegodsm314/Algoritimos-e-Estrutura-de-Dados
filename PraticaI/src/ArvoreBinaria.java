package src;

import java.util.Objects;

public class ArvoreBinaria {
    private No n;
    
    
    public ArvoreBinaria(){
        this.n =  null;
    }

    private No inserir(Item reg, No p) {
        if(p == null){
            p= new No(reg);
        }
        else if(reg.compara(p.reg)<0)
                p.esq = inserir(reg,p.esq);
        else if(reg.compara(p.reg)>0)
                p.dir = inserir(reg,p.dir);
        else {
            throw new NullPointerException();
        }
        return p;
    }

    private Item pesquisar(Item reg, No p) {

        if (Objects.isNull(p))
            return null;
        else {
            int comp = reg.compara(p.reg);
            if (comp < 0)
                return pesquisar(reg, p.esq);
            else if (comp > 0)
                return pesquisar(reg, p.dir);
            else {
                return p.reg;
            }
        }
    }

    private void imprimir (No p) {
        System.out.println("\t"+p.reg.getChave());

        if (!Objects.isNull(p.dir) && Objects.nonNull(p.esq)) {
            System.out.println(p.esq.reg.getChave()+"\t\t"+p.dir.reg.getChave());
            imprimir(p.esq);
            imprimir(p.dir);
        }
        else if(!Objects.isNull(p) && Objects.nonNull(p.esq)){
            System.out.println(p.esq.reg.getChave());
            imprimir(p.esq);
        }  
        else if(Objects.nonNull(p.dir)){
            System.out.println("\t\t"+p.dir.reg.getChave());
            imprimir(p.dir);
        }    
    }
      

    public void inserir(Item reg) {
        this.n = this.inserir(reg,this.n);
    }

    public Item pesquisar(Item reg) {
        return this.pesquisar(reg,this.n);
    }

    public void imprimir() {
        this.imprimir(this.n);
    }



}
