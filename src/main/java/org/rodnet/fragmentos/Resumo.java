package org.rodnet.fragmentos;

import org.jsoup.nodes.Element;

import java.net.URL;

import static java.util.Arrays.stream;

public class Resumo {

    private final String nome;
    private final URL url;

    public Resumo(String nome, URL url) {
        this.nome = nome;
        this.url = url;
    }

    public static final Resumo deHtml(Element categoriaHtml) {
        var elementLink = categoriaHtml.select("a");
        URL link = LeitorDeURL.ler(elementLink);
        String nome = stream(link.getPath().split("/"))
                .reduce((primeiro, segundo) -> segundo)
                .get();
        return new Resumo(nome, link);
    }

    public String lerNome() {
        return nome;
    }

    public URL lerEndereco() {
        return url;
    }
}
