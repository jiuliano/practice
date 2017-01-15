package com.nwshire.leetcode;

import java.util.*;

/**
 * Created by james on 1/14/2017.
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Graph graph = new Graph();

        for ( int n=0; n<values.length; n++ ) {
            graph.addEdge(equations[n][0], equations[n][1], values[n]);
            graph.addEdge(equations[n][1], equations[n][0], 1.0 / values[n]);
        }

        double results[] = new double[queries.length];
        for ( int n=0; n<queries.length; n++ ) {
            results[n] = graph.findPath(queries[n][0], queries[n][1]);
        }

        return results;
    }

    private class Graph {
        private Map<String,Map<String,Double>> edgeList = new HashMap<>();

        void addEdge(String v1, String v2, double value) {
            Map<String,Double> nMap = edgeList.get(v1);

            if ( nMap == null ) {
                nMap = new HashMap<>();
                edgeList.put(v1, nMap);
            }

            nMap.put(v2, value);
        }

        Set<String> getNeighbors(String v1) {
            Set<String> neighbors;
            Map<String,Double> nMap = edgeList.get(v1);

            if ( nMap != null ) {
                neighbors = nMap.keySet();
            } else {
                neighbors = new HashSet<>();
            }

            return neighbors;
        }

        Double getValue(String v1, String v2) {
            Double value = null;
            Map<String,Double> nMap = edgeList.get(v1);

            if ( nMap != null ) {
                value = nMap.get(v2);
            }

            return value;
        }

        Double findPath(String v1, String v2) {
            Double value = findPath(v1, v2, new HashSet<>());
            return value == null ? -1.0 : value;
        }

        private Double findPath(String v1, String v2, Set<String> visited) {
            Double value = getValue(v1, v2);

            if ( value == null ) {
                Set<String> ns = getNeighbors(v1);

                for ( String n : ns ) {
                    if ( !visited.contains(n) ) {
                        visited.add(v1);
                        value = findPath(n, v2, new HashSet(visited));

                        if ( value != null ) {
                            value = value * getValue(v1, n);
                            break;
                        }
                    }
                }
            }

            return value;
        }
    }
}
