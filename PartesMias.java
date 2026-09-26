import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PartesMias {
    public static void main(String[] args) {

        List<Cancion> canciones = new ArrayList<>(List.of(
                new Cancion("1", "Luz de Neón", "Los Cronómetros", "Rock", 210, 154000L, false),
                new Cancion("2", "Bailar Bajo la Lluvia", "Kumbia Total", "Cumbia", 195, 320000L, false),
                new Cancion("3", "Circuitos", "Synthia", "Electronica", 240, 98000L, true),
                new Cancion("4", "Melodía Azul", "Trío Nocturno", "Jazz", 300, 12000L, true),
                new Cancion("5", "Vuelta al Sur", "Los Cronómetros", "Rock", 225, 87000L, false),
                new Cancion("6", "Fiebre", "DJ Pulso", "Electronica", 180, 410000L, false),
                new Cancion("7", "Corazón de Barrio", "Kumbia Total", "Cumbia", 205, 275000L, false),
                new Cancion("8", "Susurros", "Trío Nocturno", "Jazz", 260, 5400L, true),
                new Cancion("9", "Alta Tensión", "Synthia", "Electronica", 200, 189000L, true)
        ));




        Predicate<Cancion> esPopular = c -> c.getReproducciones() > 100_000;

        String generoFavorito = "Electronica"; 
        Predicate<Cancion> esDeGeneroFavorito = c -> c.getGenero().equalsIgnoreCase(generoFavorito);

        Predicate<Cancion> recomendable = esPopular.or(esDeGeneroFavorito);

        Consumer<Cancion> imprimirRecomendacion =
                c -> System.out.println("[Recomendado] " + c.getTitulo() + " - " + c.getArtista());

        System.out.println("=== PARTE 2.3 - Pipeline con lambdas ===");
        canciones.stream()
                .filter(recomendable)
                .sorted((a, b) -> Long.compare(b.getReproducciones(), a.getReproducciones()))
                .forEach(imprimirRecomendacion);


        System.out.println("\n=== PARTE 3.2 - Pipeline con referencias a método ===");
        canciones.stream()
                .filter(recomendable)
                .sorted(Comparator.comparingLong(Cancion::getReproducciones).reversed())
                .map(CancionDto::new)         
                .forEach(System.out::println); 



        Map<String, List<Cancion>> porGenero = canciones.stream()
                .collect(Collectors.groupingBy(Cancion::getGenero));


        Map<String, Long> cantidadPorGenero = canciones.stream()
                .collect(Collectors.groupingBy(Cancion::getGenero, Collectors.counting()));


        Map<String, Long> reproduccionesPorGenero = canciones.stream()
                .collect(Collectors.groupingBy(Cancion::getGenero,
                        Collectors.summingLong(Cancion::getReproducciones)));


        System.out.println("\n=== PARTE 4.1 - Canciones agrupadas por género ===");
        porGenero.forEach((genero, lista) -> {
            System.out.println(genero + ":");
            lista.forEach(c -> System.out.println("   - " + c.getTitulo() + " (" + c.getArtista() + ")"));
        });

        System.out.println("\n=== PARTE 4.2 - Cantidad de canciones por género ===");
        cantidadPorGenero.forEach((genero, cantidad) ->
                System.out.println(genero + ": " + cantidad + " canciones"));

        System.out.println("\n=== PARTE 4.3 - Reproducciones totales por género ===");
        reproduccionesPorGenero.forEach((genero, total) ->
                System.out.println(genero + ": " + total + " reproducciones"));
    }
}
