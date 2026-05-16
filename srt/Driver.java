import javax.swing.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
        // Create all 4 graphs from the lab
        Graph graph1 = createGraph1();
        Graph graph2 = createGraph2();
        Graph graph3 = createGraph3();
        Graph graph4 = createGraph4();

        // Print traversal results for each graph
        runTraversals("Graph 1", graph1);
        runTraversals("Graph 2", graph2);
        runTraversals("Graph 3", graph3);
        runTraversals("Graph 4", graph4);

        // Open visualizer windows for each graph
        showGraph1(graph1);
        showGraph2(graph2);
        showGraph3(graph3);
        showGraph4(graph4);
    }

    // GRAPH CREATION

    public static Graph createGraph1() {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 1);
        graph.addEdge("B", "E", 1);

        return graph;
    }

    
    public static Graph createGraph2() {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 1);
        graph.addEdge("C", "E", 1);

        return graph;
    }

    
    public static Graph createGraph3() {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 1);

        return graph;
    }

    
    public static Graph createGraph4() {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 1);
        graph.addEdge("A", "D", 1);
        graph.addEdge("A", "E", 1);

        return graph;
    }

    // TRAVERSAL OUTPUT

    public static void runTraversals(String graphName, Graph graph) {
        System.out.println("----- " + graphName + " -----");
        System.out.println("BFS: " + graph.bfs("A"));
        System.out.println("DFS: " + graph.dfs("A"));
        System.out.println();
    }

    // VISUALIZERS

    public static void showGraph1(Graph graph) {
        GraphVisualizer panel = new GraphVisualizer(graph);

        panel.setNodePosition("A", 200, 60);
        panel.setNodePosition("B", 130, 150);
        panel.setNodePosition("C", 270, 150);
        panel.setNodePosition("D", 90, 250);
        panel.setNodePosition("E", 170, 250);

        makeFrame("Graph 1 Visualization", panel);
    }

    public static void showGraph2(Graph graph) {
        GraphVisualizer panel = new GraphVisualizer(graph);

        panel.setNodePosition("A", 200, 60);
        panel.setNodePosition("B", 130, 150);
        panel.setNodePosition("C", 270, 150);
        panel.setNodePosition("D", 100, 250);
        panel.setNodePosition("E", 300, 250);

        makeFrame("Graph 2 Visualization", panel);
    }

    public static void showGraph3(Graph graph) {
        GraphVisualizer panel = new GraphVisualizer(graph);

        panel.setNodePosition("A", 60, 150);
        panel.setNodePosition("B", 140, 150);
        panel.setNodePosition("C", 220, 150);
        panel.setNodePosition("D", 300, 150);
        panel.setNodePosition("E", 380, 150);

        makeFrame("Graph 3 Visualization", panel);
    }

    public static void showGraph4(Graph graph) {
        GraphVisualizer panel = new GraphVisualizer(graph);

        panel.setNodePosition("A", 220, 60);
        panel.setNodePosition("B", 80, 180);
        panel.setNodePosition("C", 180, 180);
        panel.setNodePosition("D", 280, 180);
        panel.setNodePosition("E", 380, 180);

        makeFrame("Graph 4 Visualization", panel);
    }

    public static void makeFrame(String title, GraphVisualizer panel) {
        JFrame frame = new JFrame(title);
        frame.add(panel);
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*
    MANUAL TRAVERSAL PREDICTIONS

    Graph 1 Prediction
    BFS: [A, B, C, D, E]
    DFS: [A, B, D, E, C]

    Graph 2 Prediction
    BFS: [A, B, C, D, E]
    DFS: [A, B, D, C, E]

    Graph 3 Prediction
    BFS: [A, B, C, D, E]
    DFS: [A, B, C, D, E]

    Graph 4 Prediction
    BFS: [A, B, C, D, E]
    DFS: [A, B, C, D, E]

    CODE TRAVERSAL OUTPUT:

    Graph 1 Output
    BFS: [A, B, C, D, E]
    DFS: [A, B, D, E, C]

    Graph 2 Output
    BFS: [A, B, C, D, E]
    DFS: [A, B, D, C, E]

    Graph 3 Output
    BFS: [A, B, C, D, E]
    DFS: [A, B, C, D, E]

    Graph 4 Output
    BFS: [A, B, C, D, E]
    DFS: [A, B, C, D, E]

    REFLECTION QUESTIONS:

    1. Yeah, that checks out. In Graph 3, you’ve just got a straight line—A to B to C to D to E.
    There’s nowhere else for the search to go, so both BFS and DFS hit the nodes in exactly the same order: A, B, C, D, E.


    2. Makes sense. In Graph 4, A connects straight to B, C, D, and E. BFS starts at A and then visits all its neighbors in order. 
    DFS kicks off at A too, and since all four kids are right there—and they don’t lead anywhere else—both searches cover the nodes in the same sequence.


    3. My guesses lined up with what actually happened for all four graphs.
    That’s just because I stuck to the order the edges were added, and the search order comes down to how the neighbors appear in the adjacency list.


    4. I’d go with BFS if I needed the shortest path in an unweighted graph.
    BFS works level by level, so the moment you reach a node, you’ve already found the path with the fewest edges from the start.


    5. Instead of using recursive DFS, I’d switch to an iterative version that uses an explicit stack.
    That way, you won’t run into problems with the call stack overflowing if the graph gets really deep.

    */
}