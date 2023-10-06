	static int[] etv;//顶点(事件)最早到达时间
    static int[] ltv;//顶点(事件)最晚到达时间
    static int ete;//弧(活动)最早发生时间
    static int lte;//弧(活动)最晚发生时间
    static Edge[] kp;//关键路径

    static void keyPath(Graph g)
    {
        etv = new int[g.vertexs + 1];
        ltv = new int[g.vertexs + 1];
        kp=new Edge[g.vertexs-1];
        Stack<Integer> topo = topologicalSort(g);
        Arrays.fill(ltv, etv[topo.peek()]);
        while (!topo.isEmpty())
        {
            int ver = topo.pop();
            for (Edge now : g.in_table[ver])
            {
                //将最晚时间往前提,
                // 表明若晚于该时间,则最后事件无法在之前的规定时间内到达
                if (ltv[ver] > ltv[now.end] - now.weight)
                    ltv[ver] = ltv[now.end] - now.weight;
            }
        }

        //求弧(活动)的最早/晚发生时间
        int index=0;
        for (int u = 1; u <= g.vertexs; u++)
        {
            for (Edge now : g.out_table[u])
            {
                ete=etv[u];
                lte=ltv[now.end]-now.weight;
                //若最早和最晚相同,则说明该弧为关键弧,即它决定了整体时间的长短
                if(ete==lte)
                    kp[index++]=now;
            }

        }

    }


    static Stack<Integer> topologicalSort(Graph g)
    {
        Stack<Integer> ans = new Stack();
        Queue<Integer> q = new LinkedList();

        //找出入度为0的顶点作为起点
        for (int i = 1; i <= g.vertexs; i++)
            if (g.in[i] == 0)
                q.offer(i);

        //将起点的邻接点入度-1,若为0则得到新的起点
        while (!q.isEmpty())
        {
            int ver = q.poll();
            ans.push(ver);
            for (Edge now : g.out_table[ver])
            {
                if (--g.in[now.end] == 0)
                    q.offer(now.end);

                //将最早开始时间往后推,
                //表明即使在该时间才开始,仍然可以最快到达最后的事件
                if (etv[now.end] < etv[ver] + now.weight)
                    etv[now.end] = etv[ver] + now.weight;

            }
        }

        //若未拓扑出所有顶点,说明该有向图存在回路,不是AOV网
        if (ans.size() < g.vertexs)
            return null;
        return ans;
    }