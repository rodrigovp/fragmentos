package org.rodnet.fragmentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Set;

@Component
public class Importacao {

    private URL urlSemente;

    @Autowired
    private TodosArtigos todosArtigos;

    public Importacao(@Value("${seed.url}") URL urlSemente, TodosArtigos todosArtigos) {
        this.urlSemente = urlSemente;
        this.todosArtigos = todosArtigos;
    }

    public void execute() throws Exception {
        LeitorDeArtigosPorMes leitorDeArtigos = new LeitorDeArtigosPorMes(urlSemente);
        LeitorDeArtigos leitorDeArtigosDoMes = new LeitorDeArtigos();
        Set<URL> urls = leitorDeArtigos.lerArtigosPorMes();
        for(URL url : urls){
            System.out.println(">>> LENDO ARTIGOS DO LINK: " + url);
            Set<Artigo> artigosDoMes = leitorDeArtigosDoMes.ler(url);
            System.out.println(">>> SALVANDO ARTIGOS EM BANCO");
            todosArtigos.saveAll(artigosDoMes);
        }
    }
}
