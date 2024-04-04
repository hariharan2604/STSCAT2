import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> graph;
    public Set<Integer> visited;

    public Graph() {
        graph = new HashMap<>();
        visited = new HashSet<>();
    }

    public void addEdge(int u, int v) {
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    public void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            List<Integer> neighbors = graph.get(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public void DFS(int s) {
        System.out.print(s + " ");
        visited.add(s);
        // System.out.println("Visited: " + visited);
        List<Integer> neighbors = graph.get(s);
        if (neighbors != null) {
            for (int n : neighbors) {
                if (!visited.contains(n)) {
                    DFS(n);
                }
            }
        }
    }

}

public class BreadthFirst_DepthFirst {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Graph g = new Graph();

    // Add edges to the graph
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    // Get the starting vertex for traversal
    int startVertex = 2;

    scanner.close();

    // Clear the visited set before traversal
    g.visited.clear();

    // Print BFS traversal
    System.out.println("Following is Breadth First Traversal (starting from vertex " + startVertex + ")");
    g.BFS(startVertex);

    System.out.println(); // Add a newline for clarity

    // Clear the visited set before traversal
    g.visited.clear();

    // Print DFS traversal
    System.out.println("Following is Depth First Traversal (starting from vertex " + startVertex + ")");
    g.DFS(startVertex);
}

}
