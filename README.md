## Fragmentos 

_Crawler_ simples do antigo blog do [Phillip Calçado](https://github.com/pcalcado) (também conhecido como _"shoes"_, Phil Calçado, ou só Phil mesmo) http://www.fragmental.com.br

Para quem gostava dos seus artigos, e se preocupa que eles possam um dia sumir do web.archive (ou mesmo quer poder acessá-los mais facilmente), pode usar essa ferramenta para guardá-los em sua própria máquina.

Para testar a aplicação, siga os seguintes passos:

 * subir um mongodb (via `docker-compose up`, ou algum local na sua máquina)
 * rodar a aplicação: `mvn spring-boot:run`

Utiliza as seguintes ferramentas:
 * Spring Boot
 * Jsoup (para leitura das páginas HTML) 

Há também um livro com diversos artigos do blog dele em português e do blog em inglês: https://www.casadocodigo.com.br/products/livro-fragmentos

Os próximos passos são:
 * colocar a data no formato yyyymmdd no nome do artigo, para ordenar por data 
 * corrigir testes que estão rodando com dados "de produção" :D
 * escrever testes unitários para mais classes