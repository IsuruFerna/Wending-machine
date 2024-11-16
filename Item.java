public class Item implements Comparable<Item> {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toCsv() {
        return this.name + " : " + this.price;
    }

    @Override
    public String toString() {
        return this.name + " " + this.price + " ";
    }

    @Override
    public int compareTo(Item o) {
        int value = this.name.compareToIgnoreCase(o.getName());
        if (value != 0)
            return value;
        value = this.name.compareToIgnoreCase(o.getName());
        return value;
    }

}
