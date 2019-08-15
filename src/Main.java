import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Node printNode = new Node();

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(123, "NodeB", 7000));
        nodes.add(new Node(7000, "NodeA", 0));
        nodes.add(new Node(9, "NodeC", 123));
        nodes.add(new Node(3, "NodeF", 0));
        nodes.add(new Node(25, "NodeE", 7000));
        nodes.add(new Node(2, "NodeD", 7000));
        nodes.add(new Node(10, "NodeG", 3));


        printNode.printTree(nodes);


    }

}
