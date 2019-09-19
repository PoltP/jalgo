package com.jalgo.datastructures;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<TValue, TWeight> {
    private HashMap<TValue, Vertex<TValue, TWeight>> vertices = new HashMap<>();

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
        return this.traverse(startValue, finishValue, queue, () -> queue.poll());
    }

    public List<TValue> dfs(TValue startValue, TValue finishValue) {
        Stack<Vertex<TValue, TWeight>> stack= new Stack<>();
        return this.traverse(startValue, finishValue, stack, () -> stack.pop());
    }

    @Override
    public String toString() {
        return this.vertices.values().stream().map(vertex -> vertex.toString())
                .collect(Collectors.joining(" "));
    }

    private Vertex<TValue, TWeight> getVertex(TValue value) {
        Vertex vertex = vertices.getOrDefault(value, null);
        if (vertex == null)
            throw new IllegalArgumentException("Vertex '" + value + "' does not exist");
        return vertex;
    }

    private List<TValue> traverse(TValue startValue, TValue finishValue,
            Collection<Vertex<TValue, TWeight>> sequence, IteratorFunc iterator) {
        Vertex<TValue, TWeight> start = this.getVertex(startValue);
        Vertex<TValue, TWeight> finish = this.getVertex(finishValue);
        ArrayList<Vertex<TValue, TWeight>> path = new ArrayList<>();
        HashSet<Vertex<TValue, TWeight>> visited = new HashSet<>();

        sequence.add(start);
        while (!sequence.isEmpty()) {
            Vertex<TValue, TWeight> current = iterator.next();
            if(visited.contains(current))
                continue;;
            path.add(current);
            if(current == finish) {
                return this.clearPath(path);
            }
            visited.add(current);
            for(Edge<TValue, TWeight> edge : current.edges) {
                if(!visited.contains(edge.dest)) {
                    sequence.add(edge.dest);
                }
            }
        }
        return null;
    }

    private List<TValue> clearPath(ArrayList<Vertex<TValue, TWeight>> path) {
        for (int i = path.size() - 1; i > 0; i--) {
            if(!path.get(i-1).hasEdge(path.get(i))) {
                path.remove(path.get(i-1));
            }
        }
        return path.stream().map(vertex -> vertex.value).collect(Collectors.toList());
    }

    public static class Vertex<TValue, TWeight> {
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

    public static class Edge<TValue, TWeight> {
        Vertex<TValue, TWeight> dest;
        TWeight weight;

        public Edge(Vertex<TValue, TWeight> dest, TWeight weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private interface IteratorFunc<TValue, TWeight> {
        Vertex<TValue, TWeight> next();
    }
}
