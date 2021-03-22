package org.rodnet.fragmentos;

import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LeitorDeURLTest {

    @Test
    void lerURLValida() throws ErroDeLeituraException {
        String urlString = "https://www.palmeirasnaotemmundial.com.br";
        Elements elementoComUrl = mock(Elements.class);
        when(elementoComUrl.attr("href")).thenReturn(urlString);

        URL url = LeitorDeURL.ler(elementoComUrl);

        assertThat(url.toString()).isEqualTo(urlString);
    }

    @Test
    void tentarLerUrlInvalida(){
        Elements elementoComUrl = mock(Elements.class);
        when(elementoComUrl.attr("href")).thenReturn("url invalida");

        assertThatThrownBy(() -> LeitorDeURL.ler(elementoComUrl))
                .isInstanceOf(ErroDeLeituraException.class)
                .hasMessageContaining(elementoComUrl.toString());
    }
}
