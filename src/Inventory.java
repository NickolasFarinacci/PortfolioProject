package components.inventory;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 *
 * @param <K>
 *            type of {@code Inventory} domain (key) entries
 * @param <V>
 *            type of {@code Inventory} range (associated value) entries
 */
public abstract class InventorySecondary implements InventoryKernel {

    /**
     * Removes a given item from the inventory.
     *
     * @param item
     *            The item to remove.
     * @return Inventory.Pair<String, Integer> The removed item-number pair.
     *
     * @requires item is in the inventory.
     * @ensures this = #this \ {(item, quantity)}
     */
    InventoryKernel.Pair<String, Integer> removeItem(String item);

}