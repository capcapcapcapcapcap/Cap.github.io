    static class Graph {
        int vertexs;
        int edges;
        //邻接矩阵
        int[][] matrix;
        //邻接表/多重表
        LinkedList<Edge>[] table;
        //十字链表
        int[] in;//入度
        int[] out;//出度
        LinkedList<Edge>[] in_table;
        LinkedList<Edge>[] out_table;
        //边集数组
        char[] vertex;
        Edge[] edge;

        public Graph(int n, int m)
        {
            this(n);
            edges = m;
        }

        public Graph(int n)
        {
            vertexs = n;
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int n, int m)
        {
            start = n;
            end = m;
        }

        public Edge(int n, int m, int w)
        {
            this(n, m);
            weight = w;
        }
    }