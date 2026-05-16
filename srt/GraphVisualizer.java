import javax.swing.*;
import java.awt.*;
import java.util.*;

class GraphVisualizer extends JPanel {
    Graph graph;                   // Graph to draw
    Map<String, Point> positions;  // Screen positions for each node

    public GraphVisualizer(Graph graph) {
        this.graph = graph;
        this.positions = new HashMap<>();
        setBackground(Color.WHITE);
    }

    public void setNodePosition(String name, int x, int y) {
        positions.put(name, new Point(x, y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw edges first
        for (Node node : graph.nodes.values()) {
            Point start = positions.get(node.name);

            if (start == null) {
                continue;
            }

            for (Edge edge : node.neighbors) {
                Point end = positions.get(edge.destination.name);

                if (end == null) {
                    continue;
                }

                g.setColor(Color.BLACK);
                g.drawLine(start.x, start.y, end.x, end.y);

                int midX = (start.x + end.x) / 2;
                int midY = (start.y + end.y) / 2;
                g.drawString(String.valueOf(edge.weight), midX, midY);

                drawArrowHead(g, start.x, start.y, end.x, end.y);
            }
        }

        // Draw nodes second
        for (Node node : graph.nodes.values()) {
            Point p = positions.get(node.name);

            if (p == null) {
                continue;
            }

            g.setColor(Color.ORANGE);
            g.fillOval(p.x - 20, p.y - 20, 40, 40);

            g.setColor(Color.BLACK);
            g.drawOval(p.x - 20, p.y - 20, 40, 40);
            g.drawString(node.name, p.x - 5, p.y + 5);
        }
    }

    private void drawArrowHead(Graphics g, int x1, int y1, int x2, int y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int arrowLength = 10;

        int tipX = (int)(x2 - 20 * Math.cos(angle));
        int tipY = (int)(y2 - 20 * Math.sin(angle));

        int xArrow1 = (int)(tipX - arrowLength * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int)(tipY - arrowLength * Math.sin(angle - Math.PI / 6));

        int xArrow2 = (int)(tipX - arrowLength * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int)(tipY - arrowLength * Math.sin(angle + Math.PI / 6));

        g.drawLine(tipX, tipY, xArrow1, yArrow1);
        g.drawLine(tipX, tipY, xArrow2, yArrow2);
    }
}