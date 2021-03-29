package org.rodnet.fragmentos;

import java.util.Objects;

class Conteudo {

    private String conteudo;

    Conteudo(String conteudo){
        this.conteudo = conteudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(this.conteudo, conteudo.conteudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conteudo);
    }

    @Override
    public String toString(){
        return conteudo;
    }
}
