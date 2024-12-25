package telran.pomegranates;

import telran.pomegranates.model.Box;
import telran.pomegranates.model.Pomegranate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PomegranateApp {
    public static void main(String[] args) {
        List<Box> boxes = new Random()
                .ints(10,21)
                .limit(new Random().nextLong(100,201))
                .mapToObj(Box::new)
                .toList();
        System.out.println("===Total seeds in all boxes===");
        long totalSeeds = boxes.stream()
                .map(Box::getGranates)
                .flatMap(Collection::stream)
                .map(Pomegranate::getSeeds)
                .mapToLong(Collection::size)
                .sum();
        System.out.println(totalSeeds);
        System.out.println("===Maximal amount of seeds in one box");
        long maxSeeds = boxes.stream()
                .map(Box::calculateSeeds)
                .max(Long::compareTo).orElse(-1L);
        System.out.println(maxSeeds);
        System.out.println("===Names of boxes with maximal amount of seeds");
        boxes.stream()
                .filter(b -> b.calculateSeeds() == maxSeeds)
                .map(Box::getName)
                .forEach(System.out::println);
    }
}
