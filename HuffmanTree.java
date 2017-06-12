import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree{

	private HuffmanTreeNode _root;
	private int _size;
	private PriorityQueue<HuffmanTreeNode> _queue;

	public HuffmanTree(MTFE input){
		
		_queue = createQueue(input.getFrequencyTable());
		createTree(_queue);

	}

	public PriorityQueue<HuffmanTreeNode> createQueue(HashMap<Character, Integer> table){
		//create the huffmanTreeNode and make a priority queue out of it.
		PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<HuffmanTreeNode>();
		
		for (Map.Entry<Character,Integer> entry : table.entrySet())
			queue.add(new HuffmanTreeNode(entry.getValue(), entry.getKey(), null, null));

		return queue;
	}

	public PriorityQueue<HuffmanTreeNode> getQueue(){
		return _queue;
	}

	public void createTree(PriorityQueue<HuffmanTreeNode> queue){
		HuffmanTreeNode left, right;

		while (queue.size() > 1){
			left = queue.remove();
			right = queue.remove();

			queue.add(new HuffmanTreeNode(left.getValue() + right.getValue(),(char) 0, left, right));
		}

		_root = queue.remove();
	}

	public HuffmanTreeNode getTree(){
		return _root;
	}

    public String toString(HuffmanTreeNode rt){
        String ans = "";
        if (rt != null){
            ans = toString(rt.getLeft()) + rt.getValue() + ":" + rt.getLetter() + ", " + toString(rt.getRight());
        }
        return ans;
    }
}


