package telran.pomegranates.model;

import java.util.*;
import java.util.stream.Collectors;

public class Box implements Iterable<Pomegranate>{
    private String name;
    private List<Pomegranate> granates;

    public Box(int amountOfGranates) {
        this.name = "pomegranates" + amountOfGranates;
        granates = new Random()
                .ints(400,701)
                .limit(amountOfGranates)
                .mapToObj(Pomegranate::new)
                .toList();
    }

    public String getName() {
        return name;
    }

    public List<Pomegranate> getGranates() {
        return granates;
    }
    public long calculateSeeds() {
        return granates.stream()
                .map(Pomegranate::getSeeds)
                .mapToLong(Collection::size)
                .sum();
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return new Iterator<Pomegranate>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < granates.size();
            }

            @Override
            public Pomegranate next() {
                return granates.get(i++);
            }
        };
    }
}
