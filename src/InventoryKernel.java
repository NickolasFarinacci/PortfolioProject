
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import components.map.Map;
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
import components.standard.Standard;

/**
 * Interface InventoryKernel.
 * 
 * @author Nick Farinacci
<<<<<<< Updated upstream
<<<<<<< Updated upstream
 *
 */
public interface InventoryKernel<K, V> extends Standard<Map<K, V>> {
=======
=======
>>>>>>> Stashed changes
 * 
 * @param <I>
 *           type of {@code Inventory} domain (item) entries
 * @param <N>
 *          type of {@code Inventory} range (associated value) entries
 *
 */
public interface InventoryKernel<I, N> extends Standard<InventoryKernel<I, N>> {


    /**
     * An Inventory entry (item-number pair).
     *
     * @param <I>
     *            type of {@code InventoryKernel} domain (item) entries
     * @param <V>
     *            type of {@code MapKernel} range (associated value) entries
     * @mathmodel type Pair is modeled by (item: I, number: N)
     * @initially <pre>
     * (I item, N number):
     *  ensures
     *   this = (item, number)
     * </pre>
     */
    interface Pair<I, N> {

        /**
         * Returns this {@code Pair}'s item.
         *
         * @return the item
         * @aliases reference returned by {@code item}
         */
        I key();

        /**
         * Returns this {@code Pair}'s number.
         *
         * @return the number
         * @aliases reference returned by {@code number}
         */
        N value();

    }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    Map.Pair<String, Integer> removeItem(String item);
=======
    InventoryKernel.Pair<String, Integer> removeItem(String item);
>>>>>>> Stashed changes
=======
    InventoryKernel.Pair<String, Integer> removeItem(String item);
>>>>>>> Stashed changes

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
