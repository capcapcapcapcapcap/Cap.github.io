    final static int INF = Integer.MAX_VALUE;
    static int[][] dist;
    static int[][] path;

    static void floyd(Graph g)
    {
        int n = g.vertexs + 1;

        dist = new int[n][n];//距离矩阵,表示每个顶点到其他顶点的最短距离
        path = new int[n][n];//路径矩阵,表示两点间的中转点bridge
        //初始化矩阵
        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++)
            {
                dist[i][j] = g.matrix[i][j];
                path[i][j] = j;
            }

        // 计算最短路径:k表示路径的中转点,相当与dijkstra中的bri;
        for (int k = 1; k < n; k++)
        {
            //i相当于dijkstra算法中的起始点
            for (int i = 1; i < n; i++)
                //ji相当于终点
                for (int j = 1; j < n; j++)
                    if (dist[i][j] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[i][k];
                    }
        }

    }