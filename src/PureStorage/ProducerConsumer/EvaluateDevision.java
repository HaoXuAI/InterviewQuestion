package PureStorage.ProducerConsumer;

import java.util.*;

/**
 * Created by hao on 10/21/17.
 * leetcode 399
 */
public class EvaluateDevision {
    private static class Node {
        String val;
        List<Edge> edges;

        public Node(String val) {
            this.val = val;
            this.edges = new ArrayList<>();
        }

        public String getVal() {
            return val;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdge(Edge e) {
            this.edges.add(e);
        }
    }

    private static class Edge {
        double val;
        Node next;

        public Edge(double val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private static Map<String, Node> map = new HashMap<>();

    private static void buildGraph(String[][] equations, double[] values) {
        if (equations == null || equations.length == 0 || values == null ||equations.length != values.length) return;
        for (int i = 0; i < equations.length; i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new Node(equations[i][0]));
            }
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new Node(equations[i][1]));
            }
            Node src = map.get(equations[i][0]);
            Node dest = map.get(equations[i][1]);
            Edge edge1 = new Edge(values[i], dest);
            Edge edge2 = new Edge(1 / values[i], src);
            src.addEdge(edge1);
            dest.addEdge(edge2);
        }
    }

    private static double calc(String a, String b, double ans, Set<String> visited) {
        if (!map.containsKey(a) || !map.containsKey(b)) return -1.0;
        if (a.equals(b)) return ans;
        Node src = map.get(a);
        List<Edge> neighbors = src.getEdges();
        for (int i = 0; i < neighbors.size(); i++) {
            Edge e = neighbors.get(i);
            if (visited.contains(e.next.val)) continue;
            visited.add(e.next.val);
            double res = calc(e.next.val, b, ans * e.val, visited);
            if (res != -1.0) return res;

        }
        return -1.0;
    }


    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        buildGraph(equations, values);
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = calc(queries[i][0], queries[i][1], 1.0, new HashSet<>());
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] res = calcEquation(equations, values, queries);
        for (double r : res) {
            System.out.println(r);
        }
    }
}
