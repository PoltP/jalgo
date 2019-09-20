package com.jalgo.datastructures;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<TValue, TWeight extends Comparable> {
    private HashMap<TValue, Vertex<TValue, TWeight>> vertices = new HashMap<>();

    public static <TValue> List<TValue> bellmanFordSearch(Graph<TValue, Integer> graph, TValue startValue, TValue finishValue) {
        HashMap<TValue, TValue> pathMap = new HashMap<>();
        HashMap<TValue, Integer> distances = new HashMap<>() {{
            put(startValue, 0);
        }};
        for (Vertex<TValue, Integer> vertex : graph.vertices.values()) {
            for (Edge<TValue, Integer> edge : vertex.edges) {
                Integer oldDistance = distances.getOrDefault(edge.dest.value, Integer.MAX_VALUE);
                Integer newDistance = distances.getOrDefault(vertex.value, Integer.MAX_VALUE);
                if (newDistance != Integer.MAX_VALUE && newDistance + edge.weight < oldDistance) {
                    distances.put(edge.dest.value, newDistance + edge.weight);
                    pathMap.put(edge.dest.value, vertex.value);
                }
            }
        }
        // TODO: check for negative-weight cycles
        return extractPath(pathMap, startValue, finishValue);
    }

    public static <TValue> List<TValue> dijkstraSearch(Graph<TValue, Integer> graph, TValue startValue, TValue finishValue) {
        Vertex<TValue, Integer> start = getVertex(graph, startValue);
        Vertex<TValue, Integer> finish = getVertex(graph, finishValue);
        HashMap<TValue, TValue> pathMap = new HashMap<>();
        HashSet<Vertex<TValue, Integer>> visited = new HashSet<>();
        HashMap<TValue, Integer> distances = new HashMap<>() {{
            put(startValue, 0);
        }};
        Comparator<Vertex<TValue, Integer>> comparator = Comparator.comparing(v -> distances.getOrDefault(v.value, Integer.MAX_VALUE));
        PriorityQueue<Vertex<TValue, Integer>> priorityQueue = new PriorityQueue<>(comparator) {{
            offer(start);
        }};

        while (!priorityQueue.isEmpty()) {
            Vertex<TValue, Integer> current = priorityQueue.poll();
            if (visited.contains(current))
                continue;
            if (current == finish) {
                return extractPath(pathMap, startValue, finishValue);
            }
            visited.add(current);
            for (Edge<TValue, Integer> edge : current.edges) {
                if (!visited.contains(edge.dest)) {
                    Integer oldDistance = distances.getOrDefault(edge.dest.value, Integer.MAX_VALUE);
                    Integer newDistance = distances.getOrDefault(current.value, Integer.MAX_VALUE) + edge.weight;
                    if (newDistance < oldDistance) {
                        distances.put(edge.dest.value, newDistance);
                        pathMap.put(edge.dest.value, current.value);
                    }
                    priorityQueue.offer(edge.dest);
                }
            }
        }
        return null;
    }

    public void addVertex(TValue value) {
        vertices.put(value, new Vertex<>(value));
    }

    public void addEdge(TValue srcValue, TValue destValue) {
        this.addEdge(srcValue, destValue, null);
    }

    public void addEdge(TValue srcValue, TValue destValue, TWeight weight) {
        Vertex src = this.getVertex(srcValue);
        Vertex dest = this.getVertex(destValue);
        src.addEdge(dest, weight);
    }

    public List<TValue> bfs(TValue startValue, TValue finishValue) {
        Queue<Vertex<TValue, TWeight>> queue = new LinkedList<>();
        return this.search(startValue, finishValue, queue, () -> queue.poll());
    }

    public List<TValue> dfs(TValue startValue, TValue finishValue) {
        Stack<Vertex<TValue, TWeight>> stack = new Stack<>();
        return this.search(startValue, finishValue, stack, () -> stack.pop());
    }

    @Override
    public String toString() {
        return this.vertices.values().stream().map(vertex -> vertex.toString())
                .collect(Collectors.joining(" "));
    }

    private Vertex<TValue, TWeight> getVertex(TValue value) {
        return getVertex(this, value);
    }

    private List<TValue> search(TValue startValue, TValue finishValue,
                                Collection<Vertex<TValue, TWeight>> sequence, IteratorFunc iterator) {
        Vertex<TValue, TWeight> start = this.getVertex(startValue);
        Vertex<TValue, TWeight> finish = this.getVertex(finishValue);
        HashMap<TValue, TValue> pathMap = new HashMap<>();
        HashSet<Vertex<TValue, TWeight>> visited = new HashSet<>();

        sequence.add(start);
        while (!sequence.isEmpty()) {
            Vertex<TValue, TWeight> current = iterator.next();
            if (visited.contains(current))
                continue;
            if (current == finish) {
                return extractPath(pathMap, startValue, finishValue);
            }
            visited.add(current);
            for (Edge<TValue, TWeight> edge : current.edges) {
                if (!visited.contains(edge.dest)) {
                    sequence.add(edge.dest);
                    pathMap.put(edge.dest.value, current.value);
                }
            }
        }
        return null;
    }

    private static <TValue, TWeight extends Comparable> Vertex getVertex(Graph<TValue, TWeight> graph, TValue value) {
        Vertex vertex = graph.vertices.getOrDefault(value, null);
        if (vertex == null)
            throw new IllegalArgumentException("Vertex '" + value + "' does not exist");
        return vertex;
    }

    private static <TValue> List<TValue> extractPath(HashMap<TValue, TValue> pathMap,
                                                     TValue startValue, TValue finishValue) {
        ArrayList<TValue> path = new ArrayList<>();
        TValue current = finishValue;
        while (current != startValue && current != null) {
            path.add(0, current);
            current = pathMap.get(current);
        }
        if(current == startValue) {
            path.add(0, startValue);
            return path;
        } else {
            return null;
        }
    }

    public static class Vertex<TValue, TWeight extends Comparable> {
        ArrayList<Edge<TValue, TWeight>> edges = new ArrayList<>();
        TValue value;

        public Vertex(TValue value) {
            this.value = value;
        }

        public void addEdge(Vertex<TValue, TWeight> vertex, TWeight weight) {
            this.edges.add(new Edge(vertex, weight));
        }

        public boolean hasEdge(Vertex<TValue, TWeight> dest) {
            return edges.stream().anyMatch(edge -> dest.equals(edge.dest));
        }

        @Override
        public String toString() {
            String str = '[' + this.value.toString();
            if (!edges.isEmpty()) {
                str += " -> " + edges.stream().map(edge -> edge.dest.value.toString())
                        .collect(Collectors.joining(", "));
            }
            return str + ']';
        }
    }

    public static class Edge<TValue, TWeight extends Comparable> {
        Vertex<TValue, TWeight> dest;
        TWeight weight;

        public Edge(Vertex<TValue, TWeight> dest, TWeight weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private interface IteratorFunc<TValue, TWeight extends Comparable> {
        Vertex<TValue, TWeight> next();
    }
}
