    
    static int[] father;
    //查找最高父类
    static int find(int x)
    {
        if(x==father[x])
            return x;
        //深入查找父类的父类
        else return father[x]=find(father[x]);
    }

    //合并统一二者父类
    static void union(int a,int b)
    {
        int fa1=find(a);
        int fa2=find(b);
        if(fa1!=fa2)
            father[fa1]=fa2;
    }
