package components.inventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Inventory}'s Secondary methods.
 *
 * @author Nick Farinacci
 *
 */
public class InventoryAbstractTest {
    @Test
    public void inventoryAddSingleItem() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap<String, Integer> expectedInventory = new InventoryOnMap("item1",
                10);
        inventory.addItem("item1", 10);
        assertEquals(expectedInventory, inventory);
    }

    public void inventoryAddMultipleItems() {
        Inventory<String, Integer> inventory = new Inventory<>();
        Inventory<String, Integer> expectedInventory = new Inventory<>("item1",
                10, "item2", 20);
        inventory.add("item1", 10);
        inventory.add("item2", 20);
        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryAddDuplicateItems() {
        Inventory<String, Integer> inventory = new Inventory<>();
        Inventory<String, Integer> expectedInventory = new Inventory<>("item1",
                30);
        inventory.add("item1", 10);
        inventory.add("item1", 20);
        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryIsEmpty() {
        Inventory<String, Integer> inventory = new Inventory<>();
        Inventory<String, Integer> copyInventory = new Inventory<>();
        assertTrue(inventory.isEmpty());
        assertEquals(copyInventory, inventory);
    }

}
