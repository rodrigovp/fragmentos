package org.rodnet.dewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

@Component
@Profile("!test")
class FragmentosRunner implements CommandLineRunner {

    private URL urlSemente;

    @Autowired
    private TodasCategorias todasCategorias;

    @Autowired
    FragmentosRunner(@Value("${seed.url}") URL urlSemente, TodasCategorias todasCategorias){
        this.urlSemente = urlSemente;
        this.todasCategorias = todasCategorias;
    }

    @Override
    public void run(String... args) throws Exception {
        LeitorDeCategorias leitorDeCategorias = new LeitorDeCategorias(urlSemente);
        for(ResumoDaCategoria rc : leitorDeCategorias.lerCategorias()){
            System.out.println(">>> LENDO ARTIGOS DA CATEGORIA: " + rc.lerNome());
            Set<Artigo> artigosDaCategoria = new LeitorDeArtigos(rc).ler();
            System.out.println(">>> SALVANDO CATEGORIA EM BANCO");
            var categoria = new Categoria(rc, artigosDaCategoria);
            todasCategorias.save(categoria);
        }
    }
}
