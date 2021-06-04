package prog.lab8.newdoplab.maxfind;

import java.util.Comparator;
import java.util.ArrayList;

public class ThreadFindMax<T> extends Thread {
	private int from, to;
	private ArrayList<T> arr;
	private T result = null;
	private Comparator<T> comp;

	public T get(){
		return (T)result;
	}
	public ThreadFindMax(ArrayList<T> arr, int from, int to, Comparator<T> comp){
		this.arr = arr;
		this.from = from;
		this.to = to;
		this.comp = comp;
	}
	@SuppressWarnings("unchecked")
	public void maxfind(){
		result = arr.get(from);
		for(int i = from+1; i <= to; i++){
			if(comp.compare(result, (T)arr.get(i)) < 0){
				result = arr.get(i);
			}
		}		
	}
	@Override
	public void run(){
		maxfind();
	}
}