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

	public PriorityQueue<Map.Entry<Character,Integer>> createQueue(HashMap<Character, Integer> table){
		PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<Map.Entry<Character,Integer>>();
		
		for (Map.Entry<Character, Integer> entry : table.entrySet())
			queue.add(entry);

		return queue;
	}
}
