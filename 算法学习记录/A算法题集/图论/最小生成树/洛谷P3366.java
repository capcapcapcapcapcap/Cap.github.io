package com.VJ.vj825;

import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        public StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));

        public double nextDouble() throws IOException
        {
            in.nextToken();
            return in.nval;
        }

        public float nextFloat() throws IOException
        {
            in.nextToken();
            return (float) in.nval;
        }

        public int nextInt() throws IOException
        {
            in.nextToken();
            return (int) in.nval;
        }

        public String next() throws IOException
        {
            return in.sval;
        }

        public long nextLong() throws Exception
        {
            in.nextToken();
            return (long) in.nval;
        }
    }

    static int[] father;

    //查找最高父类
    static int find(int x)
    {
        if (x == father[x])
            return x;
            //深入查找父类的父类
        else return father[x] = find(father[x]);
    }

    //合并统一二者父类
    static void union(int a, int b)
    {
        int fa1 = find(a);
        int fa2 = find(b);
        if (fa1 != fa2)
            father[fa1] = fa2;
    }

    static class Graph {
        int vertexs;
        int edges;
        //邻接矩阵
        int[][] martixs;
        //邻接表/多重表
        LinkedList<Edge>[] table;
        //十字链表
        LinkedList<Edge>[] in_table;
        LinkedList<Edge>[] out_table;
        //边集数组
        char[] vertex;
        Edge[] edge;

        public Graph(int n, int m)
        {
            this.vertexs = n;
            this.edges = m;

        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int kruskal(Graph g)
    {
        father = new int[g.vertexs + 1];

        // 初始化并查集数组
        for (int i = 1; i < father.length; i++)
            father[i] = i;

        Arrays.sort(g.edge, Comparator.comparingInt(a -> a.weight));

        int ans = 0; // 最小生成树的权值和
        int count = 0; // 记录加入最小生成树的边的数量

        for (Edge e : g.edge)
        {
            int u = e.start;
            int v = e.end;
            int weight = e.weight;

            if (find(u) != find(v))
            {
                union(u, v);
                ans += weight;
                count++;
            }

            if (count == g.vertexs - 1)
                break; // 边的数量达到n-1时，最小生成树构建完成
        }

        if (count < g.vertexs - 1)
            return -1; // 图不连通，无法构建最小生成树

        return ans;
    }

    static int prim(Graph g)
    {
        boolean[] visit = new boolean[g.vertexs + 1];
        visit[1] = true;

        int ans = 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        minHeap.addAll(g.table[1]);

        while (!minHeap.isEmpty())
        {
            Edge minEdge = minHeap.poll();
            int u = minEdge.end;
            int w = minEdge.weight;

            if (visit[u])
                continue;

            visit[u] = true;
            ans += w;

            for (Edge edge : g.table[u])
                if (!visit[edge.end])
                    minHeap.add(edge);
        }
        for (int i = 1; i < visit.length; i++)
            if (!visit[i])
                return -1; // 图不连通，无法构建最小生成树

        return ans;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();

        Graph graph = new Graph(in.nextInt(), in.nextInt());
        graph.edge = new Edge[graph.edges];
        for (int i = 0; i < graph.edges; i++)
        {
            int start = in.nextInt();
            int end = in.nextInt();
            int weight = in.nextInt();
            graph.edge[i] = new Edge(start, end, weight);
        }

        int ans = kruskal(graph);
        if (ans == -1)
        {
            System.out.println("orz");
        } else
        {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();

        Graph graph = new Graph(in.nextInt(), in.nextInt());
        graph.table = new LinkedList[graph.vertexs + 1];
        for (int u = 1; u <= graph.vertexs; u++)
            graph.table[u] = new LinkedList<>();

        for (int i = 0; i < graph.edges; i++)
        {
            int start = in.nextInt();
            int end = in.nextInt();
            int weight = in.nextInt();
            graph.table[start].add(new Edge(start, end, weight));
            graph.table[end].add(new Edge(end, start, weight));
        }

        int ans = prim(graph);
        if (ans == -1)
        {
            System.out.println("orz");
        } else
        {
            System.out.println(ans);
        }
    }
}