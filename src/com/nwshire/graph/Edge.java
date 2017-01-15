package com.nwshire.graph;

/**
 * Created by james on 1/14/2017.
 */
public class Edge implements Comparable<Edge> {
    Vertex v1, v2;
    int weight;

    public Edge(Vertex v1, Vertex v2) {
        this(v1,v2,1);
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vertex getNeighbor(Vertex current) {
        Vertex n = null;

        if ( current.equals(v1) ) {
            n = v2;
        } else if ( current.equals(v2) ) {
            n = v1;
        }

        return n;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }

    public String toString() {
        return "({" + v1 + ", " + v2 + "}, " + weight + ")";
    }

    public int hashCode() {
        return (v1.getLabel() + v2.getLabel()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;

        if ( obj instanceof Edge ) {
            Edge o = (Edge)obj;
            equals = v1.equals(o.v1) && v2.equals(o.v2);
        }

        return equals;
    }
}
