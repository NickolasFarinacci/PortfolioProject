import components.inventory.InventoryOnMap;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

class CraftingBook {
    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        boolean done = false;

        InventoryOnMap inventory = new InventoryOnMap();
        inventory.addItem("wood", 50);
        inventory.addItem("stick", 24);
        inventory.addItem("leather", 13);
        inventory.addItem("iron", 16);

        Set<String> craftingRecipes = new Set1L<>();
        craftingRecipes.add("wooden sword");
        craftingRecipes.add("leather armor");
        craftingRecipes.add("iron shield");

        while (!done) {

            System.out.println("Initial Inventory: " + inventory.toString());

            out.println("What would you like to craft? options are: "
                    + craftingRecipes.toString());
            out.println("if you want to exit, type 'exit'");
            String itemToCraft = in.nextLine().toLowerCase();

            if (craftingRecipes.contains(itemToCraft)) {
                out.println("Crafting " + itemToCraft + "...");
                if (itemToCraft.equals("wooden sword")) {

                    if (inventory.value("wood") < 2
                            || inventory.value("stick") < 1) {
                        out.println(
                                "Sorry, you don't have enough resources to craft a wooden sword.");
                    } else {

                        inventory.removeFromItem("wood", 2);
                        inventory.removeFromItem("stick", 1);

                        out.println(
                                "Successfully crafted " + itemToCraft + "!");

                    }

                } else if (itemToCraft.equals("leather armor")) {

                    if (inventory.value("leather") < 8) {
                        out.println(
                                "Sorry, you don't have enough resources to craft leather armor.");
                    } else {

                        inventory.removeFromItem("leather", 8);

                        out.println(
                                "Successfully crafted " + itemToCraft + "!");

                    }

                } else if (itemToCraft.equals("iron shield")) {

                    if (inventory.value("iron") < 1
                            || inventory.value("wood") < 6) {
                        out.println(
                                "Sorry, you don't have enough resources to craft an iron shield.");
                    } else {

                        inventory.removeFromItem("iron", 1);
                        inventory.removeFromItem("wood", 6);

                        out.println(
                                "Successfully crafted " + itemToCraft + "!");

                    }

                }
            } else if (itemToCraft.equals("exit")) {
                done = true;
                out.println("Exiting crafting book. Goodbye!");
            } else {
                out.println("Sorry, we don't have a recipe for " + itemToCraft);
            }

        }

        in.close();
        out.close();

    }

}
