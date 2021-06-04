package prog.lab8;
import prog.lab8.thread_matrix.*;
import prog.lab5.matrixes.Matrix;
public class main{
    public static void main(String[] args){
        int size = 1200;
        Matrix a = new Matrix(size, size);
        Matrix b = new Matrix(size, size);
        a.fill(size-1);
        b.fill(size-1);
        // System.out.println("a:\n" + a);
        // System.out.println("b:\n" + b);
            
        long start = System.currentTimeMillis();
        // System.out.println("a1*b:\n" + a.product(b));
        a.product(b);
        long end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

        ParallelMatrixProduct check = new ParallelMatrixProduct(2);
        System.out.println("threats2:\n");
        start = System.currentTimeMillis();
        // System.out.println("threats\na*b:\n" + check.product(a, b));
        check.product(a, b);
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

        ParallelMatrixProduct check1 = new ParallelMatrixProduct(3);
        System.out.println("threats3:\n");
        start = System.currentTimeMillis();
        // System.out.println("threats\na*b:\n" + check.product(a, b));
        check1.product(a, b);
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");

        ParallelMatrixProduct check2 = new ParallelMatrixProduct(4);
        System.out.println("threats4:\n");
        start = System.currentTimeMillis();
        // System.out.println("threats\na*b:\n" + check.product(a, b));
        check2.product(a, b);
        end = System.currentTimeMillis();
        System.out.println("Passed " + (end - start) + " millis\n");
    }
}
