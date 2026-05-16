class Edge {
    Node destination;   // The node this edge points to
    int weight;         // The cost or weight of the edge

    public Edge(Node destination, int weight) {
        this.destination = destination; // Save the destination node
        this.weight = weight;           // Save the edge weight
    }
}