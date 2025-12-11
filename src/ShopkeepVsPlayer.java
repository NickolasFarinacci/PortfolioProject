
import components.inventory.InventoryOnMap;
import components.set.Set;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

class ShopkeepVsPlayer {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        InventoryOnMap shopkeepInventory = new InventoryOnMap();
        InventoryOnMap playerInventory = new InventoryOnMap();

        InventoryOnMap itemsAndPrices = new InventoryOnMap();
        itemsAndPrices.addItem("Health Potion", 30);
        itemsAndPrices.addItem("Bombs", 20);
        itemsAndPrices.addItem("Arrows", 1);

        boolean valid = false;

        shopkeepInventory.addItem("Health Potion", 1);
        shopkeepInventory.addItem("Bombs", 30);
        shopkeepInventory.addItem("Arrows", 30);

        playerInventory.addItem("Health Potion", 5);
        playerInventory.addItem("Bombs", 10);
        playerInventory.addItem("Arrows", 20);

        out.println(
                "OHHHHH! A customer! Welcome to Beedle's Shop Ship! I deal");
        out.println(
                "in pretty much anything and everything! Do you have anything");
        out.println(
                "you don't need? If you do, show it to me! I'll pay top Ruppees");
        out.println(
                "for your junk!!! Or do you see something you want to buy?");

        while (!valid) {

            Set<String> shopkeepItems = shopkeepInventory.uniqueItems();
            out.println(
                    "What would you like to do? (Type 'buy,' 'sell,' or 'exit')");
            String response = in.nextLine().toLowerCase();

            if (response.equals("buy")) {

                out.println("Here is what I have for sale: ");
                out.println("" + shopkeepInventory.toString());
                out.println("What would you like to buy? ");
                String itemToBuy = in.nextLine();

                if (shopkeepItems.contains(itemToBuy)) {

                    int itemValue = shopkeepInventory.value(itemToBuy);
                    out.println("How many would you like to buy? (Max: "
                            + itemValue + ")");
                    int quantityToBuy = Integer.parseInt(in.nextLine());

                    out.println("That will be "
                            + itemsAndPrices.value(itemToBuy) + " Ruppees!");

                    shopkeepInventory.removeFromItem(itemToBuy, quantityToBuy);
                    playerInventory.addToItem(itemToBuy, quantityToBuy);

                    out.println("You just bought " + itemToBuy + "!");
                    out.println();
                    out.println("You're the greatest! I'll never forget you! ");
                } else {
                    out.println("Sorry, I don't have that item.");
                }

            } else if (response.equals("sell")) {

                out.println("What do you have to sell me? "
                        + playerInventory.toString());

                String itemToSell = in.nextLine();

                if (playerInventory.hasItem(itemToSell)) {

                    int itemValue = playerInventory.value(itemToSell);
                    out.println("How many would you like to sell? (Max: "
                            + itemValue + ")");
                    int quantityToSell = Integer.parseInt(in.nextLine());

                    out.println("I'll give you "
                            + itemsAndPrices.value(itemToSell) + " Ruppees!");

                    playerInventory.removeFromItem(itemToSell, quantityToSell);
                    shopkeepInventory.addToItem(itemToSell, quantityToSell);

                    out.println("You just sold " + itemToSell + "!");
                    out.println();
                    out.println("You're the greatest! I'll never forget you! ");
                } else {
                    out.println("Sorry, I don't want that item.");
                }
            } else if (response.equals("exit")) {
                valid = true;
                out.println("Thanks for stopping by! Come again!");
            } else {
                out.println("Sorry, I don't understand.");
            }

        }

        in.close();
        out.close();

    }

}
