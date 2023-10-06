    
    static int[] dist;//	某点到其他所有顶点的最短距离
    final static int INF = Integer.MAX_VALUE;

    static void dijkstra(Graph g, int start)
    {
        int[][] ma = g.matrix;//邻接矩阵
        //	未访问顶点集
        Queue<Integer> not_visit = new LinkedList<>();
        for (int i = 1; i < g.vertexs; i++)
            not_visit.add(i);

        dist = new int[g.vertexs + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        //共有vertexs个顶点,故需要循环vertexs次才能遍历所有顶点
        for (int i = 1; i <= g.vertexs; i++)
        {
            /*
             * 找出未访问节点中距离起始点s距离最短的顶点cur
             * 根据贪心原理,那么目前记录的 start->cur 距离dist必恒为最短距离.
             * 也即是说,之后不会存在某中间顶点bri,使得 s->bri->cur距离比dist更短
             * 因为当前 s->bri 距离已经大于 s->cur
             */
            int cur = 0;//当前顶点

            for (int now : not_visit)
                if (cur == 0 || dist[now] < dist[cur])
                    cur = now;

            not_visit.remove(cur);

            //更新 起始点 到 与顶点cur相邻的顶点 的最短距离
            //当 start->cur->now的距离小于之前的 start->now 时更新
            for (int now : not_visit)
            {
                if (ma[cur][now] != INF && dist[cur] + ma[cur][now] < dist[now])
                    dist[now] = dist[cur] + ma[cur][now];
            }

        }
    }