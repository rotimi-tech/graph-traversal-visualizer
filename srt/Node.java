import java.util.*;

class Node {
    String name;                 // Name of the node, like A or B
    List<Edge> neighbors;        // Outgoing edges from this node
    boolean visited;             // Used by BFS and DFS to avoid revisiting nodes

    public Node(String name) {
        this.name = name;                    // Save the name of the node
        this.neighbors = new ArrayList<>(); // Start with an empty list of neighbors
        this.visited = false;               // Node starts as not visited
    }

    public void addEdge(Node destination, int weight) {
        // Add a directed edge from this node to the destination node
        neighbors.add(new Edge(destination, weight));
    }
}
