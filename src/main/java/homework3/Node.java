package homework3;

import java.util.ArrayList;

public class Node {
    String key; // key for the node, used for comparisons during tree operations
    ArrayList<Entry> values; // list of entries associated with this key
    Node left, right;  // left and right child nodes in the tree
    boolean color; // color of the node, used in Red-Black Tree balancing operations

    // Constructor
    public Node(String key, Entry entry, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(entry);
        this.color = color;
    }
}