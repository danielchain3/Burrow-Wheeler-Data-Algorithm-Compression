import java.util.List;
import java.util.ArrayList;

public class HuffmanDecoding{

	private int _rowOfOriginal;
    private String _huffmanEncoded;
    private HuffmanTreeNode _rt;
	private ArrayList<Character> _huffmanDecoded;
	private ArrayList<Integer> _MTFEValues;

    public HuffmanDecoding(HuffmanEncoding input, HuffmanTree rt){
        _huffmanEncoded = input.getEncodedMessage();
        _rt = rt.getTree();
		_huffmanDecoded = decode();
		_rowOfOriginal = input.getRow();
		_MTFEValues = input.getDecodedMessage();
    }

    private ArrayList<Character> decode(){
        ArrayList<Character> recreatedList = new ArrayList<Character>();
        HuffmanTreeNode currNode = _rt;
        for(int i = 0; i < _huffmanEncoded.length(); i++){
            if(_huffmanEncoded.substring(i, i+1).equals("0")){
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
	
	public ArrayList<Integer> getMTFEValues(){
		return _MTFEValues;
	}

	public ArrayList<Character> getHuffmanDecoded(){
		return _huffmanDecoded;
	}

	public String getHuffmanEncoded(){
		return _huffmanEncoded;
	}

    public int getRow(){
        return _rowOfOriginal;
    }
}
