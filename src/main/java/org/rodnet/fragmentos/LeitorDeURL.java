package org.rodnet.fragmentos;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

class LeitorDeURL {

    private LeitorDeURL(){}

    static final URL ler(Elements elementoUrlComURL) throws ErroDeLeituraException{
        URL url = null;
        try {
            url = new URL(elementoUrlComURL.attr("href"));
        } catch (MalformedURLException e) {
            String mensagemDeErro = format("problemas na leitura de link: %s", elementoUrlComURL);
            throw new ErroDeLeituraException(mensagemDeErro, e);
        }
        return url;
    }

    static final URL ler(Element elementoUrlComURL) throws ErroDeLeituraException{
        URL url = null;
        try {
            url = new URL(elementoUrlComURL.attr("href"));
        } catch (MalformedURLException e) {
            String mensagemDeErro = format("problemas na leitura de link: %s", elementoUrlComURL);
            throw new ErroDeLeituraException(mensagemDeErro, e);
        }
        return url;
    }
}
