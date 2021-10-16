import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Huffman {
	
	/*
	 * A class that encodes the huffman tree and prints the output to the screen
	 * @param root
	 * @param code
	 */
	public static void encode (HuffmanNode root, String code)
	{
		if (root.left == null && root.right == null)  // Base case; the node is a leaf
		{
			System.out.println(root.name + ": " + code); 
			
			return;
		}
		
		// Recursive calls
		encode (root.left, code + "0");  // Leftwards down the tree
		encode (root.right, code + "1");  // rightwards down the tree
	}
	
	
	public static HashMap<String, Integer> findFrequency (String s)
	{
		// Create a HashMap that will store the letter as the key and
		// the frequency as the data
		HashMap<String, Integer> freq = new HashMap<String, Integer>();
		// Split the string
		String[] input = s.split("");
		// for every item in the array, add the proper frequencies to the HashMap
		for (int i = 0; i < input.length; i++)
		{
			if (freq.containsKey(input[i]))
			{
				freq.replace(input[i], freq.get(input[i]) + 1);  // Increment the frequency
			}
			else
			{
				freq.put(input[i], 1);  // Create new pair
			}
		}
		
		return freq;
	}
	
	public static void main (String[] args)
	{
		// User input
		System.out.println("Enter your string: ");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		scan.close();
		
		HashMap<String, Integer> dict = findFrequency (line);  // Stores the results in a dictionary
		
		PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();  // Create new priority queue
		
		for (String key : dict.keySet())
		{
			HuffmanNode huff = new HuffmanNode(key, dict.get(key));  // Create new HuffmanNode object
			queue.add(huff);  // Add the new node to the queue
		}
		
		// Create the root node
		HuffmanNode root = null;
		
		// The Huffman algorithm essentially takes the two values with the least character
		// frequency and creates a parent node with the sum of their frequency.
		// The min heap sort will allow us to build a Huffman tree with optimal lossless encoding.
		while (queue.size() > 1)
		{
			HuffmanNode a = queue.poll();  // Remove the smallest frequency
			HuffmanNode b = queue.poll();  // Remove the second smallest frequency
			
			HuffmanNode parent = new HuffmanNode ("intermediate", a.item + b.item);  // Create parent
			
			parent.setLeft(a);  // Create the subtree
			parent.setRight(b);
			
			root = parent;  // Mark the parent as the root
			
			queue.add(parent);  // Add the parent back into the queue
		}
		
		encode (root, "");
		
		
	}
	
}
