package Java_Trees;

/**
 * A Generic Binary Search Tree class.
 * @author Aaiz N Ahmed
 * @param <T> Any type of data.
 */
public class BinarySearchTree < T extends Comparable<? super T> > 
{
	/**---------------------------------------------------------------------------------------
	 * Internal binary node class.
	 * @author Aaiz N Ahmed	 
	 * @param <T> Any type of data.
	 */
	private class BinaryNode<T> 
	{
		private T data;
		private BinaryNode<T> leftNode;
		private BinaryNode<T> rightNode;
		
		public BinaryNode (T data)
		{
			this (data, null, null); 
		}
		
		public BinaryNode (T data, BinaryNode<T> left, BinaryNode<T> right)
		{
			this.data = data;
			leftNode = left;
			rightNode = right;
		}		
	}
	//----------------------------------------END OF CLASS-----------------------------------

	private BinaryNode<T> root;
	
	public BinarySearchTree ()
	{	root = null;	}

	public boolean isEmpty()
	{	return root == null;	}

	public void makeEmpty()
	{	root = null;	}

	//Add here
	
	public void printTree () 
	{
		if (root == null) 
		{
			System.out.println("Tree is empty.");
		}
		else printTree (root);
	}

	private void printTree(BinaryNode<T> node) 
	{		
		if (node != null)	//In-order traversal.
		{
			printTree (node.leftNode);
			System.out.println(node.data);
			printTree (node.rightNode);
		}		
	}
	
	/** 
	 * This method returns how many nodes/values are in this tree
	 * @return the number of nodes in this tree
	 */
	public int size() 
	{	return size(root);	}
	
	/**
	 * Calculates the size of the tree.
	 * @param x
	 * @return size
	 */
	private int size(BinaryNode<T> node) 
	{
		if (node == null) 
		{
			return 0;             
		} 
		return size(node.leftNode) + 1 + size(node.rightNode);
	}	

}
