
class Node
{
	int value;
	Node left;
	Node right;
	public Node(int value)
	{
		this.value=value;
	}
}

//前序遍历
public static void preOrder(Node root)
{ 
	if(root==null)
            return;
	out.println(root.value);
	if(root.left!=null)
		preOrder(root.left);
	if(root.right!=null)
		preOrder(root.right);
}
//中序遍历
public static void midOrder(Node root)
{
	if(root==null)
            return;
	if(root.left!=null)
		midOrder(root.left);
	out.println(root.value);

	if(root.right!=null)
		midOrder(root.right);
}
//后序遍历
public static void postOrder(Node root)
{
	if(root==null)
            return;
	if(root.left!=null)
		postOrder(root.left);
	if(root.right!=null)
		postOrder(root.right);
	
	out.println(root.value);

}
//层序遍历
public static void layerOrder(Node root)
{
	Queue tree =new LinkedList<Node>();
	if(root!=null)
		tree.offer(root);
	while(!tree.isEmpty())
	{
		Node now=tree.poll();
		
		if(now.left!=null)
			tree.offer(now.left);
		if(now.right!=null)
			tree.offer(now.right);
		
	}
}