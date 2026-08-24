import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Item item1 = new Item("Apple", 1.50); //items
        Item item2 = new Item("Book", 12.99);
        
        Item[] items = {item1, item2}; //array

        System.out.println("Regular Array:");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        ArrayList<Item> itemList = new ArrayList<Item>(); //List
        itemList.add(item1);
        itemList.add(item2);
        System.out.println();
        System.out.println("ArrayList:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }


        Item[][] item2D = {{item1, item2}}; //2d array
        System.out.println();
        System.out.println("2D Array:");
        for (int row = 0; row < item2D.length; row++) {
            for (int col = 0; col < item2D[row].length; col++) {
                System.out.println(item2D[row][col]);
            }
        }
    }
}

