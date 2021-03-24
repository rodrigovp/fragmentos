package org.rodnet.fragmentos;

import java.util.Objects;

class Paragrafo {

    private String conteudo;

    Paragrafo(String conteudo){
        this.conteudo = conteudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragrafo paragrafo = (Paragrafo) o;
        return Objects.equals(conteudo, paragrafo.conteudo);
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
