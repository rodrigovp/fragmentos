package org.rodnet.fragmentos;

import java.util.List;
import java.util.stream.Collectors;

public class TemplateDeArtigo {
    
    private String conteudo;

    public String gerar(Artigo artigo) {
        String template = "<html>" +
                "<head><title>%s</title>" +
                "<meta charset=\"utf-8\">" +
                "</head>" +
                "<body>" +
                "<h2>%s</h2>" +
                "%s" +
                "</body>" +
                "</html>";
        return String.format(template, artigo.lerNome(), artigo.lerNome(), conteudoDo(artigo));
    }

    private String conteudoDo(Artigo artigo) {
        return artigo.lerParagrafos()
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining());
    }
}
