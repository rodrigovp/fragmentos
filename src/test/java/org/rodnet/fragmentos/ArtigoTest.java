package org.rodnet.fragmentos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.fragmentos.ObjetosParaTestes.*;

class ArtigoTest {

    private Artigo umArtigo;

    @BeforeEach
    void setUp(){
        umArtigo = umArtigo();
    }

    @Test
    void lerUmArtigo() throws MalformedURLException {
        assertThat(umArtigo.lerNome()).isEqualTo("Apresentação no FalandoEmAgile");
        assertThat(umArtigo.lerLinkOriginal()).isEqualTo(new URL("http://web.archive.org/web/20090203114730/http://blog.fragmental.com.br/2008/10/29/apresentacao-no-falandoemagile/"));
        assertThat(umArtigo.lerData()).isEqualTo(LocalDate.of(2008, 10, 29));
        assertThat(umArtigo.lerParagrafos()).containsExactlyElementsOf(paragrafosDoArtigo());
    }

    @Test
    void igualdadeDeArtigos(){
        Artigo outroArtigo = umArtigo();

        assertThat(umArtigo).isEqualTo(outroArtigo);
    }

    @Test
    void converterParaArquivoHtml() throws IOException {
        File html = umArtigo.toHtml(pastaDeSaida);

        String conteudoDoArquivo = Files.readString(html.toPath());

        assertThat(conteudoDoArquivo).isEqualTo("<html>" +
                "<head><title>Apresentação no FalandoEmAgile</title>" +
                "<meta charset=\"utf-8\">" +
                "</head>" +
                "<body>" +
                "<h2>Apresentação no FalandoEmAgile</h2>" +
                "<p>O evento foi sensacional.</p>" +
                "<p>Apos ficar bufando por meia-hora no palco</p>" +
                "<p>decidi que iria pra casa</p>" +
                "</body>" +
                "</html>");
    }
}
