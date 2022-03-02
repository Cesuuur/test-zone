package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    private long counter;

    public void Main(long counter){
        this.counter = 0;
    }

    private void wasCalled() {
        this.counter++;
        System.out.println(this.counter);
    }

    public static void main(String[] args) throws Exception {
        // Your code here!
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .skip(2)
                .forEach(i -> System.out.print(i + " "));


        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.print(reduced);

//        IntStream reduce = IntStream.range(1, 4).forEach(f -> {System.out.println(f);});
        IntStream.iterate(0, i -> i + 2).limit(10).forEach(System.out::println);

    }
}
