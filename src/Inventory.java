import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

class Inventory {

    private Map<String, Integer> items;

    public Inventory() {
        this.items = new Map1L<>();
    }

    public int value(String item) {
        assert this.items
                .hasKey(item) : "Violation of: this.items.hasKey(item)";
        return this.items.value(item);
    }

    public void addItem(String item, int quantity) {
        assert quantity > 0 : "Violation of: quantity > 0";
        if (this.items.hasKey(item)) {
            Map.Pair<String, Integer> p = this.items.remove(item);
            this.items.add(item, p.value() + quantity);
        } else {
            this.items.add(item, quantity);
        }
    }

    public Map.Pair<String, Integer> removeItem(String item) {
        assert this.items
                .hasKey(item) : "Violation of: this.items.hasKey(item)";
        return this.items.remove(item);
    }

    public int totalItems() {
        int total = 0;
        for (Map.Pair<String, Integer> p : this.items) {
            total += p.value();
        }
        return total;
    }

    public boolean isEmpty() {
        return this.items.size() == 0;
    }

    public boolean hasItem(String item) {
        return this.items.hasKey(item);
    }

    public Set<String> uniqueItems() {
        Set<String> keys = new Set1L<>();
        for (Map.Pair<String, Integer> p : this.items) {
            keys.add(p.key());
        }
        return keys;
    }

    public void addToItem(String item, int amount) {
        assert amount > 0 : "Violation of: amount > 0";
        assert this.items
                .hasKey(item) : "Violation of: this.items.hasKey(item)";
        Map.Pair<String, Integer> p = this.items.remove(item);
        this.items.add(item, p.value() + amount);
    }

    public Map.Pair<String, Integer> removeFromItem(String item, int amount) {
        assert this.items.value(
                item) > amount : "Violation of: this.items.value(item) > amount";
        assert this.items
                .hasKey(item) : "Violation of: this.items.hasKey(item)";
        Map.Pair<String, Integer> p = this.items.remove(item);
        this.items.add(item, p.value() - amount);

        Map.Pair<String, Integer> pair = new Map.Pair<>(item, amount);

        return pair;

    }

}
