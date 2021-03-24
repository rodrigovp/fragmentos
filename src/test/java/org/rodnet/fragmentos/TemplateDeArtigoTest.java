package org.rodnet.fragmentos;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.fragmentos.ObjetosParaTestes.umArtigo;

class TemplateDeArtigoTest {

    @Test
    void preencherComArtigo(){
        Artigo artigo = umArtigo();
        TemplateDeArtigo template = new TemplateDeArtigo();

        assertThat(template.gerar(artigo)).isEqualTo("<html>" +
                "<head><title>Permanent Link to Apresentação no FalandoEmAgile</title>" +
                "<meta charset=\"utf-8\">" +
                "</head>" +
                "<body>" +
                "<h2>Permanent Link to Apresentação no FalandoEmAgile</h2>" +
                "<p>O evento foi sensacional.</p>" +
                "<p>Apos ficar bufando por meia-hora no palco</p>" +
                "<p>decidi que iria pra casa</p>" +
                "</body>" +
                "</html>");
    }
}