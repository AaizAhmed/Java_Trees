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
	
	public BinarySearchTree(T data)
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
		else return true;	//Match
	}

	public void insert (T data)
	{	root = insert(data, root);	}

	private BinaryNode<T> insert(T data, BinaryNode<T> root)
	{
		if (root == null)
		{
			root = new BinaryNode<T> (data);
		}

		int compareResult = data.compareTo(root.data);

		if (compareResult < 0)
		{
			return insert(data, root.leftNode);
		}
		else if (compareResult > 0)
		{
			return insert(data, root.rightNode);
		}
		else // Duplicate, do nothing
		{			}

		return root;
	}

	public T findMin ()
	{
		if( isEmpty() ) 
		{
			throw new RuntimeException( "Tree is empty." );
		}
		return findMin(root).data;
	}

	private BinaryNode<T> findMin (BinaryNode<T> node)
	{
		if (node == null) 
		{
			return null;	
		}
		else if (node.leftNode == null) 
		{
			return node;	
		}

		return findMin (node.leftNode);
	}

	public T findMax ()
	{
		if( isEmpty() ) 
		{
			throw new RuntimeException( "Tree is empty." );
		}
		return findMax(root).data;
	}

	private BinaryNode<T> findMax (BinaryNode<T> node)
	{
		if (node == null) 
		{
			return null;	
		}
		else if (node.rightNode == null) 
		{
			return node;	
		}
		
		return findMax (node.rightNode);
	}

	public void remove(T data)
	{
		root = remove (data, root);
	}

	private BinaryNode<T> remove (T data, BinaryNode<T> node)
	{
		if (root == null)
		{
			return null;
		}

		int compareResult = data.compareTo(root.data);

		if (compareResult < 0)
		{
			return remove(data, root.leftNode);
		}
		else if (compareResult > 0)
		{
			return remove(data, root.rightNode);
		}
		else if (node.leftNode != null && node.rightNode != null) 
		{
			node.data = findMin(node).data;
			node.rightNode = remove (node.data, node.rightNode);
		}
		else
		{	//Using using ternary operator, syntax==> X = (condition) ? if true do this : else do this;
			node = (node.leftNode != null) ? node.leftNode : node.rightNode;
		}

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

	private void printTree(BinaryNode<T> root) 
	{
		
		if (root != null)	//In-order traversal.
		{
			printTree (root.leftNode);
			System.out.println(root.data);
			printTree (root.rightNode);
		}		
	}

}
