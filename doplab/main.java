package prog.lab8.doplab;
import prog.lab8.doplab.mergesort.*;
import java.util.Comparator;

public class main{
    public static void main(String[] args){
    	int size = 10;
    	Integer[] mass = new Integer[size];
    	for (int i = 0; i < size; i++) {
    		mass[i] = (int)(Math.random()*10 + 1);
    		// mass[i] = size-i;
    		System.out.print(mass[i] + " ");
    	} System.out.println();
    	System.out.println();


        long start = System.currentTimeMillis();

    	(new ParalleleMergeSort<Integer>()).mergeSort(mass, 1, new Comparator<Integer>() {
                                                                                            @Override
                                                                                            public int compare(Integer o1, Integer o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        });

        long end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

        for(int i = 0; i < size; i++){
            // System.out.print(mass[i] + " ");
        } System.out.println();
        // System.out.println();


        for (int i = 0; i < size; i++) {
    		mass[i] = (int)(Math.random()*10 + 1);
    		// mass[i] = size-i;
    		System.out.print(mass[i] + " ");
    	}  System.out.println();
        start = System.currentTimeMillis();
    	(new ParalleleMergeSort<Integer>()).mergeSort(mass, 2, new Comparator<Integer>() {
                                                                                            @Override
                                                                                            public int compare(Integer o1, Integer o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        });
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

		for(int i = 0; i < size; i++){
    		// System.out.print(mass[i] + " ");
    	} System.out.println();
    	System.out.println();


        Double[] mass1 = new Double[size];
        for (int i = 0; i < size; i++) {
            mass1[i] = (Math.random()*10 + 1);
            System.out.print(mass1[i] + " ");
        } System.out.println();
        System.out.println();
	   

       start = System.currentTimeMillis();
        (new ParalleleMergeSort<Double>()).mergeSort(mass1, 2, new Comparator<Double>() {
                                                                                            @Override
                                                                                            public int compare(Double o1, Double o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        });
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

        for(int i = 0; i < size; i++){
            System.out.print(mass1[i] + " ");
        } System.out.println();
        System.out.println();
    }  
}