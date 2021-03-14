package org.rodnet.dewards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @Test
    void lerCategorias() throws IOException {
        var categorias = leitor.lerCategorias();

        assertThat(categorias).isNotNull();
    }
}
