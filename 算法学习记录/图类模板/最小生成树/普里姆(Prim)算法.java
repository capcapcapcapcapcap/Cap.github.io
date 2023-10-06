
//	邻接表法
    static int prim(Graph g)
    {
        boolean[] visit = new boolean[g.vertexs + 1];
        visit[1] = true;

        int ans = 0;// 最小生成树的权值和
        int count = 0; // 记录加入最小生成树的边的数量

        //堆优化，保证快速取出权值最小边
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        minHeap.addAll(g.table[1]);

        while (!minHeap.isEmpty())
        {
            Edge minEdge = minHeap.poll();
            int u = minEdge.end;
            int w = minEdge.weight;

            if (!visit[u])
            {
                visit[u] = true;
                ans += w;
                count++;
            }

            // 边的数量达到n-1时，最小生成树构建完成
            if (count == g.vertexs - 1)
                break; 
            
            for (Edge edge : g.table[u])
                if (!visit[edge.end])
                    minHeap.add(edge);
        }
        // 图不连通，无法构建最小生成树
        if (count < g.vertexs - 1)
            return -1;  

        return ans;
    }

//	邻接矩阵法
	static int prim(Graph g)
    {
        boolean[] visit=new boolean[g.vertexs+1];
        visit[1]=true;

        int ans=0;
        for(int m=1;m<g.vertexs;m++)
        {
            int max=(int)1e9;
            int node=0;

            for (int i=1;i<=g.vertexs;i++)
            {
                for(int u=1;u<=g.vertexs;u++)
                {
                    int w1=g.matrix[i][u];
                    int w2=g.matrix[u][i];
                    if(!visit[u]&&visit[i])
                    {
                        if(w1!=0&&w1<max)
                        {
                            max=w1;
                            node=u;
                        }
                        if(w2!=0&&w2<max)
                        {
                            max=w2;
                            node=u;
                        }
                    }
                }
            }
            
            visit[node]=true;
            ans+=max;
        }
        return ans;
    }