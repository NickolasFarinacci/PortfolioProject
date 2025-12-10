import components.set.Set;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 *
 * @param <String>
 *            type of {@code Inventory} domain (key) entries
 * @param <Integer>
 *            type of {@code Inventory} range (associated value) entries
 */
public interface Inventory<String, Integer>
        extends InventoryKernel<String, Integer> {

    /**
     * Adds a given quantity of an item to the inventory.
     *
     * @param item
     *            The item to add to.
     * @param amount
     *            The amount to add.
     *
     * @requires item is in the inventory.
     * @ensures the quantity of the item is increased by amount.
     */
    void addToItem(String item, Integer amount);

    /**
     * Removes a given quantity of an item from the inventory.
     *
     * @param item
     *            The item to remove from.
     * @param amount
     *            The amount to remove.
     *
     * @requires item is in the inventory and amount is less than or equal to
     *           the current quantity of the item.
     * @ensures the quantity of the item is decreased by amount.
     */
    void removeFromItem(String item, int amount);

    /**
     * Returns a set of all unique items in the inventory.
     *
     * @return Set<String> The set of unique items.
     *
     * @ensures uniqueItems = { all items in the inventory }
     */
    Set<String> uniqueItems();

    /**
     * Checks if the inventory is empty.
     *
     * @return boolean True if the inventory is empty, false otherwise.
     *
     * @ensures isEmpty = (|this| = 0)
     */
    boolean isEmpty();

}
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

    public void removeFromItem(String item, int amount) {
        assert this.items.value(
                item) > amount : "Violation of: this.items.value(item) > amount";
        assert this.items
                .hasKey(item) : "Violation of: this.items.hasKey(item)";
        Map.Pair<String, Integer> p = this.items.remove(item);
        this.items.add(item, p.value() - amount);

    }

}
