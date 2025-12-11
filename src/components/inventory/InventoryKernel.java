package components.inventory;

import components.set.Set;
import components.standard.Standard;

/**
 * Interface InventoryKernel.
 *
 * @author Nick Farinacci
 *
 */
public interface InventoryKernel extends Standard<InventoryKernel> {

    /**
     * Returns the value of a given item.
     *
     * @param item
     *            The item to get the value of.
     * @return int The value of the item.
     *
     * @requires item is in the inventory.
     * @ensures value = [the value of the given item]
     */
    int value(String item);

    /**
     * Adds a given quantity of an item to the inventory.
     *
     * @param item
     *            The name of item to be added in.
     * @param quantity
     *            The amount of the item to add.
     *
     * @aliases references {@code item, quantity}
     * @updates this
     *
     * @requires quantity > 0
     * @ensures this = #this union {(item, quantity)}
     */
    void addItem(String item, int quantity);

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
    components.map.Map.Pair<String, Integer> removeItem(String item);

    /**
     * Returns a set of all unique items in the inventory.
     *
     * @return Set<String> The set of unique items.
     *
     * @ensures uniqueItems = { all items in the inventory }
     */
    Set<String> uniqueItems();

    /**
     * Checks if the inventory has a given item.
     *
     * @param item
     *            The name of the item to check for.
     * @return boolean True if the item is in the inventory, false otherwise.
     *
     * @ensures hasItem = true if item is in the inventory, false otherwise.
     */
    boolean hasItem(String item);

    /**
     * Returns the total number of items in the inventory.
     *
     * @return int The total number of items.
     *
     * @ensures totalItems = [the total number of items in the inventory]
     */
    int totalItems();

}
