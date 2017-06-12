import java.util.Map;
import java.util.HashMap;

public class MTFETest{

	public static void main(String[] args){
		MTFE test = new MTFE("aadasfbc");
		System.out.println(test.getEncodedMessage().toString());
		System.out.println(test.getFrequencyTable().toString());
		for (Map.Entry<Character, Integer> entry : test.getFrequencyTable().entrySet())
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
	}
}

