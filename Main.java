public class Main {
    public static void main(String[] args) {
        System.out.println("wending machine");

        ItemBook itemBook = new ItemBook();
        Item item = new Item("Vodka", 20.00);

        itemBook.addItem(item);

    }
}
