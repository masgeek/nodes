import java.util.*;
import java.util.stream.Collectors;

public class Node implements Comparable<Node> {

    int id;
    int parentID;
    String label;
    Node childA;
    List<Node> childB;


    public Node() {

    }

    public Node(int id, String label, int parentID) {
        this.id = id;
        this.parentID = parentID;
        this.label = label;
    }

    void printTree(ArrayList<Node> nodes, int... h) {
        Map<String, List<Node>> productMap = new HashMap<String, List<Node>>();

        while (nodes.size() > 0) {
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
        }
    }

    @Override
    public int compareTo(Node candidate) {
        return this.parentID < candidate.parentID ? -1 : 1;
    }

}
