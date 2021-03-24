package org.rodnet.fragmentos;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LeitorDeArtigos {

    public Set<Artigo> ler(URL url) throws IOException {
        return Jsoup.parse(url, 50000)
                .getElementsByClass("post")
                .stream()
                .map(Artigo::deHtml)
                .collect(toSet());
    }
}
