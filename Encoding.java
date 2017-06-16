import java.util.*;

public class Encoding{

	private String _message;
	private BWTE _BWTEncoded;
	private MTFE _MTFEncoded;
	private HuffmanTree _tree;
	private HuffmanEncoding _HuffmanEncoded;

	public Encoding(String given){
		_message = given;
		_BWTEncoded = new BWTE(_message);
		_MTFEncoded = new MTFE(_BWTEncoded);
		_tree = new HuffmanTree(_MTFEncoded);
		_HuffmanEncoded = new HuffmanEncoding(_tree, _MTFEncoded);
	}
	
	public String originalMessage(){
		return _message;
	}

	public BWTE getBWTE(){
		return _BWTEncoded;
	}

	public MTFE getMTFE(){
		return _MTFEncoded;
	}

	public HuffmanTree getTree(){
		return _tree;
	}

	public HuffmanEncoding getHuffmanEncoding(){
		return _HuffmanEncoded;
	}

	public String getEncoded(){
		return _HuffmanEncoded.getEncodedMessage();
	}
	
}
