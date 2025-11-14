package components.inventory;

import components.map.Map;
import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 *
 * @param <I>
 *            type of {@code Inventory} domain (key) entries
 * @param <N>
 *            type of {@code Inventory} range (associated value) entries
 */
public abstract class InventorySecondary<I, N> implements Inventory<I, N> {

    /**
     * Maximum number of items in the inventory.
     */
    private static final int MAX_ITEMS = 99;

    /**
     * Storage for items {@code this}.
     */
    private Map<I, N> storage;

    /**
     * Adds a given quantity of an item to the inventory.
     *
     * @param item
     *            The item to add to.
     * @param amount
     *            The amount to add.
     *
     * @requires this.hasItem(item) and 0 <= amount <= MAX_ITEMS. Amount must
     *           also be able to be converted into an Integer.
     * @ensures the quantity of the item is increased by amount.
     */
    @Override
    public final void addToItem(I item, N amount) {
        assert this.storage.hasKey(
                item) : "Precondition violated: item must be in inventory";

        int totalItem = (int) (this.storage.value(item)) + (int) (amount);

        if (totalItem > MAX_ITEMS) {
            totalItem = MAX_ITEMS;
        }

        this.storage.replaceValue(item, (N) (Integer.valueOf(totalItem)));

    }

    /**
     * Removes a given item with its amount from the inventory.
     *
     * @param item
     *            The name of the item to be removed.
     * @return Map.Pair<String, Integer> A pair containing the name of the item
     *         and the quantity removed.
     *
     * @requires item is in the inventory.
     * @ensures this = #this \ {(item, quantity)}
     */
    @Override
    public final Map.Pair<I, N> removeItem(I item) {

        return this.storage.remove(item);

    }

    /**
     * Returns a set of all unique items in the inventory.
     *
     * @return Set<String> The set of unique items.
     *
     * @requires I must be castable to String.
     * @ensures uniqueItems = { all items in the inventory }
     */
    @Override
    public final Set<String> uniqueItems() {

        Set<String> uniqueItems = new Set1L<String>();

        for (Map.Pair<I, N> p : this.storage) {
            uniqueItems.add((String) (p.key()));
        }

        return uniqueItems;
    }

    /**
     * Checks if the inventory is empty.
     *
     * @return boolean True if the inventory is empty, false otherwise.
     *
     * @ensures isEmpty = (|this| = 0)
     */
    @Override
    public final boolean isEmpty() {

        return this.storage.size() == 0;

    }

    /**
     * Returns a string representation of the inventory.
     *
     * @return String A string representation of the inventory.
     *
     * @ensures toString = [string representation of the inventory]
     */
    @Override
    public final String toString() {

        String result = "";

        for (Map.Pair<I, N> p : this.storage) {
            result += p.key() + ": " + p.value() + "\n";
        }

        return result;

    }

    /**
     * Checks if this inventory is equal to another object.
     *
     * @param obj
     *            The object to compare with.
     * @return boolean True if the inventories are equal, false otherwise.
     *
     * @ensures equals = (obj is an Inventory and this = obj)
     */
    @Override
    public final boolean equals(Object obj) {

        boolean result = false;

        if ((obj instanceof InventorySecondary<?, ?>)) {

            InventorySecondary<?, ?> other = (InventorySecondary<?, ?>) obj;
            result = this.storage.equals(other.storage);

        }

        return result;

    }

    /**
     * Returns the hash code of the inventory.
     *
     * @return int The hash code of the inventory.
     *
     * @ensures hashCode = this.hashCode()
     */
    @Override
    public final int hashCode() {

        return this.storage.hashCode();

    }

}
