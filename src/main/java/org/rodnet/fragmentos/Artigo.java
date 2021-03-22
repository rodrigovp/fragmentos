package org.rodnet.fragmentos;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import static java.util.stream.Collectors.toUnmodifiableList;

@Document
public class Artigo {

    @Id
    private UUID id;
    private String nome;
    private URL linkOriginal;
    private LocalDate data;
    private List<Paragrafo> paragrafos;

    private Artigo(String nome, URL linkOriginal, LocalDate data, List<Paragrafo> paragrafos) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.linkOriginal = linkOriginal;
        this.data = data;
        this.paragrafos = paragrafos;
    }

    public static Artigo deHtml(Element element) {
        var a = element.select("a");
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println(a.toString());
        System.out.println("<<<<<<<<<<<<<<");

        String nome = a.attr("title");
        URL linkOriginal = LeitorDeURL.ler(a);
        Elements small = element.select("small");
        LocalDate data = LeitorDeDataDeArtigo.ler(small);

        var paragrafos = element.getElementsByClass("entry")
                .select("p").stream()
                .map(p -> new Paragrafo(p.html()))
                .collect(toUnmodifiableList());

        return new Artigo(nome, linkOriginal, data, paragrafos);
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

    public UUID lerId() {
        return id;
    }

    public LocalDate lerData(){
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigo artigo = (Artigo) o;
        return nome.equals(artigo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
