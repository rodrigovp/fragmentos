package org.rodnet.dewards;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodasCategorias extends MongoRepository<Categoria, String> {
}
