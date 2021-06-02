package prog.lab8.doplab;
import prog.lab8.doplab.mergesort.*;

public class main{
    public static void main(String[] args){
    	int size = 50000000;
    	int[] mass = new int[size];
    	for (int i = 0; i < size; i++) {
    		mass[i] = (int)(Math.random()*100 + 1);
    		// mass[i] = size-i;
    		// System.out.print(mass[i] + " ");
    	} System.out.println();
    	System.out.println();


        long start = System.currentTimeMillis();

    	ParalleleMergeSort.mergeSort(mass, 1);

        long end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");


        for (int i = 0; i < size; i++) {
    		mass[i] = (int)(Math.random()*100 + 1);
    		// mass[i] = size-i;
    		// System.out.print(mass[i] + " ");
    	}
        start = System.currentTimeMillis();
    	ParalleleMergeSort.mergeSort(mass, 6);
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

		for(int i = 0; i < size; i++){
    		// System.out.print(mass[i] + " ");
    	} System.out.println();
    	System.out.println();
	}
}