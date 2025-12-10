package components.inventory;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 */
public abstract class InventorySecondary extends Inventory {

    /**
     * Maximum number of items in the inventory.
     */
    private static final int MAX_ITEMS = 99;

    /**
     * Storage for items {@code this}.
     */
    private Map<String, Integer> storage;

    /**
     * Default constructor.
     */
    public InventorySecondary() {
        this.storage = new Map1L<String, Integer>();
    }

    /**
     * Adds the given amount to the item in the inventory.
     *
     * @param item
     *            the item to add to
     * @param amount
     *            the amount to add
     * @updates this
     * @requires this.storage.hasKey(item)
     * @ensures this = #this + amount added to item
     */
    @Override
    public void addToItem(String item, int amount) {
        assert this.storage.hasKey(
                item) : "Precondition violated: item must be in inventory";

        Integer totalItem = this.storage.value(item) + amount;

        if (totalItem > MAX_ITEMS) {
            totalItem = MAX_ITEMS;
        }

        this.storage.replaceValue(item, totalItem);

    }

    /**
     * Removes the item from the inventory.
     *
     * @param item
     *            the item to remove
     * @updates this
     * @requires this.storage.hasKey(item)
     * @ensures <pre>
     * @return the pair (item, original value of item)
     * this = #this - item
     * removeItem = (item, original value of item)
     * </pre>
     */
    @Override
    public Map.Pair<String, Integer> removeItem(String item) {

        return this.storage.remove(item);

    }

    /**
     * Returns the set of unique items in the inventory.
     *
     * @return the set of unique items in the inventory
     * @ensures uniqueItems = {all items in this}
     */
    @Override
    public final Set<String> uniqueItems() {

        Set<String> uniqueItems = new Set1L<String>();

        for (Map.Pair<String, Integer> p : this.storage) {
            uniqueItems.add(p.key());
        }

        return uniqueItems;
    }

    /**
     * Returns whether the inventory is empty.
     *
     * @return true if the inventory is empty, false otherwise
     * @ensures isEmpty = (|this| = 0)
     */
    @Override
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
