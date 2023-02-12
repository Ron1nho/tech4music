package com.example.prova_tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prova_tech4music.Repository.MusicaRepository;
import com.example.prova_tech4music.model.Musica;
import com.example.prova_tech4music.shared.MusicaDto;

@Service
public class MusicaServiceImp implements MusicaService {
    
    @Autowired
    private MusicaRepository repositorio;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MusicaDto adicionarMusica(MusicaDto musDto) {
    
        Musica m = mapper.map(musDto, Musica.class); 
        m = repositorio.save(m);
        MusicaDto dto = mapper.map(m, MusicaDto.class);

        return dto;
    }

    @Override
    public List<MusicaDto> verTodas() {
        List<Musica> musi = repositorio.findAll();
        List<MusicaDto> musiDto = 
        musi.
        stream().
        map(m -> mapper.map(m, MusicaDto.class)).
        collect(Collectors.toList());
        
        return musiDto;
    }

    @Override
    public Optional <MusicaDto> localizarMusicaPorId(String id) {
        Optional<Musica> optmusi = repositorio.findById(id);

        if(optmusi.isPresent()) {
            MusicaDto musiDto = mapper.map(optmusi.get(), MusicaDto.class);
            return Optional.of(musiDto);
        }

        return Optional.empty();
    }

    @Override
    public Musica atualizarMusica(String id, Musica musica) {
        musica.setId(id);
        return repositorio.save(musica);

    }
    
    @Override
    public void excluirMusica(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Long contador() {
        return repositorio.count();
    }
}
