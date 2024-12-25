package telran.pomegranates.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.StreamSupport;

public class Pomegranate implements Iterable<Seed>{
    private List<Seed> seeds;

    public Pomegranate(int amountOfSeeds) {
        this.seeds = new ArrayList<>();
        for (int i = 0; i < amountOfSeeds; i++) {
            seeds.add(new Seed());
        }
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    @Override
    public Iterator<Seed> iterator() {
        return new Iterator<Seed>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < seeds.size();
            }

            @Override
            public Seed next() {
                return seeds.get(i++);
            }
        };
    }
}
