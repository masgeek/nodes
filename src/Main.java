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
        List<Node> listA = new ArrayList<>();
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

        Map<Integer, List<Node>> croupedList =
                listA.stream().collect(Collectors.groupingBy(w -> w.parentID));

        int h = croupedList.size();
//        for (Node product : nodes) {
//            int pid = product.id;
//
//            if (productMap.containsKey(pid)) {
//                productMap.get(pid).add(product.childA = product);
//            } else {
//                List<Node> list = new ArrayList<Node>();
//                list.add(product.childA = product);
//                productMap.put(pid, list);
//            }
//        }
//
//        Map<Integer, List<Node>> finalNode =productMap;
//
//        String firstKey = "";
        for (int key : productMap.keySet()) {
            List<Node> nodesList = productMap.get(key);
//            System.out.println(String.format("%s", key));
            for (Node node : nodesList) {
                if (node.id==key) {
                    List<Node> nodesListB = productMap.get(node.id);
                    System.out.println(String.format("  %s myid %s parent %s key %s", node.label, node.id, node.parentID, key));
                }

            }
        }

//        int size = finalNode.size();

    }

}
