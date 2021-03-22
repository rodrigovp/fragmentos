package org.rodnet.fragmentos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rodnet.fragmentos.ObjetosParaTestes.resumoCategoriaBrasil;
import static org.rodnet.fragmentos.ObjetosParaTestes.umArtigo;

@DataMongoTest
class TodasCategoriasTest {

    @Autowired
    private TodasCategorias todasCategorias;

    @Test
    void persistirUmaCategoria(){
        var artigo = umArtigo();
        var resumo = resumoCategoriaBrasil();
        var categoria = new Categoria(resumo, Set.of(artigo));

        todasCategorias.save(categoria);

        var categoriaPersistida = todasCategorias.findById(categoria.lerNome()).get();

        assertThat(categoriaPersistida.lerNome()).isEqualTo(categoria.lerNome());
        assertThat(categoriaPersistida.lerArtigos()).containsExactly(artigo);
    }
}
