public class Runner {

    public static void main(String[] args) {

        Node n1 = new Node("cat");
        Node n2 = new Node("dog");
        Node n3 = new Node("bird");
        Node n4 = new Node("bear");
        Node n5 = new Node("pig");

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        Node current = n1;
        while (current != null) {
            System.out.println(current.get());
            current = current.next();
        }
    }
}
