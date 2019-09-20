package com.jalgo.datastructures.test;

import com.jalgo.datastructures.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    @Test
    public void construct() {
        Graph graph = constructTestGraph();
        assertEquals("[1 -> 2, 3, 6] [2 -> 3, 4] [3 -> 4, 6] [4 -> 5] [5 -> 6] [6]", graph.toString());
    }

    @Test
    public void bfs() {
        Graph graph = constructTestGraph();
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, graph.bfs(1, 5).toArray());
        assertArrayEquals(new Integer[]{1, 2, 3, 6}, graph.bfs(1, 6).toArray());
        assertArrayEquals(new Integer[]{2, 3, 6}, graph.bfs(2, 6).toArray());
        assertEquals(null, graph.bfs(4, 1));
    }

    @Test
    public void dfs() {
        Graph graph = constructTestGraph();
        assertArrayEquals(new Integer[]{1, 3, 4, 5}, graph.dfs(1, 5).toArray());
        assertArrayEquals(new Integer[]{1, 6}, graph.dfs(1, 6).toArray());
        assertArrayEquals(new Integer[]{2, 4, 5, 6}, graph.dfs(2, 6).toArray());// 3th vertex - first stack element
        assertEquals(null, graph.dfs(4, 1));
    }

    @Test
    public void dijkstra() {
        Graph graph = constructTestGraph();
        assertArrayEquals(new Integer[]{1, 3, 4, 5}, Graph.dijkstraSearch(graph, 1, 5).toArray());
        assertArrayEquals(new Integer[]{1, 3, 6}, Graph.dijkstraSearch(graph, 1, 6).toArray());
        assertArrayEquals(new Integer[]{2, 3, 6}, Graph.dijkstraSearch(graph, 2, 6).toArray());// 3th vertex - first stack element
        assertEquals(null, Graph.dijkstraSearch(graph, 4, 1));
        extendTestGraph(graph);
        assertArrayEquals(new Integer[]{1, 2, 7, 8, 9, 6}, Graph.dijkstraSearch(graph, 1, 6).toArray());

    }

    @Test
    public void bellman_ford() {
        Graph graph = constructTestGraph();
        assertArrayEquals(new Integer[]{1, 3, 4, 5}, Graph.bellmanFordSearch(graph, 1, 5).toArray());
        assertArrayEquals(new Integer[]{1, 3, 6}, Graph.bellmanFordSearch(graph, 1, 6).toArray());
        assertArrayEquals(new Integer[]{2, 3, 6}, Graph.bellmanFordSearch(graph, 2, 6).toArray());// 3th vertex - first stack element
        assertEquals(null, Graph.bellmanFordSearch(graph, 4, 1));
        extendTestGraph(graph);
        assertArrayEquals(new Integer[]{1, 2, 7, 8, 9, 6}, Graph.bellmanFordSearch(graph, 1, 6).toArray());
    }

    /*

      [6]<----9----[5]
      ^ ^\           ^\
      |   \             6
      |     3             \
      |      \              \
     14       [3]-----11---->[4]
      |      /^ ^\          /^
      |     /     \       15
      |    9       10    /
      |  /           \  /
     [1]------7----->[2]

   */
    private static Graph<Integer, Integer> constructTestGraph() {
        return new Graph<>() {{
            addVertex(1);
            addVertex(2);
            addVertex(3);
            addVertex(4);
            addVertex(5);
            addVertex(6);

            addEdge(1, 2, 7);
            addEdge(1, 3, 9);
            addEdge(1, 6, 14);
            addEdge(2, 3, 10);
            addEdge(2, 4, 15);
            addEdge(3, 4, 11);
            addEdge(3, 6, 3);
            addEdge(4, 5, 6);
            addEdge(5, 6, 9);
        }};
    }

    /*

            [9]<----1----[8]
           /              ^
          /               |
         1                1
        /                 |
       v          ...  --[7]
      [6]                /^
      ...               1
                 ...   /
                    \ /
              ... --[2]

    */
    private static void extendTestGraph(Graph<Integer, Integer> graph) {
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);

        graph.addEdge(2, 7, 1);
        graph.addEdge(7, 8, 1);
        graph.addEdge(8, 9, 1);
        graph.addEdge(9, 6, 1);
    }
}
