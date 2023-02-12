package com.example.prova_tech4music.service;

import java.util.List;
import java.util.Optional;

import com.example.prova_tech4music.model.Musica;
import com.example.prova_tech4music.shared.MusicaDto;

public interface MusicaService {
    MusicaDto adicionarMusica(MusicaDto musica);
    List<MusicaDto> verTodas();
    Optional <MusicaDto> localizarMusicaPorId(String id);
    //atualizar
    Musica atualizarMusica(String id, Musica musica);
    //deletar
    void excluirMusica(String id);
    Object contador();
}

//mvn spring-boot:run
