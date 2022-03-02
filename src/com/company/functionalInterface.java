package com.company;

import java.util.function.IntPredicate;

public class functionalInterface {

    public static void main(String[] args) {
        MyValue myVal;

        myVal = () -> 98.6;
        System.out.println(myVal.getValue());

//        IntPredicate isDivisible = index -> {
//            System.out.println(i + "_" + index);
//            return i % index == 0;
//        };


    }
}
