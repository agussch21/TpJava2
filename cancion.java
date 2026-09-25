package Tpjava;

public class cancion {
    private String id;
    private String titulo;
    private String artista;
    private String genero;
    private int duracionSegundos;
    private long reproducciones;
    private boolean esPremium;

    public cancion(String id, String titulo, String artista, String genero, int duracionSegundos, long reproducciones, boolean esPremium) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracionSegundos = duracionSegundos;
        this.reproducciones = reproducciones;
        this.esPremium = esPremium;
    }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getGenero() { return genero; }
    public long getReproducciones() { return reproducciones; }
    
}