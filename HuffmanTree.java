import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree{

	private HuffmanTreeNode _root;
	private int _size;
	private PriorityQueue<Map.Entry<Character,Integer>> _queue;

	public HuffmanTree(MTFE input){
		
		_queue = createQueue(input.getFrequencyTable());
		//createTree(_queue);

	}

	public HuffmanTreeNode createQueue(HashMap<Character, Integer> table){
		//create the huffmanTreeNode and make a priority queue out of it.
		PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<HuffmanTreeNode>() {
			
			//Overrides current comparator in priorityQueue;
			public int compare(HuffmanTreeNode entry1, HuffmanTreeNode entry2){
				 return entry2.getValue() - entry1.getValue();
			
			}
		};
		
		for ( : table.entrySet())
			queue.add(new HuffmanTreeNode(;

		return queue;
	}
}
