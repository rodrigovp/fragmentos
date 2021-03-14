package org.rodnet.dewards;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LeitorDeArtigos {

    private ResumoDaCategoria resumoDaCategoria;

    public LeitorDeArtigos(ResumoDaCategoria resumoDaCategoria) {
        this.resumoDaCategoria = resumoDaCategoria;
    }

    public Set<Artigo> ler() throws IOException {

        return Jsoup.parse(resumoDaCategoria.lerEndereco(), 50000)
                .getElementsByClass("post")
                .stream()
                .map(Artigo::deHtml)
                .collect(toSet());
    }
}
