import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main{

	public static void main(String[] args){
		MTFE test = new MTFE("aadasfbc");
		
		System.out.println(test.getEncodedMessage().toString());
		System.out.println(test.getFrequencyTable().toString());
		
		for (Map.Entry<Character, Integer> entry : test.getFrequencyTable().entrySet())
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());

		HuffmanTree tree = new HuffmanTree(test);
		System.out.println(tree.getQueue().toString());
	}
}

