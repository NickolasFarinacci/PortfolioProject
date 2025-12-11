package components.inventory;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 */
public interface Inventory extends InventoryKernel {

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
    void addToItem(String item, int amount);

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
     * Checks if the inventory is empty.
     *
     * @return boolean True if the inventory is empty, false otherwise.
     *
     * @ensures isEmpty = (|this| = 0)
     */
    boolean isEmpty();

    /**
     * Returns the hash code of the inventory map.
     *
     * @return int The hash code of the inventory map.
     */
    int mapHashCode();

}
