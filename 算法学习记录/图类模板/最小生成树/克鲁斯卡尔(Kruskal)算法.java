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
            // 边的数量达到n-1时，最小生成树构建完成
            if (count == g.vertexs - 1)
                break; 
        }
        // 图不连通，无法构建最小生成树
        if (count < g.vertexs - 1)
            return -1; 

        return ans;
    }