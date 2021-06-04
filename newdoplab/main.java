package prog.lab8.newdoplab;
import prog.lab8.newdoplab.maxfind.*;
import java.util.ArrayList;
import java.util.Comparator;

public class main{
    public static void main(String[] args){
        int size = 1000;
        ArrayList<Integer> mass = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            mass.add((int)(Math.random()*5000 + 1));
            // System.out.print(mass.get(i) + " ");
        } System.out.println();
        System.out.println();


        long start = System.currentTimeMillis();

        System.out.println((new MaxFind<Integer>()).findmax(mass, 1, new Comparator<Integer>() {
                                                                                            @Override
                                                                                            public int compare(Integer o1, Integer o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        }));
        long end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

        start = System.currentTimeMillis();
        System.out.println((new MaxFind<Integer>()).findmax(mass, 3, new Comparator<Integer>() {
                                                                                            @Override
                                                                                            public int compare(Integer o1, Integer o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        }));
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");
        
        ArrayList<Double> mass1 = new ArrayList<Double>(size);
        for (int i = 0; i < size; i++) {
            mass1.add((Math.random()*2));
            // System.out.print(mass1.get(i) + " ");
        } System.out.println();
        System.out.println();

        start = System.currentTimeMillis();
        System.out.println((new MaxFind<Double>()).findmax(mass1, 1, new Comparator<Double>() {
                                                                                            @Override
                                                                                            public int compare(Double o1, Double o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        }));
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");
    
        start = System.currentTimeMillis();
        System.out.println((new MaxFind<Double>()).findmax(mass1, 3, new Comparator<Double>() {
                                                                                            @Override
                                                                                            public int compare(Double o1, Double o2){
                                                                                                if(o1 > o2) return 1;
                                                                                                if(o2 > o1) return -1;
                                                                                                return 0;
                                                                                            }
                                                                                        }));
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");



    }
}