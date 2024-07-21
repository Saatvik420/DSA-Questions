class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Perform topological sort on row conditions
        int[] rowOrder = topologicalSort(k, rowConditions);
        // Perform topological sort on column conditions
        int[] colOrder = topologicalSort(k, colConditions);

        // If either topological sort returns null, it means a cycle was detected and no valid ordering exists
        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }

        // Initialize the k x k matrix with all zeros
        int[][] matrix = new int[k][k];
        
        // Arrays to store the final positions of each number in rows and columns
        int[] rowPosition = new int[k + 1];
        int[] colPosition = new int[k + 1];

        // Fill the rowPosition and colPosition arrays with the indices from the topological sorts
        for (int i = 0; i < k; i++) {
            rowPosition[rowOrder[i]] = i;
            colPosition[colOrder[i]] = i;
        }

        // Populate the matrix with the numbers from 1 to k based on their positions
        for (int i = 1; i <= k; i++) {
            matrix[rowPosition[i]][colPosition[i]] = i;
        }

        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        // Initialize the adjacency list for the graph and the in-degree array
        List<Integer>[] graph = new List[k + 1];
        int[] inDegree = new int[k + 1];

        // Create empty lists for each node in the graph
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph and update the in-degrees based on the conditions
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }

        // Initialize the queue with nodes that have zero in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Array to store the topological order
        int[] order = new int[k];
        int index = 0;

        // Process the nodes in topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;

            // Decrease the in-degree of the neighbors and add them to the queue if their in-degree becomes zero
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all nodes are processed, return the order; otherwise, return null indicating a cycle
        return index == k ? order : null;
    }
}