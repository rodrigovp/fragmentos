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
                "<head><title>Apresentação no FalandoEmAgile</title>" +
                "<meta charset=\"utf-8\">" +
                "</head>" +
                "<body>" +
                "<h2>Apresentação no FalandoEmAgile</h2>" +
                "<div class=\"entry\"> \n" +
                " <p>O evento foi sensacional.</p> \n" +
                " <p>Apos ficar bufando por meia-hora no palco</p> \n" +
                " <p>decidi que iria pra casa</p> \n" +
                "</div></body>" +
                "</html>");
    }
}