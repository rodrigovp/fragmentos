package org.rodnet.dewards;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.dewards.ObjetosParaTestes.resumoCategoriaBrasil;
import static org.rodnet.dewards.ObjetosParaTestes.umArtigo;

class CategoriaTest {

    @Test
    void lerInformacoesDaCategoria(){
        Categoria categoria = new Categoria(resumoCategoriaBrasil(), Set.of(umArtigo()));

        assertThat(categoria.lerNome()).isEqualTo("brasil");
        assertThat(categoria.lerArtigos()).containsExactly(umArtigo());
    }
}