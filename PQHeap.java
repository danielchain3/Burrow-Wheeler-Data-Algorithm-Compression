import java.util.ArrayList;
import java.util.Comparator;

public class PQHeap<K, V> implements PriorityQueue<K,V>{

    private ArrayList<Entry<K,V>> _heap;    
    private Comparator<K> _c;



    // private inner class
   
    private static class MyEntry<K, V> implements Entry<K,V>{
		private K _key;
		private V _value;


		public MyEntry(K key, V value){
			_key = key;
			_value = value;
		}
		
		public K getKey() { 
			return _key;
		}
		
		public V getValue() { 
			return _value;
		}


		public String toString(){
			return "{" + _key + " : " + _value + "}" ;
		}
	}



    public PQHeap(){
		_heap = new ArrayList<Entry<K,V>>();
		_c = new DefaultComparator<K>();
    }

    public PQHeap(Comparator<K> c){
		this();
		_c = c;
    }

    public boolean isEmpty(){
		return _heap.isEmpty();
    }
   
    // adds in order : O(logN)
    public void add(K key, V value){
		_heap.add(new MyEntry(key,value));
       	int pos = _heap.size() - 1;
		
		while (pos > 0){
	    	int parentPos = (pos - 1) / 2;
	    
			if( _c.compare(_heap.get(pos).getKey(), _heap.get((pos - 1)/ 2).getKey()) >= 0)
				break; 
	    	
			_heap.set(pos, _heap.set(parentPos,_heap.get(pos)));
			pos = parentPos;
		}
    }
    
    // O(logN)
    public Entry<K,V> removeMin() throws IllegalStateException{
		if (isEmpty())
		    throw new IllegalStateException();
		
		Entry<K,V> ans = _heap.get(0);
		Entry<K,V> temp = _heap.remove(_heap.size() - 1);
		
		if (_heap.size() > 0){
		    _heap.set(0, temp);
		    int pos = 0;
	    	int mcPos = minChildPos(pos);
	    
			while (mcPos > -1){
				if (_c.compare(_heap.get(pos).getKey(),_heap.get(mcPos).getKey()) > 0){
		   			_heap.set(pos,_heap.set(mcPos, _heap.get(pos)));
		   			pos = mcPos;
		    		mcPos = minChildPos(pos);
				}
				else 
					break;
	    	}
		}
        return ans;
    }

    // return -1 if  pos has no children
    // otherwise returns the minmum child
    private int minChildPos(int pos){
	    int left = 2 * pos + 1;
	    int right = left + 1;
	    // a leaf
	    if (left >= _heap.size()) 
            return -1;
	    
        // no right child
	    if (right >= _heap.size()) return left;
	    // two children
	    if (_c.compare(_heap.get(left).getKey(), _heap.get(right).getKey()) < 0)
	        return left;
	    return right;
    }



    // O(1)
    public Entry<K,V> peekMin(){
	    return _heap.get(0);
    }


    public String toString(){
	    return _heap.toString();
    }


}
