import components.set.Set;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 *
 * @param <K>
 *            type of {@code Inventory} domain (key) entries
 * @param <V>
 *            type of {@code Inventory} range (associated value) entries
 */
public interface Inventory<I, N> extends InventoryKernel<I, N> {

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
    void addToItem(I item, N amount);

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
    void removeFromItem(I item, N amount);

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