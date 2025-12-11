package components.inventory;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

/**
 * An implementation of {@code InventorySecondary} represented as a {@link Map}
 * with implementations of primary methods.
 *
 * @author Nick Farinacci
 * @convention This class uses the standard representation for {@code Map}s
 *             defined in the components.standard package. The keys are of type
 *             {@code String} and the values are of type {@code Integer}.
 *             Moreover, no key in the map has value less than or equal to 0 and
 *             no value. No value can also exceed 99.
 * @correspondence this = [value mapping of type String to Integer in a Map]
 */
public final class InventoryOnMap extends InventorySecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * The map representing this inventory.
     */
    private Map<String, Integer> map;

    /**
     * Creates a new representation of this inventory.
     */
    private void createNewRep() {
        this.map = new Map1L<String, Integer>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * Default constructor.
     */
    public InventoryOnMap() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public InventoryOnMap newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    /**
     * Transfers the contents of the source inventory to this inventory.
     * 
     * @param source
     */
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

    @Override
    public void addItem(String item, int amount) {
        assert item != null : "Violation of: item is not null";
        assert amount > 0 : "Violation of: amount > 0";

        this.map.add(item, amount);

    }

    @Override
    public Map.Pair<String, Integer> removeItem(String item) {
        assert item != null : "Violation of: item is not null";
        assert this.map.hasKey(item) : "Violation of: item is in this";

        return this.map.remove(item);

    }

    @Override
    public boolean hasItem(String item) {
        assert item != null : "Violation of: item is not null";

        return this.map.hasKey(item);

    }

    @Override
    public int value(String item) {
        assert item != null : "Violation of: item is not null";
        assert this.map.hasKey(item) : "Violation of: item is in this";

        return (int) this.map.value(item);

    }

    @Override
    public int totalItems() {

        int total = 0;

        for (Map.Pair<String, Integer> p : this.map) {

            total += (int) p.value();

        }

        return total;

    }

    @Override
    public void addToItem(String item, int amount) {

        final int ninetyNine = 99;
        int total = this.map.value(item) + amount;
        if (total > ninetyNine) {
            total = ninetyNine;
        }

        this.map.replaceValue(item, total);

    }

    @Override
    public void removeFromItem(String item, int amount) {
        if (this.map.value(item) - amount <= 0) {
            this.map.remove(item);
        } else {
            this.map.replaceValue(item, this.map.value(item) - amount);
        }
    }

    @Override
    public Set<String> uniqueItems() {

        Set<String> uniqueItems = new Set1L<String>();

        for (Map.Pair<String, Integer> p : this.map) {

            uniqueItems.add(p.key());

        }

        return uniqueItems;

    }

    @Override
    public int mapHashCode() {
        return this.map.hashCode();
    }

    @Override
    public void transferFrom(InventoryKernel other) {
        assert other != null : "Violation of: other is not null";
        assert other != this : "Violation of: this and other are distinct";

        InventoryOnMap localOther = (InventoryOnMap) other;
        this.map = localOther.map;
        localOther.createNewRep();

    }

}
