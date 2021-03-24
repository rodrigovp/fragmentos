package org.rodnet.fragmentos;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import static java.util.stream.Collectors.toUnmodifiableList;

@Document
public class Artigo {

    private String nome;
    private URL linkOriginal;
    private LocalDate data;
    private List<Paragrafo> paragrafos;

    private Artigo(String nome, URL linkOriginal, LocalDate data, List<Paragrafo> paragrafos) {
        this.nome = nome;
        this.linkOriginal = linkOriginal;
        this.data = data;
        this.paragrafos = paragrafos;
    }

    public static Artigo deHtml(Element element) {
        var a = element.select("a");
        String nome = a.attr("title").replace("Permanent Link to", "").trim();
        URL linkOriginal = LeitorDeURL.ler(a);
        Elements small = element.select("small");
        LocalDate data = LeitorDeDataDeArtigo.ler(small);

        var paragrafos = element.getElementsByClass("entry")
                .select("p").stream()
                .map(p -> new Paragrafo(p.toString()))
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

    public LocalDate lerData(){
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigo artigo = (Artigo) o;
        return linkOriginal.equals(artigo.linkOriginal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkOriginal);
    }

    public File toHtml(File pastaDeSaida) {
        TemplateDeArtigo template = new TemplateDeArtigo();
        String conteudo = template.gerar(this);

        File arquivo = new File(pastaDeSaida, montarNomeArquivo());

        try(FileWriter escritor = new FileWriter(arquivo, StandardCharsets.UTF_8)) {
            escritor.write(conteudo);
            escritor.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arquivo;
    }

    private String montarNomeArquivo() {
        return this.data.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                + "-"
                + this.lerNome()
                .replaceAll(" ", "-")
                .replaceAll("/", "-") + ".html";
    }
}
