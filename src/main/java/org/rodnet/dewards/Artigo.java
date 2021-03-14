package org.rodnet.dewards;

import org.jsoup.nodes.Element;

import java.net.URL;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Artigo {

    private Integer id;
    private String nome;
    private URL linkOriginal;
    private List<Paragrafo> paragrafos;

    private Artigo(Integer id, String nome, URL linkOriginal, List<Paragrafo> paragrafos) {
        this.id = id;
        this.nome = nome;
        this.linkOriginal = linkOriginal;
        this.paragrafos = paragrafos;
    }

    public static Artigo deHtml(Element element) {
        var a = element.select("a");
        Integer id = Integer.valueOf(element.select("h3")
                .attr("id")
                .replace("post-", ""));
        String nome = a.attr("title");
        URL linkOriginal = LeitorDeURL.ler(a);

        var paragrafos = element.getElementsByClass("entry")
                .select("p").stream()
                .map(p -> new Paragrafo(p.html()))
                .collect(toUnmodifiableList());

        return new Artigo(id, nome, linkOriginal, paragrafos);
    }

    public String lerNome() {
        return nome;
    }

    public URL lerLinkOriginal() {
        return linkOriginal;
    }

    public List<Paragrafo> lerParagrafos() {
        return paragrafos;
    }

    public Integer lerId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigo artigo = (Artigo) o;
        return id.equals(artigo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
