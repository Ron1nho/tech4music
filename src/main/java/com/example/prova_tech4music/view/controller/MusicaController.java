package com.example.prova_tech4music.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_tech4music.shared.MusicaDto;
import com.example.prova_tech4music.model.Musica;
import com.example.prova_tech4music.service.MusicaService;
import com.example.prova_tech4music.view.model.MusicasRequest;
import com.example.prova_tech4music.view.model.MusicasResponse;



    @RestController
    @RequestMapping ("/api/musicas")
    public class MusicaController {
        
        @Autowired
        private MusicaService servico;
        ModelMapper mapper = new ModelMapper();
    
        @GetMapping
        public ResponseEntity<List<MusicasResponse>> verTodas() {
            List<MusicaDto> musidto = servico.verTodas();
            List<MusicasResponse> musiresponse = 
            musidto.
            stream().
            map(m -> mapper.map(m, MusicasResponse.class)).
            collect(Collectors.toList());
    
            return new ResponseEntity<>(musiresponse, HttpStatus.OK);
    
               }
    
            @PostMapping
        public ResponseEntity<MusicasResponse> adicionarMusica(@RequestBody @Valid MusicasRequest musirequest) {
          
            MusicaDto dtorequest = mapper.map(musirequest, MusicaDto.class);
            MusicaDto dtoresponse = servico.adicionarMusica(dtorequest);
            MusicasResponse musiresponse = mapper.map(dtoresponse, MusicasResponse.class);
            
            return new ResponseEntity<>(musiresponse, HttpStatus.CREATED);
    
                   
                }
    
    
                @GetMapping(value="/{id}")
        public ResponseEntity <MusicasResponse> obterPorId(@PathVariable String id) {
           Optional<MusicaDto> musidto = servico.localizarMusicaPorId(id);
    
           if(musidto.isPresent()){
                MusicasResponse musiresponse = mapper.map(musidto.get(), MusicasResponse.class);
                return new ResponseEntity<>(musiresponse, HttpStatus.FOUND);
           }
    
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    
        @PutMapping(value="/{id}")
        public Musica atualizarMusica(@PathVariable String id, @RequestBody Musica musica) {
            return servico.atualizarMusica(id, musica);
        }
    
        @DeleteMapping(value="/{id}")
        public ResponseEntity <String> excluirMusica(@PathVariable String id) {
            servico.excluirMusica(id);
            return new ResponseEntity<>("Música excluida...", HttpStatus.OK);
        }
        
        @GetMapping(value = "/count")
        public ResponseEntity<?> count() {
            return ResponseEntity.status(HttpStatus.OK).body(servico.contador());
    
         }
      }
    

