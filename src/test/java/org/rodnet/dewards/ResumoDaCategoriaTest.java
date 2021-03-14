package org.rodnet.dewards;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.dewards.ObjetosParaTestes.resumoCategoriaBrasil;

public class ResumoDaCategoriaTest {

    @Test
    void converterHtmlParaCategoria() {
        var resumo = resumoCategoriaBrasil();
        assertThat(resumo.lerNome()).isEqualTo("brasil");
        assertThat(resumo.lerEndereco()).isEqualTo(resumoCategoriaBrasil().lerEndereco());
    }
}
