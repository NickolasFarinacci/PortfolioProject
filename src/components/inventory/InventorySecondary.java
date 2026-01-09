package components.inventory;

import components.set.Set;

/**
 * Layered implementations of secondary methods for {@code Inventory}.
 *
 * @author Nick Farinacci
 */
public abstract class InventorySecondary implements Inventory {

    /**
     * Maximum number of items in the inventory.
     */
    private static final int MAX_ITEMS = 99;

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
        assert this.hasItem(
                item) : "Precondition violated: item must be in inventory";

        Integer totalItem = this.value(item) + amount;

        if (totalItem > MAX_ITEMS) {
            totalItem = MAX_ITEMS;
        }

        this.removeItem(item);
        this.addItem(item, totalItem);

    }

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
    @Override
    public void removeFromItem(String item, int amount) {
        assert this.hasItem(
                item) : "Precondition violated: item must be in inventory";
        assert this.value(
                item) >= amount : "Precondition violated: amount to remove must"
                        + "be less than or equal to current quantity";

        int totalItem = this.value(item) - amount;

        if (totalItem == 0) {
            this.removeItem(item);

        } else {

            this.removeItem(item);
            this.addItem(item, totalItem);

        }

    }

    /**
     * Returns whether the inventory is empty.
     *
     * @return true if the inventory is empty, false otherwise
     * @ensures isEmpty = (|this| = 0)
     */
    @Override
    public final boolean isEmpty() {

        return this.totalItems() == 0;

    }

    /**
     * Returns a string representation of the inventory.
     *
     * @return string representation of the inventory
     * @ensures toString = string representation of the inventory
     */
    @Override
    public final String toString() {

        String result = "{";
        int size = this.uniqueItems().size();
        int count = 0;

        for (String elem : this.uniqueItems()) {
            if (count == size - 1) {
                result += elem + ": " + this.value(elem);
            } else {

                result += elem + ": " + this.value(elem) + ", ";
                count++;
            }
        }

        return result + "}";

    }

    /**
     * Compares this inventory to another object for equality.
     *
     * @param obj
     *            the object to compare to
     * @return true if the inventories are equal, false otherwise
     * @ensures equals = (this and obj are equal inventories)
     */
    @Override
    public final boolean equals(Object obj) {

        boolean result = true;

        if (this == obj) {
            result = true;
        }
        if (!(obj instanceof Inventory)) {
            result = false;
        } else {
            Inventory other = (Inventory) obj;

            Set<String> thisItems = this.uniqueItems();
            Set<String> otherItems = other.uniqueItems();

            if (!thisItems.equals(otherItems)) {
                result = false;
            }

            for (String item : thisItems) {
                if (this.value(item) != other.value(item)) {
                    result = false;
                }
            }

        }

        return result;

    }

    /**
     * Returns the hash code of the inventory.
     *
     * @return hash code of the inventory
     * @ensures hashCode = hash code of the inventory
     */
    @Override
    public final int hashCode() {

        return this.mapHashCode();

    }

}
