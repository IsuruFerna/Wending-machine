import java.util.TreeSet;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class ItemBook extends Thread {
    TreeSet<Item> items = new TreeSet<Item>();

    public TreeSet<Item> getItems() {
        return this.items;
    }

    public void addItem(Item i) {
        this.items.add(i);
        System.out.println("item added");
        System.out.println(this.getItems().toString());

        this.syncroCsvFile();
    }

    public String fileName = "items.csv";

    public String toCsv() {
        String result = "";
        for (Item item : this.items) {
            result += item.toCsv() + "\n";
        }
        return result;
    }

    private void syncroCsvFile() {
        try {
            FileWriter fr = new FileWriter(fileName);
            fr.write(this.toCsv());
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Item i : this.items) {
            result += i + "\n";
        }
        return result;
    }

    @Override
    public void run() {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String row = br.readLine();
                if (row == null)
                    break;
                String[] items = row.split(",");

                Item i = new Item(items[0], Double.parseDouble(items[1]));
                this.items.add(i);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public void editItems(int index, String newItemName, String newItemPrice) {
    // int i = 0;
    // for (Item item : items) {
    // if (i == index) {
    // item.setName(newItemName);
    // item.setPrice(newItemPrice);
    // this.syncroCsvFile();
    // break;
    // }
    // }
    // }

    // at java.base/java.util.TreeMap.put(TreeMap.java:785)
    // at java.base/java.util.TreeMap.put(TreeMap.java:534)
    // at java.base/java.util.TreeSet.add(TreeSet.java:255)
}
