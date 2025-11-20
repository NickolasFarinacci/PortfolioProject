import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 */
public abstract class InventorySecondary implements Inventory<String, Integer> {

    /**
     * Maximum number of items in the inventory.
     */
    private static final int MAX_ITEMS = 99;

    /**
     * Storage for items {@code this}.
     */
    private Map<String, Integer> storage;

    private InventorySecondary() {
        this.storage = new Map1L<String, Integer>();
    }

    public final void addToItem(String item, int amount) {
        assert this.storage.hasKey(
                item) : "Precondition violated: item must be in inventory";

        Integer totalItem = this.storage.value(item) + amount;

        if (totalItem > MAX_ITEMS) {
            totalItem = MAX_ITEMS;
        }

        this.storage.replaceValue(item, totalItem);

    }

    public final Map.Pair<String, Integer> removeItem(String item) {

        return this.storage.remove(item);

    }

    public final Set<String> uniqueItems() {

        Set<String> uniqueItems = new Set1L<String>();

        for (Map.Pair<String, Integer> p : this.storage) {
            uniqueItems.add(p.key());
        }

        return uniqueItems;
    }

    public final boolean isEmpty() {

        return this.storage.size() == 0;

    }

    @Override
    public final String toString() {

        String result = "";

        for (Map.Pair<String, Integer> p : this.storage) {
            result += p.key() + ": " + p.value() + "\n";
        }

        return result;

    }

    @Override
    public final boolean equals(Object obj) {

        boolean result = false;

        if (obj == null) {
            result = false;
        }
        if (this == obj) {
            result = true;
        }
        if (!(obj instanceof InventorySecondary)) {
            result = false;
        } else {
            InventorySecondary other = (InventorySecondary) obj;
            result = this.storage.equals(other.storage);
        }

        return result;

    }

    @Override
    public final int hashCode() {

        return this.storage.hashCode();

    }

}
