package src;

// Codigo baseado no Ziviani (livro)

import java.util.Objects;

public class ArvoreSBB {
    private static final byte horizontal = 0;
    private static final byte vertical = 1;
    private No n;
    private boolean propSBB;

    public ArvoreSBB() {
        this.n = null;
        this.propSBB = true;
    }

    private No ee(No ap) {
        No ap1 = ap.esq;
        ap.esq = ap1.dir;
        ap1.dir = ap;
        ap1.incE = vertical;
        ap.incE = vertical;
        ap = ap1;
        return ap;
    }

    private No ed(No ap) {
        No ap1 = ap.esq;
        No ap2 = ap1.dir;
        ap1.incD = vertical;
        ap.incE = vertical;
        ap1.dir = ap2.esq;
        ap2.esq = ap1;
        ap.esq = ap2.dir;
        ap2.dir = ap;
        ap = ap2;
        return ap;
    }

    private No dd(No ap) {
        No ap1 = ap.dir;
        ap.dir = ap1.esq;
        ap1.esq = ap;
        ap1.incD = vertical;
        ap.incD = vertical;
        ap = ap1;
        return ap;
    }

    private No de(No ap) {
        No ap1 = ap.dir;
        No ap2 = ap1.esq;
        ap1.incE = vertical;
        ap.incD = vertical;
        ap1.esq = ap2.dir;
        ap2.dir = ap1;
        ap.dir = ap2.esq;
        ap2.esq = ap;
        ap = ap2;
        return ap;
    }

    public No inserir(Item reg, No princ, No filho, boolean filhoEsq) {
        if (filho == null) {
            filho = new No();
            filho.reg = reg;
            filho.incE = vertical;
            filho.incD = vertical;
            filho.esq = null;
            filho.dir = null;
            if (princ != null)
                if (filhoEsq)
                    princ.incE = horizontal;
                else
                    princ.incD = horizontal;
            this.propSBB = false;
        } else if (reg.compara(filho.reg) < 0) {
            filho.esq = inserir(reg, filho, filho.esq, true);
            if (!this.propSBB)
                if (filho.incE == horizontal) {
                    if (filho.esq.incE == horizontal) {
                        filho = this.ee(filho);
                        if (princ != null)
                            if (filhoEsq)
                                princ.incE = horizontal;
                            else
                                princ.incD = horizontal;
                    } else if (filho.esq.incD == horizontal) {
                        filho = this.ed(filho);
                        if (princ != null)
                            if (filhoEsq)
                                princ.incE = horizontal;
                            else
                                princ.incD = horizontal;
                    }
                } else
                    this.propSBB = true;
        } else if (reg.compara(filho.reg) > 0) {
            filho.dir = inserir(reg, filho, filho.dir, false);
            if (!this.propSBB)
                if (filho.incD == horizontal) {
                    if (filho.dir.incD == horizontal) {
                        filho = this.dd(filho);
                        if (princ != null)
                            if (filhoEsq)
                                princ.incE = horizontal;
                            else
                                princ.incD = horizontal;
                    } else if (filho.dir.incE == horizontal) {
                        filho = this.de(filho);
                        if (princ != null)
                            if (filhoEsq)
                                princ.incE = horizontal;
                            else
                                princ.incD = horizontal;
                    }
                } else
                    this.propSBB = true;
        } else {
            this.propSBB = true;
            throw new NullPointerException();
        }
        return filho;
    }

    private Item pesquisar(Item reg, No p) {
        if (p == null)
            return null;
        else {
            int comparador = reg.compara(p.reg);
            if (comparador < 0)
                return pesquisar(reg, p.esq);
            else if (comparador > 0)
                return pesquisar(reg, p.dir);
            else
                return p.reg;
        }
    }

    public Item pesquisa (Item reg) {
        return this.pesquisar(reg, this.n);
    }

    public void inserir(Item reg) {
        this.n = inserir(reg, null, this.n, true);
    }

    private void imprimir(No p) {
        System.out.print("\t" + p.reg.getChave());

        if (!Objects.isNull(p.dir) && Objects.nonNull(p.esq)) {
            System.out.println("\t" + p.dir.reg.getChave()+"\n"+ p.esq.reg.getChave());
            imprimir(p.esq);
            imprimir(p.dir);
        } else if (!Objects.isNull(p) && Objects.nonNull(p.esq)) {
            System.out.println("\n"+p.esq.reg.getChave());
            imprimir(p.esq);
        } else if (Objects.nonNull(p.dir)) {
            System.out.println("\t" + p.dir.reg.getChave());
            imprimir(p.dir);
        }
        else
            System.out.println();
    }

    public void imprimir() {
        this.imprimir(this.n);
    }

}
