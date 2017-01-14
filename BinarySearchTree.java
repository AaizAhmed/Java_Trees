package trees;

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

	public boolean contains (T data)
	{
		return contains(data, root);
	}
	
	private boolean contains (T data, BinaryNode<T> node)
	{		
		if (node == null)
		{	return false;	}
		
		int compareResult = data.compareTo(node.data);
		
		if (compareResult < 0)
		{
			return contains(data, node.leftNode);
		}
		else if (compareResult > 0)
		{
			return contains(data, node.rightNode);
		}
		else     //Match			
			return true;
	}
	
	public void insert(T data) 
	{
		root = insert (data, root);
	}
	
	private BinaryNode<T> insert (T data, BinaryNode<T> node)
	{
		if (node == null)
		{
			return new BinaryNode<T> (data);
		}
		
		int compareResult = data.compareTo(node.data);
		
		if (compareResult < 0)
		{
			node.leftNode = insert (data, node.leftNode);
		}
		else if (compareResult > 0)
		{
			node.rightNode = insert (data, node.rightNode);
		}
		else    // Duplicate
		{    
			
		}
		
		return node;		
	}
	
	public T findMin() 
	{
		if ( isEmpty () )
		{
			throw new RuntimeException("Tree is empty.");
		}
		
		return findMin (root).data;
	}
	
	private BinaryNode<T> findMin (BinaryNode<T> node)
	{
		if (node == null)
		{
			return null;
		}
		
		if (node.leftNode == null)
		{
			return node;
		}
		
		return findMin (node.leftNode);
	}
	
	public T findMax()
	{
		if ( isEmpty () )
		{
			throw new RuntimeException("Tree is empty.");
		}
		
		return findMax(root).data;
	}
	
	private BinaryNode<T> findMax (BinaryNode<T> node)
	{
		if (node == null)
		{
			return null;
		}
		
		if (node.rightNode == null)
		{
			return node;
		}
		
		return node.rightNode;
	}
	
	public void remove (T data)
	{
		if ( isEmpty() )
		{
			throw new RuntimeException("Tree is empty.");
		}
		
		root = remove (data, root);
	}
	
	private BinaryNode<T> remove (T data, BinaryNode<T> node)
	{
		if (node == null)
		{
			return null;
		}
		
		int compareResult = data.compareTo(node.data);
		
		if (compareResult < 0)
		{
			node.leftNode = remove (data, node.leftNode);
		}
		else if (compareResult > 0)
		{
			node.rightNode = remove (data, node.rightNode);
		}
		else if (node.leftNode != null && node.rightNode != null) //Two children
		{
			node.data = findMin(node).data;  //removing the data and writing the new value
			node.rightNode = remove (node.data, node.rightNode);
		}
		
		node = (node.leftNode != null) ? node.leftNode : node.rightNode;
		
		return node;
	}
	
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
