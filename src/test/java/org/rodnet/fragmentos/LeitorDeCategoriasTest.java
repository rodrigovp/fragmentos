package org.rodnet.fragmentos;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class LeitorDeCategoriasTest {

    @Value("${seed.url}")
    private URL urlSemente;

    private LeitorDeCategorias leitor;

    @BeforeEach
    void setUp(){
        leitor = new LeitorDeCategorias(urlSemente);
    }

    //@Test
    void lerCategorias() throws IOException {
        var categorias = leitor.lerCategorias();

        assertThat(categorias).isNotNull();
    }
}
