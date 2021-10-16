/*
 * A class that builds a Binary Tree of Huffman Nodes.
 * Author: Jackson Howe (I just changed stock Binary Tree code to fit my specifications).
 */
public class BinaryTree {

	// Variable intializations
	private HuffmanNode root;
	
	// Constructor
	public BinaryTree (String name, int item)
	{
		root = new HuffmanNode(name, item);
	}
	
	/*
	 * A method that returns the root of the tree
	 * @return root
	 */
	public HuffmanNode getRoot()
	{
		return root;
	}
	
	/*
	 * A method that calls addRecursive to add a node to the binary tree
	 * @param value
	 */
	public void add (String name, int value)
	{
		root = addRecursive (root, name, value);
	}
	/*
	 * A method that adds nodes to a binary tree recursively
	 * @param current
	 * @param value
	 * @return HuffmanNode
	 */
	public HuffmanNode addRecursive (HuffmanNode current, String name, int value)
	{
		// The case in which we are adding the root node
		if (current == null)
		{
			return new HuffmanNode (name, value);
		}
		
		// The case in which the value is less than the current node
		else if (value < current.item)
		{
			current.left = addRecursive (current.left, name, value);
		}
		
		// The case in which the value is less than the current node
		else if (value > current.item)
		{
			current.right = addRecursive (current.right, name, value);
		}
		
		// The last case, in which the value already exists
		else 
		{
			return current;
		}
		
		return current;
	}
	
}
