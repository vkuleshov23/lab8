package prog.lab8.newdoplab.maxfind;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxFind<T>{
    public MaxFind(){}
    
    @SuppressWarnings("unchecked")
    public T findmax(ArrayList<T> arr, int threadNum, Comparator<T> comp){
        if(threadNum < 0 && threadNum > arr.size()){
            
            throw new RuntimeException("ivalid thread number");
        }


        int curThreadsNum = threadNum;
        if(curThreadsNum > arr.size()) {
            curThreadsNum = arr.size();
        }

        int sizePerThread = arr.size() / curThreadsNum;
        int remainder = arr.size() % curThreadsNum;

        ThreadFindMax[] threads = new ThreadFindMax[curThreadsNum];
        int pointer = 0;

        for(int i = 0; i < curThreadsNum; i++){
            int calcQuant = ((remainder > 0) ? sizePerThread + 1 : sizePerThread);
            remainder--;
            threads[i] = new ThreadFindMax(arr, pointer, pointer + calcQuant - 1, comp);
            pointer += calcQuant;
            threads[i].start();
        }

        try {
            for(Thread thread : threads){
                thread.join();
            }
            T maxItem = (T)threads[0].get();

            for(int i = 1; i < curThreadsNum; i++){
                if(comp.compare(maxItem, (T)threads[i].get()) < 0){
                    maxItem = (T)threads[i].get();
                }
            }
            return maxItem;

        } catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
}