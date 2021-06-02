package prog.lab8.doplab.mergesort;

public class ParalleleMergeSort{

	public static void mergeSort(int[] arr, int threadNum) throws RuntimeException{
		if(threadNum < 0 && threadNum > arr.length){
			
			throw new RuntimeException("ivalid thread number");
		}
		//-------- int[] res = new int[arr.length];


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
			threads[i] = new Merge(arr, pointer, pointer + calcQuant - 1);
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

			int item = -1;
			int indexOfThreadElement = 0;

			for(int i = 0; i < arr.length; i++){
				item = -1;
				indexOfThreadElement = 0;
				for(int j = 0; j < curThreadsNum; j++){
					if(threadIndex[j] < threads[j].getLength()){
						if(item < 0){
							item = threads[j].get(threadIndex[j]);
							indexOfThreadElement = j;
						}
						else if(threads[j].get(threadIndex[j]) < item){
							item = threads[j].get(threadIndex[j]);
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