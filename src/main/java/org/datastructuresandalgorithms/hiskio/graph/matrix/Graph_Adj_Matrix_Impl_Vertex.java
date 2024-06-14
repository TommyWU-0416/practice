package org.datastructuresandalgorithms.hiskio.graph.matrix;

public class Graph_Adj_Matrix_Impl_Vertex {
    private Integer adj_matrix[][];
    private char[] v_states;

    public Graph_Adj_Matrix_Impl_Vertex(int num_of_vertice) {
        adj_matrix = new Integer[num_of_vertice][num_of_vertice];
        v_states = new char[num_of_vertice];

        // init
        for (int row = 0; row < adj_matrix.length; row++) {
            for (int col = 0; col < adj_matrix[row].length; col++) {
                adj_matrix[row][col] = Integer.MIN_VALUE;
            }
        }

        for (int row = 0; row < adj_matrix.length; row++) {
            v_states[row] = (char) ('A' + row);
        }
    }

    public void set_edge(int i_vertex_src, int i_vertex_dst, Integer weight) {
        adj_matrix[i_vertex_src][i_vertex_dst] = weight;
    }

    public Integer get_edge(int i_vertex_src, int i_vertex_dst) {
        return adj_matrix[i_vertex_src][i_vertex_dst];
    }

    public void print_edge() {
        System.out.print("  ");
        for (int col = 0; col < adj_matrix[0].length; col++) {
            System.out.print(v_states[col] + " ");
        }
        System.out.println();


        for (int row = 0; row < adj_matrix.length; row++) {
            System.out.print(v_states[row] + " ");
            for (int col = 0; col < adj_matrix[row].length; col++) {
                if (adj_matrix[row][col] != Integer.MIN_VALUE) {
                    System.out.print(adj_matrix[row][col] + " ");
                } else {
                    System.out.print("∞" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph_Adj_Matrix_Impl_Vertex graph = new Graph_Adj_Matrix_Impl_Vertex(5);

        // test get_edge
        Integer edge_before = graph.get_edge(0, 2);
        System.out.println("edge_before:" + edge_before);

        // test set_edge
        graph.set_edge(0, 0, 0);
        graph.set_edge(0, 1, 1);
        graph.set_edge(0, 2, 3);

        graph.set_edge(1, 1, 0);
        graph.set_edge(1, 4, 7);

        graph.set_edge(2, 2, 0);
        graph.set_edge(2, 3, 2);
        graph.set_edge(2, 4, 2);

        graph.set_edge(3, 3, 0);
        graph.set_edge(3, 4, 9);

        graph.set_edge(4, 4, 0);
        graph.set_edge(4, 3, 9);

        Integer edge_after = graph.get_edge(0, 2);
        System.out.println("edge_after:" + edge_after);

        graph.print_edge();
    }
}
