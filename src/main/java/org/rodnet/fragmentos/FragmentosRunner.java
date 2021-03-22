package org.rodnet.fragmentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Collection;
import java.util.Set;

@Component
@Profile("!test")
class FragmentosRunner implements CommandLineRunner {

    private URL urlSemente;

    @Autowired
    private TodosArtigos todosArtigos;

    @Autowired
    FragmentosRunner(@Value("${seed.url}") URL urlSemente, TodosArtigos todosArtigos){
        this.urlSemente = urlSemente;
        this.todosArtigos = todosArtigos;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        LeitorDeCategorias leitorDeCategorias = new LeitorDeCategorias(urlSemente);
//        for(ResumoDaCategoria rc : leitorDeCategorias.lerCategorias()){
//
//            System.out.println(">>> LENDO ARTIGOS DA CATEGORIA: " + rc.lerNome());
//            Set<Artigo> artigosDaCategoria = new LeitorDeArtigos(rc).ler();
//            System.out.println(">>> SALVANDO ARTIGOS EM BANCO");
//            todosArtigos.saveAll(artigosDaCategoria);
//        }
//    }

    @Override
    public void run(String... args) throws Exception {
        LeitorDeArtigosPorMes leitor = new LeitorDeArtigosPorMes(urlSemente);
        Set<Resumo> resumos = leitor.lerArtigosPorMes();
        for(Resumo rc : resumos){
            System.out.println(">>> LENDO ARTIGOS DO MES: " + rc.lerNome());
            Collection<Artigo> artigosDoMes = new LeitorDeArtigos(rc).ler();
            System.out.println(">>> SALVANDO ARTIGOS EM BANCO");
            todosArtigos.saveAll(artigosDoMes);
        }
    }
}
