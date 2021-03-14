package org.rodnet.dewards;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LeitorDeCategorias {

    private URL urlSemente;

    public LeitorDeCategorias(URL urlSemente){
        this.urlSemente = urlSemente;
    }

    public Set<ResumoDaCategoria> lerCategorias() throws IOException {
        return Jsoup.parse(urlSemente, 50000)
                .getElementsByClass("cat-item")
                .stream()
                .map(ResumoDaCategoria::deHtml)
                .collect(toSet());
    }
}
