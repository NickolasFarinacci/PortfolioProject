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
    public void inventoryAddtoOneItem() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addToItem("item1", 5);

        InventoryOnMap expectedInventory = new InventoryOnMap();
        expectedInventory.addItem("item1", 15);
        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryAddtoTwoItems() {

        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        inventory.addToItem("item1", 5);
        inventory.addToItem("item2", 10);

        InventoryOnMap expectedInventory = new InventoryOnMap();
        expectedInventory.addItem("item1", 15);
        expectedInventory.addItem("item2", 30);

        assertEquals(expectedInventory, inventory);

    }

    @Test
    public void inventoryAddToMultipleItems() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        inventory.addItem("item3", 30);
        inventory.addToItem("item1", 5);
        inventory.addToItem("item2", 5);
        inventory.addToItem("item3", 5);

        expectedInventory.addItem("item1", 15);
        expectedInventory.addItem("item2", 25);
        expectedInventory.addItem("item3", 35);

        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryAddToSameItem() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addToItem("item1", 5);
        inventory.addToItem("item1", 10);

        expectedInventory.addItem("item1", 25);

        assertEquals(expectedInventory, inventory);

    }

    @Test
    public void inventoryRemoveFromOneItem() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        inventory.removeFromItem("item1", 10);

        expectedInventory.addItem("item1", 20);

        assertEquals(expectedInventory, inventory);

    }

    @Test
    public void inventoryRemoveFromTwoItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);
        inventory.removeFromItem("item1", 10);
        inventory.removeFromItem("item2", 20);

        expectedInventory.addItem("item1", 20);
        expectedInventory.addItem("item2", 20);

        assertEquals(expectedInventory, inventory);

    }

    @Test
    public void inventoryRemoveFromMultipleItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);
        inventory.addItem("item3", 50);
        inventory.removeFromItem("item1", 10);
        inventory.removeFromItem("item2", 20);
        inventory.removeFromItem("item3", 30);

        expectedInventory.addItem("item1", 20);
        expectedInventory.addItem("item2", 20);
        expectedInventory.addItem("item3", 20);

        assertEquals(expectedInventory, inventory);

    }

    @Test
    public void inventoryRemoveFromSameItem() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();
        inventory.addItem("item1", 50);
        inventory.removeFromItem("item1", 10);
        inventory.removeFromItem("item1", 15);

        expectedInventory.addItem("item1", 25);

        assertEquals(expectedInventory, inventory);

    }

    @Test
    public void inventoryIsEmpty() {

        InventoryOnMap inventory = new InventoryOnMap();
        assertTrue(inventory.isEmpty());
    }

    @Test
    public void inventoryIsNotEmpty() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        assertTrue(!inventory.isEmpty());
    }

    @Test
    public void inventoryToString() {

        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        String expectedString = "{item2: 20, item1: 10}";
        assertEquals(expectedString, inventory.toString());
    }

    @Test
    public void inventoryToStringEmpty() {

        InventoryOnMap inventory = new InventoryOnMap();
        String expectedString = "{}";
        assertEquals(expectedString, inventory.toString());
    }

    @Test
    public void inventoryEqualsSelf() {

        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        assertTrue(inventory.equals(inventory));
    }

    @Test
    public void inventoryEqualsIdentical() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap copyInventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        copyInventory.addItem("item1", 10);
        copyInventory.addItem("item2", 20);
        assertTrue(inventory.equals(copyInventory));
    }

    @Test
    public void inventoryNotEqualsDifferent() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap differentInventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        differentInventory.addItem("item1", 5);
        differentInventory.addItem("item2", 15);
        assertTrue(!inventory.equals(differentInventory));
    }

    @Test
    public void inventoryHashCode() {

        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);

        InventoryOnMap identicalInventory = new InventoryOnMap();
        identicalInventory.addItem("item1", 10);
        identicalInventory.addItem("item2", 20);

        assertEquals(inventory.mapHashCode(), identicalInventory.mapHashCode());
    }

    @Test
    public void inventoryHashCodeDifferent() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);

        InventoryOnMap differentInventory = new InventoryOnMap();
        differentInventory.addItem("item1", 5);
        differentInventory.addItem("item2", 15);

        assertTrue(inventory.mapHashCode() != differentInventory.mapHashCode());
    }

}
