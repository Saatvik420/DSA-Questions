import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class Edge {
        int node;
        double weight;
        
        public Edge(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    
    public double maxProbability(int n, int[][] eg, double[] p, int src, int e) {
        List<Edge>[] g = new ArrayList[n];
        
        // Creating an adjacency list representation of the graph
        // based on the given edges and probabilities
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < eg.length; i++) {
            g[eg[i][0]].add(new Edge(eg[i][1], p[i]));
            g[eg[i][1]].add(new Edge(eg[i][0], p[i]));
        }
        
        double[] dis = new double[n]; // Initializing distances from source to all nodes as 0
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight)); // Priority queue to store nodes based on their maximum probability
        
        pq.offer(new Edge(src, 1)); // Pushing the source node with a probability of 1
        dis[src] = 1; // Updating the distance of the source node as 1
        
        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            double nodeDis = top.weight; // Current maximum probability
            int node = top.node; // Current node
            
            if (node == e) {
                return nodeDis; // If the current node is the destination, return its maximum probability
            }
            
            // Traverse all the neighboring nodes of the current node
            for (Edge child : g[node]) {
                int childNode = child.node; // Neighboring node
                double childWt = child.weight; // Probability of reaching the neighboring node
                
                // If the current maximum probability multiplied by the probability of reaching the neighboring node
                // is greater than the previously calculated maximum probability for the neighboring node,
                // update the maximum probability and push the neighboring node into the priority queue
                if (childWt * nodeDis > dis[childNode]) {
                    dis[childNode] = childWt * nodeDis;
                    pq.offer(new Edge(childNode, dis[childNode]));
                }
            }
        }
        
        return 0; // If no path is found from source to destination, return 0
    }
}