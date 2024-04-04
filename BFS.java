import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph g = new Graph();
        // System.out.print("Enter the number of edges: ");
        // int n = scanner.nextInt();
        // System.out.println("Enter the edges (format: u v): ");
        // for (int i = 0; i < n; i++) {
        //     int u = scanner.nextInt();
        //     int v = scanner.nextInt();
        //     g.addEdge(u, v);
        // }

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Enter the starting vertex for BFS: ");
        // int startVertex = scanner.nextInt();
        int startVertex = 2;

        scanner.close();

        System.out.println("Following is Breadth First Traversal (starting from vertex " + startVertex + ")");
        g.BFS(startVertex);
    }
}
