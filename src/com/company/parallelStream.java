package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class parallelStream {


    public static void main(String[] args) {

        // 1º Probamos los reduces NENE
        IntStream.range(1, 4).forEach(System.out::println);
        OptionalInt reduced = IntStream.range(1, 4)
                                    .reduce((a, b) -> {System.out.println(b + "in reduce");
                                                        return a + b;});
        System.out.println("\n" + reduced.getAsInt() + "\n");

        // SEQUENTIAL CODE BB
        List<String> asteroids_parallel = Arrays.asList(new String[] {"Hola", "Probando", "Haciendo", "Pruebas", "Más", "Pruebas", "Do"});
        asteroids_parallel.stream()
                .map(s->s.length())
                .reduce((a,b)->{
                    if(b%2==0) return a+b;
                    // Puedo meter comentarios dentro de un Stream(?)
                    // En este return no acumula :(
                    else return a;})
                .ifPresent(System.out::println);

        List<String> asteroids = Arrays.asList(new String[] {"Hola", "Probando", "Haciendo", "Pruebas", "Más", "Pruebas", "Do"});
        // PARALLEL STREAM (e)DARLING---We only call combiner in a parallel mode to reduce the results of accumulators from different threads
        asteroids.parallelStream()
                .map(s->s.length())
                .reduce((a,b)->{
                    if(b%2==0) return a+b;
                    else return a;})
                .ifPresent(System.out::println);
    }
}
