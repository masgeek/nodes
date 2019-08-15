import java.util.*;
import java.util.stream.Collectors;

public class Node implements Comparable<Node> {

    int id;
    int parentID;
    String label;


    int nLongestString = 1;

    public Node() {

    }

    public Node(int id, String label, int parentID) {
        this.id = id;
        this.parentID = parentID;
        this.label = label;
    }

    void printTree(ArrayList<Node> nodes) {
//        Collections.sort(nodes);
        HashMap<String, List<Node>> productMap = new HashMap<String, List<Node>>();
        for (Node product : nodes) {
            String pid = String.valueOf(product.parentID);

            if (productMap.containsKey(pid)) {
                productMap.get(pid).add(product);
            } else {
                List<Node> list = new ArrayList<Node>();
                list.add(product);
                productMap.put(pid, list);
            }
        }
        for (String key : productMap.keySet()) {
            List<Node> nodesList = productMap.get(key);
            for(Node node: nodesList){
                System.out.println("Node "+node.label+" Parent id"+node.parentID);
            }
        }


    }

    void printTree(ArrayList<Node> nodes, int nextLevel) {
        Collections.sort(nodes);

        StringBuilder str = new StringBuilder();
        while (nextLevel <= 0) {
            for (Node n : nodes) {

                int length = String.valueOf(n.parentID).length();
                if (length > nLongestString) {
                    nLongestString = length;
                }
                String format = "%" + nLongestString + "s:\n";

                System.out.printf(format, n.label);

            }

            nextLevel = 4;
        }


    }


    @Override
    public int compareTo(Node candidate) {
        return this.parentID < candidate.parentID ? -1 : 1;
    }


}
