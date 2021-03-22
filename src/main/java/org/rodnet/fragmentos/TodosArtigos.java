package org.rodnet.fragmentos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodosArtigos extends MongoRepository<Artigo, String> {
}
