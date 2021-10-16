/* Author: Jackson Howe */
/* Node class for the Huffman tree */

public class HuffmanNode implements Comparable<HuffmanNode> {

	// variable declarations
	int item;
	String name;
	HuffmanNode left;
	HuffmanNode right;
	
	// constructor
	public HuffmanNode(String name, int item)
	{
		this.item = item;
		this.name = name;
		left = null;
		right = null;
	}
	
	
	// sets left child
	public void setLeft(HuffmanNode left) 
	{
		this.left = left;
	}
	
	// sets right child
	public void setRight(HuffmanNode right)
	{
		this.right = right;
	}


	@Override
	public int compareTo(HuffmanNode o) {
		return this.item - o.item;
	}
	
}
