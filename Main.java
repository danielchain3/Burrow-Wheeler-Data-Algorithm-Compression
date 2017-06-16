import java.util.*;

public class Main{

	public static void main(String[] args){
		String message = "AAABBA";
		
		Encoding encode = new Encoding(message);
		System.out.println(encode.getBWTE().getEncoded());
		System.out.println(encode.getEncoded());

		Decoding decode = new Decoding(encode);
		System.out.println(decode.getDecodedMessage());

	}
}

