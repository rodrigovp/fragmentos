package org.rodnet.dewards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.dewards.ObjetosParaTestes.resumoCategoriaBrasil;

class LeitorDeArtigosTest {

    private LeitorDeArtigos leitor;

    @BeforeEach
    void setUp(){
        ResumoDaCategoria resumoDaCategoria = resumoCategoriaBrasil();
        this.leitor = new LeitorDeArtigos(resumoDaCategoria);
    }

    @Test
    void lerArtigosDeUmaCategoriaSemPaginacao() throws IOException, ErroDeLeituraException {
        var artigos = leitor.ler();

        assertThat(artigos).hasSizeGreaterThan(1);
    }
}
