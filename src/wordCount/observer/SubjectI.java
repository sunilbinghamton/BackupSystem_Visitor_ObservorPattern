package wordCount.observer;

public interface SubjectI {

	/**
	 * @param o: ObserverI type reference to register observer 
	 */
	public void registerObserver(ObserverI o);
	
	/**
	 * @param o: ObserverI type reference to remove observer
	 */
	public void removeObserver(ObserverI o);
	
	/**
	 * @param c: Interger type to notify Observer with the new count value
	 */
	public void notifyObservers(int c); 
	
	
	
}
