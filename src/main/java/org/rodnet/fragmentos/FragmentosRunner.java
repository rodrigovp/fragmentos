package org.rodnet.fragmentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
class FragmentosRunner {

    private Importacao importacao;
    private GeracaoDeHtml geracaoDeHtml;

    @Autowired
    FragmentosRunner(Importacao importacao, GeracaoDeHtml geracaoDeHtml){
        this.importacao = importacao;
        this.geracaoDeHtml = geracaoDeHtml;
    }

    public void run() throws Exception {
        System.out.println(">>> COMEÇANDO A IMPORTAÇÃO PARA BANCO");
        importacao.execute();
        System.out.println(">>> GERANDO OS ARTIGOS EM HTML");
        geracaoDeHtml.execute();
    }
}
