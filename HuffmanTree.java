import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree{

	private HuffmanTreeNode _root;
	private PQHeap<Integer,Character> _queue;

	public HuffmanTree(MTFE input){
		
		_queue = createQueue(input.getFrequencyTable());
		//createTree(_queue);

	}

	public PQHeap<Integer,Character> createQueue(HashMap<Character, Integer> table){
		PQHeap<Integer,Character> queue = new PQHeap<Integer,Character>();
		Character[] keys = table.keySet().toArray(new Character[table.size()]);
		for (Character value : keys)
			queue.add(table.get(value),value);

		return queue;
	}
	
	public void createTree(PQHeap<Integer,Character> queue){
		int size = _queue.size();
		PQHeap<Integer, Character> left, right, parent;

		while (_queue.size() > 1) {
			left = _queue.removeMin();
			right = _queue.removeMin();

			queue.add(left.getKey() + right.getKey(), null);

	}

	public PQHeap<Integer, Character> getQueue(){
		return _queue;
	}
}
