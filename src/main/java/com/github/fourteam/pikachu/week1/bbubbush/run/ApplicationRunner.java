package com.github.fourteam.pikachu.week1.bbubbush.run;

import com.github.fourteam.pikachu.week1.bbubbush.domain.Product;

public class ApplicationRunner {
    public static void main(String[] args) {
        Product product = new Product.Builder(100L, 10000L).build();

        System.out.println(product);
    }
}
