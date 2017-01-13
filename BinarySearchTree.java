package Java_Trees;

@SuppressWarnings("hiding")

public class BinarySearchTree<T extends Comparable<? super T> > 
{

	BinaryNode<T> root;

	public BinarySearchTree(T data)
	{	root = null;	}
	
	//--------------------------INTERNAL CLASS---------------------------------

	private class BinaryNode<T> 
	{
		T data;
		BinaryNode<T> leftNode;
		BinaryNode<T> rightNode;
		
		public BinaryNode(T data)
		{
			this (data, null, null);
		}

		public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right)
		{
			this.data = data;
			leftNode = left;
			rightNode = right;
		}
		
	}
	//--------------------------END OF CLASS-----------------------------------

	public void makeEmpty()
	{	root = null;	}

	public boolean isEmpty()
	{	return root == null;	}

	/*
		contains()
		min()
		max()
		insert()
		remove()
		print()
	*/
	public boolean contains (T find)
	{	return contains(find, root);	}

	public T findMin(T find)
	{	return findMin(root).data;	} 

	public T findMax(T find)
	{	return findMax(root).data;	} 

	public void insert(T data)
	{	root = insert(data, root);	} 

	public void remove(T data)
	{	root = remove(data, root);	} 

	private boolean contains (T find, BinaryNode<T> node)
	{
		if (node == null)
		{	return false;	}
		
		int compareResult = find.compareTo(node.data);
		
		if (compareResult < 0)
		{	return contains(find, node.leftNode);	}
		else if (compareResult > 0) 
		{	return contains(find, node.rightNode);		}
		else
			return true;	//Match
	}
	
	private BinaryNode<T> findMin (BinaryNode<T> node)
	{
		if (node == null)
		{	return null;	}
		else if (node.leftNode == null)
		{	return node;	}
		
		return findMin(node.leftNode);
	}
	
	private BinaryNode<T> findMax (BinaryNode<T> node)
	{
		if (node == null)
		{	return null;	}
		else if (node.rightNode == null)
		{	return node;	}
		
		return findMax(node.rightNode);		
	}
	
	private BinaryNode<T> insert (T data, BinaryNode<T> node)
	{
		if ( node == null )
		{	return new BinaryNode<T> (data);	}
		
		int compareResult = data.compareTo(node.data);
		
		if (compareResult < 0) 
		{
			node.leftNode = insert (data, node.leftNode);
		}
		else if (compareResult > 0)
		{
			node.rightNode = insert (data, node.rightNode);
		}	
		else
		{   
			// Duplicate, do nothing
		}	
		
		return node;				
	}
	
	private BinaryNode<T> remove (T data, BinaryNode<T> node)
	{
		if (node == null)
		{	return node;	}
		
		int compareResult = data.compareTo(node.data);
		
		if (compareResult < 0 )
		{
			node.leftNode = remove(data, node.leftNode);
		}
		else if (compareResult > 0)
		{
			node.rightNode = remove(data, node.rightNode);
		}
		else if (node.leftNode != null && node.rightNode != null)
		{
			node.data = findMin(node.rightNode).data;
			node.rightNode = remove(node.data, node.rightNode);
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
			System.out.println("Empty Tree");
		}
		else printTree (root);
	}

	private void printTree(BinaryNode<T> root) {
		
		if (root != null)	//In-order traversal.
		{
			printTree (root.leftNode);
			System.out.println(root.data);
			printTree (root.rightNode);
		}		
	}
	
}