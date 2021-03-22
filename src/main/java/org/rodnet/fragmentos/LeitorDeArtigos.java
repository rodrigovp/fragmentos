package org.rodnet.fragmentos;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LeitorDeArtigos {

    private Resumo resumo;

    public LeitorDeArtigos(Resumo resumo) {
        this.resumo = resumo;
    }

    public Set<Artigo> ler() throws IOException {

        return Jsoup.parse(resumo.lerEndereco(), 50000)
                .getElementsByClass("post")
                .stream()
                .map(Artigo::deHtml)
                .collect(toSet());
    }
}
