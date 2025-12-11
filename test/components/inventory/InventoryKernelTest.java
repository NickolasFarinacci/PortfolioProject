package components.inventory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;;

public class InventoryKernelTest {

    @Test
    public void inventoryAddOneItem() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();

        inventory.addItem("item1", 10);

        expectedInventory.addItem("item1", 10);

        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryAddMultipleItems() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();

        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);

        expectedInventory.addItem("item1", 10);
        expectedInventory.addItem("item2", 20);

        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryAddManyItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();

        inventory.addItem("item1", 10);
        inventory.addItem("item2", 20);
        inventory.addItem("item3", 30);

        expectedInventory.addItem("item1", 10);
        expectedInventory.addItem("item2", 20);
        expectedInventory.addItem("item3", 30);

        assertEquals(expectedInventory, inventory);
    }

    @Test
    public void inventoryRemoveItem() {

        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();

        inventory.addItem("item1", 30);
        expectedInventory.addItem("item1", 30);

        Map.Pair<String, Integer> pair = inventory.removeItem("item1");
        Map.Pair<String, Integer> expectedPair = expectedInventory
                .removeItem("item1");

        assertEquals(expectedInventory, inventory);
        assertEquals(expectedPair, pair);

    }

    @Test
    public void inventoryRemoveTwoItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();

        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);
        expectedInventory.addItem("item1", 30);
        expectedInventory.addItem("item2", 40);

        Map.Pair<String, Integer> pair1 = inventory.removeItem("item1");
        Map.Pair<String, Integer> expectedPair1 = expectedInventory
                .removeItem("item1");

        Map.Pair<String, Integer> pair2 = inventory.removeItem("item2");
        Map.Pair<String, Integer> expectedPair2 = expectedInventory
                .removeItem("item2");

        assertEquals(expectedInventory, inventory);
        assertEquals(expectedPair1, pair1);
        assertEquals(expectedPair2, pair2);

    }

    @Test
    public void inventoryRemoveFromMultipleItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        InventoryOnMap expectedInventory = new InventoryOnMap();

        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);
        inventory.addItem("item3", 10);

        expectedInventory.addItem("item1", 30);
        expectedInventory.addItem("item2", 40);
        expectedInventory.addItem("item3", 10);

        Map.Pair<String, Integer> pair = inventory.removeItem("item2");
        Map.Pair<String, Integer> expectedPair = expectedInventory
                .removeItem("item2");

        assertEquals(expectedInventory, inventory);
        assertEquals(expectedPair, pair);

    }

    @Test
    public void inventoryHasItem() {

        InventoryOnMap inventory = new InventoryOnMap();

        inventory.addItem("item1", 30);

        assertEquals(true, inventory.hasItem("item1"));

    }

    @Test
    public void inventoryDoesNotHaveItem() {
        InventoryOnMap inventory = new InventoryOnMap();

        inventory.addItem("item1", 30);

        assertEquals(false, inventory.hasItem("item2"));

    }

    @Test
    public void inventoryValueOfItem() {
        InventoryOnMap inventory = new InventoryOnMap();

        inventory.addItem("item1", 30);

        assertEquals(30, inventory.value("item1"));

    }

    @Test
    public void inventoryValueofMultipleItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);

        assertEquals(30, inventory.value("item1"));
        assertEquals(40, inventory.value("item2"));

    }

    @Test
    public void inventoryChangingValueOfItem() {

        InventoryOnMap inventory = new InventoryOnMap();

        inventory.addItem("item1", 30);

        assertEquals(30, inventory.value("item1"));

        inventory.removeItem("item1");
        inventory.addItem("item1", 50);

        assertEquals(50, inventory.value("item1"));

    }

    @Test
    public void inventoryTotalItems() {
        InventoryOnMap inventory = new InventoryOnMap();

        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);

        assertEquals(70, inventory.totalItems());

    }

    @Test
    public void inventoryTotalItemsEmpty() {
        InventoryOnMap inventory = new InventoryOnMap();
        assertEquals(0, inventory.totalItems());
    }

    @Test
    public void inventoryTotalItemsOneItem() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        assertEquals(30, inventory.totalItems());
    }

    @Test
    public void inventoryUniqueItems() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        inventory.addItem("item2", 40);

        assertEquals(2, inventory.uniqueItems().size());
        assertEquals(true, inventory.uniqueItems().contains("item1"));
        assertEquals(true, inventory.uniqueItems().contains("item2"));

    }

    @Test
    public void inventoryUniqueItemsEmpty() {
        InventoryOnMap inventory = new InventoryOnMap();
        assertEquals(0, inventory.uniqueItems().size());
    }

    @Test
    public void inventoryUniqueItemsOneItem() {
        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("item1", 30);
        assertEquals(1, inventory.uniqueItems().size());
        assertEquals(true, inventory.uniqueItems().contains("item1"));
    }

}
