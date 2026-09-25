package Tpjava;

public interface ReproductorMusical {
    void reproducir(cancion cancion);
    void detener();
    
    default void pausar() {
        System.out.println("Pausando la reproducción actual...");
        detener();
    }

}
