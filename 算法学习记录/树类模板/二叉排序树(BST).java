    static class Node
    {
        int value;
        Node left;
        Node right;
        public Node(int value)
        {
            this.value=value;
        }
    }

    //创建二叉排序树BST
    public static Node buildBST(int[] tree)
    {
        Node BST = null;
        int len = tree.length;
        for (int i = 0; i < len; i++)
            BST = addBST(BST, tree[i]);
        return BST;
    }


    //查找节点
    public static boolean searchBST(int key, Node BST)
    {
        while (BST != null)
        {
            int value = BST.value;
            if (key == value)
                return true;
            else if (key < value)
                BST = BST.left;
            else BST = BST.right;
        }
        return false;
    }

    //添加节点
    public static Node addBST(Node root, int key)
    {
        if (root == null)
            return new Node(key);
        if(key<=root.value)
            root.left=addBST(root.left,key);
        else root.right=addBST(root.right,key);
        return root
    }

    //删除节点
    public static Node deleteBST(Node root, int key)
    {
        if(root==null)
            return null;
        if(key<root.value)
            root.left=deleteBST(root.left,key);
        else if(key>root.value)
            root.right=deleteBST(root.right,key);
        else
        {
            //待删除节点有三种情况
            //1.无左右子树:直接将BST的子树置空
            if (root.right == null && root.left == null)
                root = null;

            //2.仅有右/左子树：将待删除节点的右/左子树变作BST的子树
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root.left = root.left;


            /*
             *  3.同时有左/右子树：将左子树的最右子节点或右子树的最左子节点的value赋给BST,并删除该子节点
             * 实质上是将原数组中最接近BST的左/右值替换BST的值
             */
            else
            {
                Node min = root.right;
                while(min.left!=null)
                    min=min.left;
                root.value=min.value;
                root.right=deleteBST(root.right,min.value);
            }
        }
    }

    
