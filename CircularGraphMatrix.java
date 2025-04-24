public class CircularGraphMatrix {
    static class Vertex {
        String name;
        int distance;

        Vertex(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Vertex[] vertices = {
                new Vertex("I", 2),
                new Vertex("A", 5),
                new Vertex("E", 4),
                new Vertex("F", 2),
                new Vertex("T", 2),
                new Vertex("S", 3)
        };

        int n = vertices.length;
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int dist = vertices[i].distance;
            int leftIndex = (i - dist + n) % n;
            int rightIndex = (i + dist) % n;

            adjMatrix[i][leftIndex] = 1;
            adjMatrix[i][rightIndex] = 1;
        }

        System.out.print("    ");
        for (Vertex v : vertices) {
            System.out.print(v.name + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(vertices[i].name + " | ");
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
