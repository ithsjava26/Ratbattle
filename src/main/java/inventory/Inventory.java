package inventory;

import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> findItem() {
        return new ArrayList<>(items);
    }

    public void printInventory() {
        getItemCounts().forEach((name, count) -> {
            IO.println(name + " x" + count);
        });
    }

    public Map<String, Long> getItemCounts() {
        return items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

    }

}
