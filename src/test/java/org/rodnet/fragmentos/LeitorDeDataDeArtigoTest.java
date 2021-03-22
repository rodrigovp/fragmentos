package org.rodnet.fragmentos;

import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LeitorDeDataDeArtigoTest {

    @Test
    void lerData(){
        testarDatas("<small>Wednesday, October 29th, 2008</small>", LocalDate.of(2008, 10, 29));
        testarDatas("<small>Thursday, April 3rd, 2008</small>", LocalDate.of(2008, 4, 3));
        testarDatas("<small>Sunday, December 2nd, 2007</small>", LocalDate.of(2007, 12, 2));
        testarDatas("<small>Sunday, December 1st, 2007</small>", LocalDate.of(2007, 12, 1));
    }

    private void testarDatas(String dataHtml, LocalDate dataEsperada){
        Elements elementoHtmlComData = mock(Elements.class);
        when(elementoHtmlComData.toString()).thenReturn(dataHtml);

        LocalDate dataLida = LeitorDeDataDeArtigo.ler(elementoHtmlComData);

        assertThat(dataLida).isEqualTo(dataEsperada);
    }
}