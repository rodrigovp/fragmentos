package org.rodnet.fragmentos;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.fragmentos.ObjetosParaTestes.resumoCategoriaBrasil;

public class ResumoTest {

    @Test
    void converterHtmlParaCategoria() {
        var resumo = resumoCategoriaBrasil();
        assertThat(resumo.lerNome()).isEqualTo("brasil");
        assertThat(resumo.lerEndereco()).isEqualTo(resumoCategoriaBrasil().lerEndereco());
    }
}
