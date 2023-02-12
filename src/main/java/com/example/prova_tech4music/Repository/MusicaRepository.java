package com.example.prova_tech4music.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.prova_tech4music.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    //ressalva:
    //insert > save
    //find > findAll
    //métodos vão mudar de nome aqui dentro da nossa aplicação
    //porém, vão continuar fazendo a mesma coisa que faziam dentro do Mongo
    //findByBlablabla
    //@Query()
  
}