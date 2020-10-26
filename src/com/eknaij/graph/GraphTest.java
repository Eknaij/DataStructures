package com.eknaij.graph;

/**
 * @Author Eknaij
 * @Date 2020/10/23 15:10
 * @Description TODO
 */
public class GraphTest {
    public static void main(String[] args) {
        int n = 7;
        String vertexs[] = {"A", "B", "C", "D", "E", "F", "G"};
        //创建图的对象
        Graph graph = new Graph(n);
        //循环添加对应的顶点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 6, 1);

        graph.insertEdge(1, 0, 1);
        graph.insertEdge(1, 5, 1);

        graph.insertEdge(2, 0, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(2, 4, 1);

        graph.insertEdge(3, 2, 1);

        graph.insertEdge(4, 2, 1);

        graph.insertEdge(5, 1, 1);
        graph.insertEdge(6, 0, 1);
        //显示
        graph.show();
//        graph.dfs(0);//深度优先遍历
        graph.bfs();//广度优先遍历
    }
}
