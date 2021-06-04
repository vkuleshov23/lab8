package prog.lab8.doplab.mergesort;

import java.util.Comparator;

public class Merge<T> extends Thread {
	private int from, to;
	private T[] result, arr;
	private Comparator<T> comp;

	public int getLength(){
		return result.length;
	}
	//-----------------------------------//
	public T get(int i){
		return (T)result[i];
	}
	@SuppressWarnings("unchecked")
	public Merge(T[] arr, int from, int to, Comparator<T> comp){
		result = (T[])new Object[to - from + 1];
		this.arr = arr;
		this.from = from;
		this.to = to;
		this.comp = comp;
	}
	private void mergeSort(int from, int to){
	    if (from >= to) return;

    	int mid = (from+to)/2;
    	mergeSort(from, mid);
    	mergeSort(mid+1, to);
    	merge(from, mid, to);
	}
	@SuppressWarnings("unchecked")
	public void merge(int from, int mid, int to) {
	    T leftArray[] = (T[])new Object[mid - from + 1];
	    T rightArray[] = (T[])new Object[to - mid];

	    for (int i = 0; i < leftArray.length; i++)
	        leftArray[i] = arr[from + i];
	    for (int i = 0; i < rightArray.length; i++)
	        rightArray[i] = arr[mid + i + 1];

	    int leftIndex = 0;
	    int rightIndex = 0;

	    for (int i = from; i < to + 1; i++) {
	        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
	            if (comp.compare(leftArray[leftIndex], rightArray[rightIndex]) < 0) {
	               arr[i] = leftArray[leftIndex];
	               leftIndex++;
	            } else {
	                arr[i] = rightArray[rightIndex];
	                rightIndex++;
	            }
	        } else if (leftIndex < leftArray.length) {
	            arr[i] = leftArray[leftIndex];
	            leftIndex++;
	        } else if (rightIndex < rightArray.length) {
	            arr[i] = rightArray[rightIndex];
	            rightIndex++;
	        }
	    }
	}
	@Override
	public void run(){
		mergeSort(this.from, this.to);

		for(int i = from; i <= to; i++){
			result[i-from] = arr[i];
		}
	}
}