package org.rodnet.fragmentos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.fragmentos.ObjetosParaTestes.urlDaCategoriaBrasil;

class LeitorDeArtigosTest {

    private LeitorDeArtigos leitor;

    @BeforeEach
    void setUp() throws MalformedURLException {
        this.leitor = new LeitorDeArtigos();
    }

    @Test
    void lerArtigosDeUmaCategoriaSemPaginacao() throws IOException, ErroDeLeituraException {
        var artigos = leitor.ler(new URL(urlDaCategoriaBrasil));

        assertThat(artigos).hasSizeGreaterThan(1);
    }
}
