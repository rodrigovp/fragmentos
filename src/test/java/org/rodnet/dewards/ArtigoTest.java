package org.rodnet.dewards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.dewards.ObjetosParaTestes.paragrafosDoArtigo;
import static org.rodnet.dewards.ObjetosParaTestes.umArtigo;

class ArtigoTest {

    private Artigo umArtigo;

    @BeforeEach
    void setUp(){
        umArtigo = umArtigo();
    }

    @Test
    void lerUmArtigo() throws MalformedURLException {
        assertThat(umArtigo.lerId()).isEqualTo(489);
        assertThat(umArtigo.lerNome()).isEqualTo("Permanent Link to Apresentação no FalandoEmAgile");
        assertThat(umArtigo.lerLinkOriginal()).isEqualTo(new URL("http://web.archive.org/web/20090203114730/http://blog.fragmental.com.br/2008/10/29/apresentacao-no-falandoemagile/"));
        assertThat(umArtigo.lerParagrafos()).containsExactlyElementsOf(paragrafosDoArtigo());
    }

    @Test
    void igualdadeDeArtigos(){
        Artigo outroArtigo = umArtigo();

        assertThat(umArtigo).isEqualTo(outroArtigo);
    }
}
