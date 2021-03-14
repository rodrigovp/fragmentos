package org.rodnet.dewards;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.Set;


@Document
class Categoria {

    @Id
    private String nome;
    private final ResumoDaCategoria resumo;
    private final Set<Artigo> artigos;

    Categoria(ResumoDaCategoria resumo, Set<Artigo> artigos) {
        this.resumo = resumo;
        this.artigos = artigos;
        this.nome = resumo.lerNome();
    }

    public String lerNome() {
        return nome;
    }

    public Set<Artigo> lerArtigos() {
        return Collections.unmodifiableSet(artigos);
    }
}
