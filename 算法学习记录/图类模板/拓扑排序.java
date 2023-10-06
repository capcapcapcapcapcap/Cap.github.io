    static List<Integer> topologicalSort(Graph g)
    {
        List<Integer> ans = new LinkedList();
        Queue<Integer> q = new LinkedList();

        //找出入度为0的顶点作为起点
        for (int i = 1; i <= g.vertexs; i++)
            if (g.in[i] == 0)
                q.offer(i);

        //将起点的邻接点入度-1,若为0则得到新的起点
        while (!q.isEmpty())
        {
            int ver = q.poll();
            ans.add(ver);
            for (Edge now : g.out_table[ver])
            {
                if (--g.in[now.end] == 0)
                    q.offer(now.end);
            }
        }

        //若未拓扑出所有顶点,说明该有向图存在回路,不是AOV网
        if (ans.size() < g.vertexs)
            return null;
        return ans;
    }