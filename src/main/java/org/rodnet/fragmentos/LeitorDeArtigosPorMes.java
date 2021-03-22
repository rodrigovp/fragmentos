package org.rodnet.fragmentos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

public class LeitorDeArtigosPorMes {

    private URL urlSemente;

    public LeitorDeArtigosPorMes(URL urlSemente) {
        this.urlSemente = urlSemente;
    }

    public Set<Resumo> lerArtigosPorMes() throws IOException {
        Document parse = Jsoup.parse(urlSemente, 50000);
        Element sidebar = parse.getElementById("sidebar");
        Elements li = sidebar.select("li");
        Elements a = li.select("a");

        Set<Resumo> resumos = new HashSet<>();
        for(Element element : a){
            URL url = LeitorDeURL.ler(element);
            String nome = stream(url.getPath().split("/"))
                    .reduce((primeiro, segundo) -> primeiro+"-"+segundo)
                    .get();
            if(url.toString().contains("fragmental") && !nome.equals("-web-20090219234802-http:--blog.fragmental.com.br-artigos")){
                resumos.add(new Resumo(nome, url));
            }

        }

        return resumos;
    }
}
