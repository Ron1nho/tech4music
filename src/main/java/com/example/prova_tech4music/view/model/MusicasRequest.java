package com.example.prova_tech4music.view.model;



//import org.hibernate.validator.constraints.Length;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;


public class MusicasRequest {
    @NotEmpty (message = "O campo não pode ficar vazio!")
    private String titulo;
    @NotEmpty (message = "O campo não pode ficar vazio!")
    private String artista;
    @NotEmpty (message = "O campo não pode ficar vazio!")
    private String album;
    private String genero;
   // @NotBlank( message = "O campo não pode conter caracteres em branco!")
   // @NotEmpty (message = "O campo não pode ficar vazio!")
   // @Length (min = 3, max = 4, message = "O campo deve conter 4 digitos!!!")
   //@Size (min = 3, max = 4, message = "asdasdasdasdasda")
    private int anoLancamento;
    private String compositor;
   
   //---------------------------------------------------------------------------------------
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    
    }
}
