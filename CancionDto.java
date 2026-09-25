package Tpjava;

public class CancionDto {
    private String titulo;
    private String artista;

    public CancionDto(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public CancionDto(cancion cancion) {
        this.titulo = cancion.getTitulo();
        this.artista = cancion.getArtista();
    }

    @Override
    public String toString() {
        return "[DTO] " + titulo + " - " + artista;
    }

}
