package Java_Trees;

@SuppressWarnings("unchecked")

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
			this.data = data;
			leftNode = null;
			rightNode = null;
		}

		public BinaryNode(T data, BinaryNode left, BinaryNode right)
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
	{	return findMin(find, root).data;	} 

	public T findMax(T find)
	{	return findMax(find, root).data;	} 

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
	
	private BinaryNode<T> findMin (T data, BinaryNode<T> node)
	{
		if (node == null)
		{	return null;	}
		else if (node.leftNode == null)
		{	return node;	}
		
		return findMin(data, node.leftNode);
	}
	
	private BinaryNode<T> findMax (T data, BinaryNode<T> node)
	{
		if (node == null)
		{	return null;	}
		else if (node.rightNode == null)
		{	return node;	}
		
		return findMax(data, node.rightNode);		
	}
	
	private BinaryNode<T> insert (T data, BinaryNode<T> node)
	{
		if ( node == null )
		{	return new BinaryNode<T> (data, null, null);	}
		
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
		return null;
		
	}
	
}