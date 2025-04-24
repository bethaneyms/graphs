import java.util.*;

public class SimplePaths {
    static class Edge {
        String to;
        int weight;
        Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static Map<String, List<Edge>> graph = new HashMap<>();

    public static void findPaths(String current, String target, int totalWeight, int maxWeight, Set<String> visited, List<String> path) {
        if (totalWeight > maxWeight) return;

        path.add(current);
        visited.add(current);

        if (current.equals(target) && totalWeight == maxWeight) {
            System.out.println(path);
        } else {
            for (Edge e : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(e.to)) {
                    findPaths(e.to, target, totalWeight + e.weight, maxWeight, visited, path);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {

        graph.put("A", Arrays.asList(new Edge("B", 3), new Edge("C", 4)));
        graph.put("B", Arrays.asList(new Edge("D", 4)));
        graph.put("C", Arrays.asList(new Edge("D", 3)));
        graph.put("D", new ArrayList<>());

        findPaths("A", "D", 0, 7, new HashSet<>(), new ArrayList<>());
    }
}

