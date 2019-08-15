import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


        printTree(nodes);


    }

    static void printTree(ArrayList<Node> nodes) {
        Map<Integer, List<Node>> productMap = new HashMap<>();
        Map<Integer, Node> keyNodes = new HashMap<>();
        List<Node> listA = new ArrayList<>();

        for (Node product : nodes) {
            int pid = product.parentID;
            keyNodes.put(pid, product);
        }

        for (Node product : nodes) {
            int pid = product.parentID;
            listA.add(product);
            if (productMap.containsKey(pid)) {
                productMap.get(pid).add(product);
            } else {
                List<Node> list = new ArrayList<Node>();
                list.add(product);
                productMap.put(pid, list);
            }
        }

        Map<Integer, List<Node>> groupedList =
                listA.stream().collect(Collectors.groupingBy(w -> w.parentID));


        for (int key : keyNodes.keySet()) {
            Node k = keyNodes.get(key);
            List<Node> nodesList = productMap.get(key);
            System.out.println(String.format("%s", k.label));


        }
        boolean h = true;
        if (h) {
            return;
        }
        for (int key : groupedList.keySet()) {
            List<Node> nodesList = productMap.get(key);
//                System.out.println(String.format("%s", key));
            for (Node node : nodesList) {
                System.out.println(String.format("  %s", node.label));
            }
        }
    }

}
