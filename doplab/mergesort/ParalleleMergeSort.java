package prog.lab8.doplab.mergesort;
import java.util.Comparator;


public class ParalleleMergeSort<T>{

	public ParalleleMergeSort(){}

	@SuppressWarnings("unchecked")
	public void mergeSort(T[] arr, int threadNum, Comparator<T> comp) throws RuntimeException{
		if(threadNum < 0 && threadNum > arr.length){
			
			throw new RuntimeException("ivalid thread number");
		}

		int curThreadsNum = threadNum;
		if(curThreadsNum > arr.length) {
			curThreadsNum = arr.length;
		}

		int sizePerThread = arr.length / curThreadsNum;
		int remainder = arr.length % curThreadsNum;

		Merge[] threads = new Merge[curThreadsNum];
		int pointer = 0;

		for(int i = 0; i < curThreadsNum; i++){
			int calcQuant = ((remainder > 0) ? sizePerThread + 1 : sizePerThread);
			remainder--;
			threads[i] = new Merge(arr, pointer, pointer + calcQuant - 1, comp);
			pointer += calcQuant;
			threads[i].start();
		}

		try {
			for(Thread thread : threads){
				thread.join();
			}
			int[] threadIndex = new int[curThreadsNum];
			for(int i = 0; i < curThreadsNum; i++){
				threadIndex[i] = 0;
			}

			T item = null;
			int indexOfThreadElement = 0;

			for(int i = 0; i < arr.length; i++){
				item = null;
				indexOfThreadElement = 0;
				for(int j = 0; j < curThreadsNum; j++){
					if(threadIndex[j] < threads[j].getLength()){
						if(item == null){
							item = (T)threads[j].get(threadIndex[j]);
							indexOfThreadElement = j;
						}
						else if(comp.compare((T)(threads[j].get(threadIndex[j])), item) < 0){
							item = (T)threads[j].get(threadIndex[j]);
							indexOfThreadElement = j;
						}
					}
				}
				threadIndex[indexOfThreadElement]++;
				arr[i] = item;
			}
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

//перенести, сделавдочерним классом - MergeThread
//comparable