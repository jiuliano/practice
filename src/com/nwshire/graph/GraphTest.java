package com.nwshire.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/14/2017.
 */
public class GraphTest {
    @Test
    public void graphTest() throws Exception {
        Graph graph = new Graph();

        //initialize some vertices and add them to the graph
        Vertex[] vertices = new Vertex[5];

        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Vertex("" + i);
            graph.addVertex(vertices[i], true);
        }

        //illustrate the fact that duplicate edges aren't added
        for(int i = 0; i < vertices.length - 1; i++){
            for(int j = i + 1; j < vertices.length; j++){
                graph.addEdge(vertices[i], vertices[j]);
                graph.addEdge(vertices[i], vertices[j]);
                graph.addEdge(vertices[j], vertices[i]);
            }
        }

        //display the initial setup- all vertices adjacent to each other
        for(int i = 0; i < vertices.length; i++){
            System.out.println(vertices[i]);

            for(int j = 0; j < vertices[i].getNeighborCount(); j++){
                System.out.println(vertices[i].getNeighbor(j));
            }

            System.out.println();
        }

        //overwritte Vertex 3
        graph.addVertex(new Vertex("3"), true);
        for(int i = 0; i < vertices.length; i++){
            System.out.println(vertices[i]);

            for(int j = 0; j < vertices[i].getNeighborCount(); j++){
                System.out.println(vertices[i].getNeighbor(j));
            }

            System.out.println();
        }

        Vertex vertex = graph.getVertex("5");
        System.out.println("Vertex 5: " + vertex); //null
        assertNull(vertex);

        vertex = graph.getVertex("3");
        System.out.println("Vertex 3: " + graph.getVertex("3")); //Vertex 3
        assertEquals(vertex.toString(), "Vertex 3");

        //true
        boolean result = graph.containsEdge(new Edge(graph.getVertex("1"), graph.getVertex("2")));
        System.out.println("Graph Contains {1, 2}: " + result);
        assertTrue(result);

        //true
        Edge edge = graph.removeEdge(new Edge(graph.getVertex("1"), graph.getVertex("2")));
        System.out.println(result);
        assertNotNull(edge);

        //false
        result = graph.containsEdge(new Edge(graph.getVertex("1"), graph.getVertex("2")));
        System.out.println("Graph Contains {1, 2}: " + result);
        assertFalse(result);

        //false
        result = graph.containsEdge(new Edge(graph.getVertex("2"), graph.getVertex("3")));
        System.out.println("Graph Contains {2, 3} " + result);
        assertFalse(result);

        result = graph.containsVertex(new Vertex("1"));
        System.out.println(result); //true
        assertTrue(result);

        result = graph.containsVertex(new Vertex("6"));
        System.out.println(result); //false
        assertFalse(result);

        vertex = graph.removeVertex("2");
        System.out.println(vertex); //Vertex 2
        assertEquals(vertex.toString(), "Vertex 2");

        System.out.println(graph.getVertexKeys()); //[3, 1, 0, 4]
    }
}