public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
	
	private Integer _frequency;
	private char _letter;
	private HuffmanTreeNode _left, _right;

	public HuffmanTreeNode(Integer frequency, char letter){
		this(frequency, letter, null, null);
	}

	public HuffmanTreeNode(Integer frequency, char letter, HuffmanTreeNode left, HuffmanTreeNode right){
		_frequency = frequency;
		_letter = letter;
		_left = left;
		_right = right;
	}

	public Integer getValue(){
		return _frequency;
	}

	public char getLetter(){
		return _letter;
	}

	public HuffmanTreeNode getLeft(){
		return _left;
	}

	public HuffmanTreeNode getRight(){
		return _right;
	}

	public Integer setValue(Integer newValue){
		Integer ans = getValue();
		_frequency = newValue;
		return ans;
	}

	public HuffmanTreeNode setRight(HuffmanTreeNode newRight){
		HuffmanTreeNode ans = getRight();
		_right = newRight;
		return ans; }

	public HuffmanTreeNode setLeft(HuffmanTreeNode newLeft){
		HuffmanTreeNode ans = getLeft();
		_left = newLeft;
		return ans;
	}

	public boolean isLeaf(){
		return getRight() == null && getLeft() == null;
	}

	public String toString(){
		return getValue() + "";
	}

	public int compareTo(HuffmanTreeNode right){
		if (this.getValue() < right.getValue())
			return -1;
		
		else if(this.getValue() > right.getValue())
			return 1;

		else
			return 0;
	}

}
