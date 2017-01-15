package com.nwshire.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/14/2017.
 */
public class Vertex {
    List<Edge> edges;
    String label;

    public Vertex(String label) {
        this.label = label;
        this.edges = new ArrayList<Edge>();
    }

    public String getLabel() {
        return label;
    }

    public void addNeighbor(Edge edge) {
        if ( !edges.contains(edge) ) {
            edges.add(edge);
        }
    }

    public boolean containsNeighbor(Edge edge) {
        return edges.contains(edge);
    }

    public Edge getNeighbor(int index) {
        return edges.get(index);
    }

    Edge removeNeighbor(int index) {
        return edges.remove(index);
    }

    public void removeNeighbor(Edge edge) {
        edges.remove(edge);
    }

    public int getNeighborCount() {
        return edges.size();
    }

    public List<Edge> getNeighbors() {
        return new ArrayList<Edge>(edges);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;

        if ( obj instanceof Vertex ) {
            equals = ((Vertex)obj).label.equals(label);
        }

        return equals;
    }

    @Override
    public String toString() {
        return "Vertex " + label;
    }
}

