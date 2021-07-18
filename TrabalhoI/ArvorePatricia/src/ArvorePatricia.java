public class ArvorePatricia {
    private static abstract class PatNo { }
    private static class PatNoInt extends PatNo {
      int index; PatNo esq, dir;
    }  
    private static class PatNoExt extends PatNo {
      String chave; // @{O tipo da chave depende da aplicação}
    }
    
    private PatNo raiz;
    private int nbitsChave;
   
    // @{Retorna o i-esimo bit da chave k (String) a partir da esquerda}@
    private int bit (int i, String k) {
      if(k.toCharArray()[i-1] == '0'){
        return 0;
      }
      return 1;
    }
  
    // @{Verifica se p é nó externo}@
    private boolean eExterno (PatNo p) {
      return p.getClass().getName().equals(PatNoExt.class.getName());
    }
  
    private PatNo criaNoInt (int i, PatNo esq, PatNo dir) {
      PatNoInt p = new PatNoInt ();
      p.index = i; p.esq = esq; p.dir = dir;
      return p;
    }
    
    //Cria nó externo do String k
    private PatNo criaNoExt (String k) {
      PatNoExt p = new PatNoExt ();
      p.chave = k;
      return p;
    }
    
    //Faz a pesquisa do No a partir do string k
    private void pesquisa (String k, PatNo t) {
      if (this.eExterno (t)) {
        PatNoExt aux = (PatNoExt)t;
        if (aux.chave.equals(k)) System.out.println ("Elemento encontrado");
        else System.out.println ("Elemento nao encontrado");
      }
      else { 
        PatNoInt aux = (PatNoInt)t;
        if (this.bit (aux.index, k) == 0) pesquisa (k, aux.esq);
        else pesquisa (k, aux.dir);
      }
    }
  
    private PatNo insereEntre (String k, PatNo t, int i) {
      PatNoInt aux = null; 
      if (!this.eExterno (t)) aux = (PatNoInt)t;
      if (this.eExterno (t) || (i < aux.index)) { // @{Cria um novo no externo}@
        PatNo p = this.criaNoExt (k);
        if (this.bit (i, k) == 1) return this.criaNoInt (i, t, p);
        else return this.criaNoInt (i, p, t);
      }
      else {
        if (this.bit (aux.index, k) == 1) 
          aux.dir = this.insereEntre (k, aux.dir, i);
        else aux.esq = this.insereEntre (k, aux.esq, i);
        return aux;
      }
    }

    //inserção na arvore patricia do string passado
    private PatNo insere (String k, PatNo t) {
      if (t == null) return this.criaNoExt (k);
      else {
        PatNo p = t;
        while (!this.eExterno(p)) {
          PatNoInt aux = (PatNoInt)p;
          if (this.bit (aux.index, k) == 1) p = aux.dir; else p = aux.esq;
        }
        PatNoExt aux = (PatNoExt)p;
        int i = 1; // @{acha o primeiro bit diferente}@
        while ((i <= this.nbitsChave)&&
               (this.bit (i, k) == this.bit (i, aux.chave))) i++;
        if (i > this.nbitsChave) {
          System.out.println ("Erro: chave ja esta na arvore"); 
          return t;
        }
        else return this.insereEntre (k, t, i);
      }
    }
    
  
    public ArvorePatricia (int nbitsChave) {
      this.raiz = null; this.nbitsChave = nbitsChave; 
    }
    
    public void pesquisa (String k) { this.pesquisa (k, this.raiz); }
    
    public void insere (String k) { this.raiz = this.insere (k, this.raiz); } 
  }
