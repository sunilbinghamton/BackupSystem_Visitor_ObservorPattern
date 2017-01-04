package wordCount.dsForStrings;

import java.util.ArrayList;

import wordCount.observer.ObserverI;
import wordCount.observer.SubjectI;

/**
 * @author Sunil
 *
 */
public class Node implements Cloneable, ObserverI, SubjectI {
	// -- fields -- 
	private String word;
    private int count;
    private Node left, right;
    
    private ArrayList<ObserverI> observers;
 
    // -- constructor --
    public Node(String wordIn) 
    {
        word = wordIn;
        count = 1;
        left = right = null;
        observers = new ArrayList<ObserverI>();
        
    }
    
    public Object clone() {
    	try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    // -- getters --
    
    public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}


	public String getData(){
    	return word;
    }
	
	// -- setters --
	
	public void setRight(Node right) {
		this.right = right;
	}

	public void setData(String data) {
		this.word = data;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}

	// Subject function
	@Override
	public void registerObserver(ObserverI o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(ObserverI o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
		
	}
	

	@Override
	public void notifyObservers(int c) {
		for (int i = 0; i < observers.size(); i++) {
			ObserverI observer = (ObserverI)observers.get(i);
			observer.updateNode(c);
			}
		
	}

	// Observer function
	@Override
	public void updateNode(int updateValues) {
				this.setCount(this.getCount() + updateValues);
	}

	public ArrayList<ObserverI> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<ObserverI> observers) {
		this.observers = observers;
	}
    

}

