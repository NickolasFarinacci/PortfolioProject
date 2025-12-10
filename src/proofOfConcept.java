import components.map.Map;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class proofOfConcept {

        public static void main(String[] args) {

                SimpleWriter out = new SimpleWriter1L();

                Inventory playerInventory = new Inventory();
                Inventory empty = new Inventory();

                playerInventory.addItem("Material A", 12);
                playerInventory.addItem("Material B", 25);
                playerInventory.addItem("Material C", 62);
                playerInventory.addItem("Material D", 7);

                out.println("Total items: " + playerInventory.totalItems());

                Map.Pair<String, Integer> pair = playerInventory
                                .removeItem("Material B");
                out.println("Removed " + pair.key() + " with quantity "
                                + pair.value());
                out.println("Total items after removal: "
                                + playerInventory.totalItems());

                out.println();

                out.println("Is this inventory empty? "
                                + playerInventory.isEmpty());
                out.println("Is this inventory empty? " + empty.isEmpty());

                out.println();

                out.println("Does this inventory have Material A? "
                                + playerInventory.hasItem("Material A"));
                out.println("Does this inventory have Material B? "
                                + playerInventory.hasItem("Material B"));

                out.println();

                out.println("Unique items in inventory: "
                                + playerInventory.uniqueItems());

                out.println();

                out.println("Amount of Material A: "
                                + playerInventory.value("Material A"));

                playerInventory.addToItem("Material A", 5);

                out.println("New amount of Material A: "
                                + playerInventory.value("Material A"));

                out.println();

                out.println("Current amount of Material C: "
                                + playerInventory.value("Material C"));

                playerInventory.removeFromItem("Material C", 16);

                out.println("After removing 16, the new amount of Material C is: "
                                + playerInventory.value("Material C"));
        }

}
