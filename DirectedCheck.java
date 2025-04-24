public class DirectedCheck {
    public static boolean isDirected(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        boolean directed = isDirected(matrix);

        if (directed) {
            System.out.println("The graph is directed.");
        } else {
            System.out.println("The graph is undirected.");
        }
    }
}
