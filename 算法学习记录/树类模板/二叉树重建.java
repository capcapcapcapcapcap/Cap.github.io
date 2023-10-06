
//	中+后序重建
 	public static Node rebuild(int len)
    {
        if (midOrder == null || postOrder == null || midOrder.length() != postOrder.length())
            return null;
        return build(0, len - 1, 0, len - 1);
    }

    public static Node build(int mid_start, int mid_end, int post_start, int post_end)
    {
        if (mid_start > mid_end || post_start > post_end)
            return null;
        //根据后序遍历确定当前子树的根节点
        char val = postOrder.charAt(post_end);
        Node root = new Node(val);

        //找出根节点在中序遍历中的位置
        int root_index = midOrder.indexOf(val);

        //计算左子树的长度(右子树长度可 以其表示)
        int left_size = root_index - mid_start;

        //以递归重建当前根节点的左右子树(因为最初的遍历序列即通过递归得来)
        root.left = build(mid_start, root_index - 1, post_start, post_start + left_size - 1);
        root.right = build(root_index + 1, mid_end, post_start + left_size, post_end - 1);
        return root;
    }

//	中+前序重建
    public static Node rebuild(int len)
    {
        if (midOrder == null || postOrder == null || midOrder.length() != preOrder.length())
            return null;
        return build(0, len - 1, 0, len - 1);
    }

    public static Node build(int mid_start, int mid_end, int pre_start, int pre_end)
    {
        if (mid_start > mid_end || pre_start > pre_end)
            return null;
        //根据后序遍历确定当前子树的根节点
        char val = postOrder.charAt(pre_start);
        Node root = new Node(val);

        //找出根节点在中序遍历中的位置
        int root_index = midOrder.indexOf(val);

        //计算左子树的长度(右子树长度可 以其表示)
        int left_size = root_index - mid_start;

        //以递归重建当前根节点的左右子树(因为最初的遍历序列即通过递归得来)
        root.left = build(mid_start, root_index - 1, pre_start+1, pre_start + left_size );
        root.right = build(root_index + 1, mid_end, pre_start + left_size+1, pre_end);
        return root;
    }
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value)
        {
            this.value = value;
        }
    }