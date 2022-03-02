package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class filterExample
{
    public static void main(String[] args)
    {
        IntStream stream = IntStream.range(1, 100);

        List<Integer> primes = stream
                .filter(filterExample::isPrime)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(primes);
    }

    public static boolean isPrime(int i)
    {
        IntPredicate isDivisible = index -> {
            System.out.println(i + "_" + index);
            return i % index == 0;
        };
//        int resultado = (int a , int f) -> a * f;
        int[] lista = new int[] {1,2,3,4,5};
//        Arrays.stream(lista).forEach(resultado);
//        IntStream.range(2, 5).forEach(System.out::println);
        System.out.println(
                IntStream
                        .range(2, i)
                        .noneMatch(isDivisible)
                        + "\n");

//        IntStream.range(2, i).none
        return i > 1 && IntStream
                            .range(2, i)
                            .noneMatch(isDivisible);

    }
}
