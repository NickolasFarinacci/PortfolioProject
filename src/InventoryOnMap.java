import components.map.Map;
import components.map.Map1L;

/**
 * An implementation of {@code InventorySecondary} represented as a {@link Map}
 * with implementations of primary methods.
 *
 * @author Nick Farinacci
 * @convention This class uses the standard representation for {@code Map}s
 *             defined in the components.standard package.
 * @correspondence this = [value mapping of type String to Integer in a Map]
 */
public final class InventoryOnMap extends InventorySecondary {

    /*
     * Private members --------------------------------------------------------
     */
    private Map<String, Integer> map;

    private void createNewRep() {
        this.map = new Map1L<String, Integer>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */
    private InventoryOnMap() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    public InventoryOnMap newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    public void clear() {
        this.createNewRep();
    }

    public void transferFrom(Inventory source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: this and source are distinct";
        assert source instanceof InventoryOnMap : ""
                + "Violation of: source is of dynamic type Map1L<?,?>";

        InventoryOnMap localSource = (InventoryOnMap) source;
        this.map = localSource.map;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    public void addItem(String item, Integer amount) {
        assert item != null : "Violation of: item is not null";
        assert amount != null : "Violation of: amount is not null";

        int amountInt = (int) amount;

        if (0 < amountInt && amountInt <= 99) {

            this.map.add(item, amount);

        } else {

            if (amountInt > 99) {

                this.map.add(item, 99);

            }

        }

    }

    Map.Pair<String, Integer> removeItem(String item) {
        assert item != null : "Violation of: item is not null";
        assert this.map.hasKey(item) : "Violation of: item is in this";

        return this.map.remove(item);

    }

    boolean hasItem(String item) {
        assert item != null : "Violation of: item is not null";

        return this.map.hasKey(item);

    }

    int value(String item) {
        assert item != null : "Violation of: item is not null";
        assert this.map.hasKey(item) : "Violation of: item is in this";

        return (int) this.map.value(item);

    }

    int totalItems() {

        int total = 0;

        for (Map.Pair<String, Integer> p : this.map) {

            total += (int) p.value();

        }

        return total;

    }

}
