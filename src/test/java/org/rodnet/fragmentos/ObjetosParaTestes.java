package org.rodnet.fragmentos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.File;
import java.net.URL;
import java.util.List;

class ObjetosParaTestes {

    static final String urlDaCategoriaDeArtigos = "http://web.archive.org/web/20090219234802/http://blog.fragmental.com.br/category/artigos/";
    static final String urlDaCategoriaBrasil = "http://web.archive.org/web/20090219234802/http://blog.fragmental.com.br/category/brasil/";
    static final File pastaDeSaida = new File("src/test/resources/pastaSaidaTeste");


    static final Artigo umArtigo(){
        return Artigo.deHtml(umElementoHtmlDeArtigo());
    }

    static final Element umElementoHtmlDeResumoDeCategoria(String url){
        String html = String.format("<li class=\"cat-item cat-item-57\"><a href=\"%s\" title=\"View all posts filed under australia\">australia</a>", url);
        return Jsoup.parse(html);
    }

    static final Element umElementoHtmlDeArtigo(){
        String html = "<div class=\"post\">\n" +
                "\t\t\t\t<h3 id=\"post-489\"><a href=\"http://web.archive.org/web/20090203114730/http://blog.fragmental.com.br/2008/10/29/apresentacao-no-falandoemagile/\" rel=\"bookmark\" title=\"Permanent Link to Apresentação no FalandoEmAgile\">Apresentação no FalandoEmAgile</a></h3>\n" +
                "\t\t\t\t<small>Wednesday, October 29th, 2008</small>\n" +
                "\n" +
                "\t\t\t\t<div class=\"entry\">\n" +
                "\t\t\t\t\t<p>O evento foi sensacional.</p>\n" +
                "<p>Apos ficar bufando por meia-hora no palco</p>\n" +
                "<p>decidi que iria pra casa</p>\n" +
                "</div>\n" +
                "</div>\n";
        return Jsoup.parse(html);
    }

    static final List<Paragrafo> paragrafosDoArtigo(){
        return List.of(new Paragrafo("<p>O evento foi sensacional.</p>"),
        new Paragrafo("<p>Apos ficar bufando por meia-hora no palco</p>"),
        new Paragrafo("<p>decidi que iria pra casa</p>"));
    }
}
