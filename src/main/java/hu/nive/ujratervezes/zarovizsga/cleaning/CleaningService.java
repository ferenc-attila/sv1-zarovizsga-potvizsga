package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        this.cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sum = cleanables.stream()
                .mapToInt(Cleanable::clean)
                .sum();
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = cleanables.stream()
                .filter(cleanable -> cleanable.getClass() == Office.class)
                .mapToInt(Cleanable::clean)
                .sum();
        cleanables.removeIf(cleanable -> cleanable.getClass() == Office.class);
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        validateAddress(address);
        return cleanables.stream()
                .filter(cleanable -> cleanable.getAddress().contains(address))
                .toList();
    }

    public String getAddresses() {
        return cleanables.stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }

    private void validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Cannot use empty address!");
        }
    }

    public List<Cleanable> getCleanables() {
        return List.copyOf(cleanables);
    }
}
