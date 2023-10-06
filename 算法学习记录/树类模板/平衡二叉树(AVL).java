    static class AVL {
        int value;
        AVL left;
        AVL right;

        public AVL(int value)
        {
            this.value = value;
        }

        //节点的高度
        public int height()
        {
            int l = 0;
            int r = 0;
            if (left != null)
                l = left.height();
            if (right != null)
                r = right.height();
            return 1 + Math.max(l, r);
        }

        //节点的平衡因子-Balance Factor
        public int BF()
        {
            int l = 0;
            int r = 0;
            if (left != null)
                l = left.height();
            if (right != null)
                r = right.height();
            return l - r;
        }

    }

    //创建平衡二叉树AVL树
    static AVL buildAVL(int[] tree)
    {
        AVL root = null;
        for (int i = 0; i < tree.length; i++)
        {
            root = addAVL(root, tree[i]);
        }
        return root;
    }


    // 左旋转(BF<-1)
    static AVL leftRotate(AVL root)
    {
        AVL newroot = root.right;
        root.right = newroot.left;
        newroot.left = root;
        return newroot;
    }

    // 右旋转(BF>1)
    static AVL rightRotate(AVL root)
    {
        AVL newroot = root.left;
        root.left = newroot.right;
        newroot.right = root;
        return newroot;
    }

    /*
     * 双旋转-右+左
     * 当root.BF>1且root.left.BF<-1时
     * 先左旋转left,再右旋转root
     */
    static AVL rlRotate(AVL root)
    {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    /*
     * 双旋转-左+右
     * 当root.BF<-1且root.right.BF>1时
     * 先右旋转left,再左旋转root
     */
    static AVL lrRotate(AVL root)
    {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    //平衡节点
    static AVL balanceAVL(AVL root)
    {
        if(root==null)
            return null;
        int bf = root.BF();
        if (bf >= -1 && bf <= 1)
            return root;
        else if (bf >= -1)
        {
            //双旋转-右+左
            if (root.left.BF() < -1)
                return rlRotate(root);
                //右旋转
            else return rightRotate(root);
        } else
        {
            //双旋转-左+右
            if (root.right.BF() > 1)
                return lrRotate(root);
                //左旋转
            else return leftRotate(root);
        }
    }

    //搜索节点
    public static boolean searchAVL(AVL root, int key)
    {
        while (root != null)
        {
            int value = root.value;
            if (key == value)
                return true;
            else if (key < value)
                root = root.left;
            else root = root.right;
        }
        return false;
    }

    //添加节点
    static AVL addAVL(AVL root, int key)
    {
        if (root == null)
            return new AVL(key);
        if (key <= root.value)
            root.left = addAVL(root.left, key);
        else root.right = addAVL(root.right, key);

        return balanceAVL(root);
    }

    //删除节点
    static AVL deleteAVL(AVL root, int key)
    {
        if (root == null)
            return null;
        if (key < root.value)
            root.left = deleteAVL(root.left, key);
        else if (key > root.value)
            root.right = deleteAVL(root.right, key);
        else
        {
            //待删除节点有三种情况
            //1.无左右子树:直接将AVL的子树置空
            if (root.right == null && root.left == null)
                root = null;
                //2.仅有右/左子树：将待删除节点的右/左子树变作AVL的子树
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
                /*
                 *  3.同时有左/右子树：将左子树的最右子节点或右子树的最左子节点的value赋给AVL,并删除该子节点
                 * 实质上是将原数组中最接近AVL的左/右值替换BST的值
                 */
            else
            {
                AVL min = root.right;
                while (min.left != null)
                    min = min.left;
                root.value = min.value;
                root.right = deleteAVL(root.right, min.value);
            }
        }

        return balanceAVL(root);
    }