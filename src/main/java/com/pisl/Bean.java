package com.pisl;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Stateless
public class Bean {
    public List<Integer> generateRandomNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(10) + 1); // Случайные числа от 1 до 10
        }
        return numbers;
    }
}
