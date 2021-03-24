package org.rodnet.fragmentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
class GeracaoDeHtml {

    private TodosArtigos todosArtigos;
    private File pastaDeSaida;

    @Autowired
    GeracaoDeHtml(TodosArtigos todosArtigos,
        @Value("${pasta.saida}") File pastaDeSaida){
        this.todosArtigos = todosArtigos;
        this.pastaDeSaida = pastaDeSaida;
    }

    public void execute(){
        todosArtigos.findAll().forEach(artigo -> artigo.toHtml(pastaDeSaida));
    }
}
