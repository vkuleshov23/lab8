package prog.lab8.doplab.mergesort;

import java.util.LinkedList;
// import java.util.Iterator;
// import java.util.ListIterator;

public class Merge extends Thread {
	private int from, to;
	private int[] result, arr;

	public int getLength(){
		return result.length;
	}
	//-----------------------------------//
	public int get(int i){
		return result[i];
	}

	public Merge(int[] arr, int from, int to){
		result = new int[to - from + 1];
		this.arr = arr;
		this.from = from;
		this.to = to;
	}
	private void mergeSort(int from, int to){
	    if (from >= to) return;

    	int mid = (from+to)/2;
    	mergeSort(from, mid);
    	mergeSort(mid+1, to);
    	merge(from, mid, to);
	}
	public void merge(int from, int mid, int to) {
	    int leftArray[] = new int[mid - from + 1];
	    int rightArray[] = new int[to - mid];

	    for (int i = 0; i < leftArray.length; i++)
	        leftArray[i] = arr[from + i];
	    for (int i = 0; i < rightArray.length; i++)
	        rightArray[i] = arr[mid + i + 1];

	    int leftIndex = 0;
	    int rightIndex = 0;

	    for (int i = from; i < to + 1; i++) {
	        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
	            if (leftArray[leftIndex] < rightArray[rightIndex]) {
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