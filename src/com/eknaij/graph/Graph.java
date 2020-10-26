package com.eknaij.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Eknaij
 * @Date 2020/10/23 14:40
 * @Description 图
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储对应的邻接矩阵
    private int numOfEdges;//表示边的数量

    //定义个数组记录顶点是否被访问
    private boolean[] isVisited;

    public Graph(int n) {
        //初始化矩阵和 vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //图常用的方法

    //深度优先遍历

    /**
     * @param edge 开始遍历的顶点
     */
    public void dfs(int edge) {
        System.out.print(vertexList.get(edge) + "->");
        isVisited[edge] = true;//标记当前节点已经被访问
        for (int j = edge + 1; j < edges.length; j++) {//查找连通点
            int weight = edges[edge][j];
            if (weight != 0) {//判断edge这个当前顶点是否已经与j顶点连通
                if (!isVisited[j]) {//判断是否已访问过
                    dfs(j);
                }
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < edges.length; i++) {
            if (!isVisited[i]) {//如果当前顶点没访问过
                isVisited[i] = true;
                //将当前访问的顶点加入到队列中
                queue.add(i);
                //打印出已访问的顶点
                System.out.print(vertexList.get(i) + "->");
                while (!queue.isEmpty()) {
                    //本层顶点出队
                    int k = queue.poll();
                    // 遍历本层顶点k所有未被访问的邻接节点,放入队列
                    for (int j = k; j < edges.length; j++) {
                        if (edges[k][j] == 1 && !isVisited[j]) {
                            isVisited[j] = true;
                            queue.add(j);
                            System.out.print(vertexList.get(j) + "->");
                        }
                    }
                }
            }

        }
    }

    //返回顶点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    //返回节点i对应的顶点
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示对应的矩阵
    public void show() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * @param vertex 顶点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1     表示点的下标即使第几个顶点 "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 邻接矩阵的值，1表示顶点间连通
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        //由于是无向图，所以另一边也对应
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
