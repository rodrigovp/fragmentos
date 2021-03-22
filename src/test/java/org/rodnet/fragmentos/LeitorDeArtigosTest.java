package org.rodnet.fragmentos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.fragmentos.ObjetosParaTestes.resumoCategoriaBrasil;

class LeitorDeArtigosTest {

    private LeitorDeArtigos leitor;

    @BeforeEach
    void setUp(){
        Resumo resumo = resumoCategoriaBrasil();
        this.leitor = new LeitorDeArtigos(resumo);
    }

    @Test
    void lerArtigosDeUmaCategoriaSemPaginacao() throws IOException, ErroDeLeituraException {
        var artigos = leitor.ler();

        assertThat(artigos).hasSizeGreaterThan(1);
    }
}
