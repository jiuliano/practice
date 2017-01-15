package com.nwshire.graph;

import java.util.*;

/**
 * Created by james on 1/14/2017.
 */
public class Graph {
    private Map<String,Vertex> vertices = new HashMap<>();
    private Map<Integer,Edge> edges = new HashMap<>();

    public Graph() {
    }

    public Graph(List<Vertex> vertices){
        for(Vertex v: vertices){
            this.vertices.put(v.getLabel(), v);
        }
    }

    public boolean addEdge(Vertex v1, Vertex v2) {
        return addEdge(v1, v2, 1);
    }

    public boolean addEdge(Vertex v1, Vertex v2, int weight) {
        boolean added = false;

        if ( !v1.equals(v2) )
        {
            Edge edge = new Edge(v1,v2,weight);

            if ( !edges.containsKey(edge.hashCode()) )
            {
                if ( !v1.containsNeighbor(edge) && !v2.containsNeighbor(edge) )
                {
                    edges.put(edge.hashCode(), edge);
                    v1.addNeighbor(edge);
                    v2.addNeighbor(edge);
                    added = true;
                }
            }
        }

        return added;
    }

    public boolean containsEdge(Edge edge) {
        return edge.getV1() != null && edge.getV2() != null && edges.containsKey(edge.hashCode());
    }

    public Edge removeEdge(Edge edge) {
        edge.getV1().removeNeighbor(edge);
        edge.getV2().removeNeighbor(edge);
        return edges.remove(edge.hashCode());
    }

    public boolean containsVertex(Vertex vertex) {
        return vertices.containsKey(vertex.getLabel());
    }

    public Vertex getVertex(String label) {
        return vertices.get(label);
    }

    public boolean addVertex(Vertex vertex, boolean overwriteExisting) {
        boolean added = false;
        Vertex current = vertices.get(vertex.getLabel());

        if( current == null || overwriteExisting ) {
            if ( current != null ) {
                removeVertex(current);
            }

            vertices.put(vertex.getLabel(), vertex);
            added = true;
        }

        return added;
    }

    public Vertex removeVertex(String label) {
        Vertex vertex = vertices.remove(label);

        if ( vertex != null ) {
            removeVertex(vertex);
        }

        return vertex;
    }

    private void removeVertex(Vertex vertex) {
        while ( vertex.getNeighborCount() > 0 ) {
            removeEdge(vertex.getNeighbor(0));
        }
    }

    public Set<String> getVertexKeys() {
        return vertices.keySet();
    }

    public Set<Edge> getEdges() {
        return new HashSet<Edge>(edges.values());
    }
}
