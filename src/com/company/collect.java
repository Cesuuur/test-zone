package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private int num;
    private String ingredient;

    Product(int num, String ingredient){
        this.num = num;
        this.ingredient = ingredient;
    }

    public String  getName(){
        return this.ingredient;
    }

    public int  getPrice(){
        return this.num;
    }
}

public class collect {

    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        List<String> collectorCollection =  productList
                .stream()
                .map(Product::getName)
                .collect(Collectors.toList());

        collectorCollection
                .parallelStream()
                .forEach(System.out::println);

        String listToString = productList
                                    .stream()
                                    .map(Product::getName)
                                    .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(listToString);

        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getPrice));


        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getPrice));
    }
}
