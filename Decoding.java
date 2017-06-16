import java.util.*;

public class Decoding{

	private String _message;
	private BWTD _BWTDecoded;
	private MTFD _MTFDecoded;
	private HuffmanTree _tree;
	private HuffmanDecoding _huffmanDecoded;

	public Decoding(Encoding input){
		_message = input.getEncoded();
		_tree = input.getTree();
		_huffmanDecoded = new HuffmanDecoding(input.getHuffmanEncoding(), _tree);
		_MTFDecoded = new MTFD(_huffmanDecoded);
		_BWTDecoded = new BWTD(_MTFDecoded);

	}
	
	public String getEncodedMessage(){
		return _message;
	}

	public BWTD getBWTD(){
		return _BWTDecoded;
	}

	public MTFD getMTFD(){
		return _MTFDecoded;
	}

	public HuffmanTree getTree(){
		return _tree;
	}

	public String getDecodedMessage(){
		return _BWTDecoded.getDecoded();
	}
	
}
