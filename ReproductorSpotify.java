package Tpjava;

public class ReproductorSpotify implements ReproductorMusical {
    private cancion cancionActual;
    private boolean enPausa;

    @Override
    public void reproducir(cancion cancion) {
        this.cancionActual = cancion;
        this.enPausa = false;
        System.out.println("Reproduciendo: " + cancion.getTitulo() + " de " + cancion.getArtista());
    }

    @Override
    public void detener() {
        this.enPausa = true;
        System.out.println("Reproductor detenido.");
    }

}
