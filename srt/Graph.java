import java.util.*;

class Graph {
    Map<String, Node> nodes; // Stores all nodes using their names

    public Graph() {
        nodes = new LinkedHashMap<>(); // LinkedHashMap keeps insertion order
    }

    // Add a new node to the graph
    public void addNode(String name) {
        if (!nodes.containsKey(name)) {
            nodes.put(name, new Node(name));
        }
    }

    // Connect two nodes with a weighted edge
    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from); // Get starting node
        Node toNode = nodes.get(to);     // Get destination node

        if (fromNode == null || toNode == null) {
            System.out.println("Error: one or both nodes do not exist.");
            return;
        }

        fromNode.addEdge(toNode, weight); // Add directed edge
    }

    // Print the graph
    public void printGraph() {
        for (Node node : nodes.values()) {
            System.out.println("Node " + node.name + " is connected to:");

            for (Edge edge : node.neighbors) {
                System.out.println(edge.destination.name +
                                   " (weight: " + edge.weight + ")");
            }
        }
    }

    // Reset all nodes to unvisited before a new traversal
    public void resetVisited() {
        for (Node node : nodes.values()) {
            node.visited = false;
        }
    }

    // Breadth-First Search using a queue
    public List<String> bfs(String startName) {
        List<String> order = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        resetVisited();

        Node start = nodes.get(startName);
        if (start == null) {
            return order;
        }

        start.visited = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            order.add(current.name);

            for (Edge edge : current.neighbors) {
                Node neighbor = edge.destination;

                if (!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }

        return order;
    }

    // Depth-First Search using recursion
    public List<String> dfs(String startName) {
        List<String> order = new ArrayList<>();

        resetVisited();

        Node start = nodes.get(startName);
        if (start == null) {
            return order;
        }

        dfsHelper(start, order);
        return order;
    }

    // Recursive helper method for DFS
    private void dfsHelper(Node current, List<String> order) {
        current.visited = true;
        order.add(current.name);

        for (Edge edge : current.neighbors) {
            Node neighbor = edge.destination;

            if (!neighbor.visited) {
                dfsHelper(neighbor, order);
            }
        }
    }
}