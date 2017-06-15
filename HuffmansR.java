import java.util.List;
import java.util.ArrayList;

public class HuffmansR{

    private String _huffmansEncoded;
    private HuffmanTreeNode _rt;

    public HuffmansR(String huffmanEncoded, HuffmanTree rt){
        _huffmansEncoded = huffmanEncoded;
        _rt = rt.getTree();
    }

    public ArrayList<Character> decode(){
        ArrayList<Character> recreatedList = new ArrayList<Character>();
        HuffmanTreeNode currNode = _rt;
        for(int i = 0; i < _huffmansEncoded.length(); i++){
            if(_huffmansEncoded.substring(i, i+1).equals("0")){
                currNode = currNode.getLeft();
				if (currNode.isLeaf()){
					recreatedList.add(currNode.getLetter());
					currNode = _rt;
				}
			}

			else { 
                currNode = currNode.getRight();
				if (currNode.isLeaf()){
					recreatedList.add(currNode.getLetter());
					currNode = _rt;
				}
			}

		}
        return recreatedList;
	}

}
