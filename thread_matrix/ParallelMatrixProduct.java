package prog.lab8.thread_matrix;

import prog.lab5.matrixes.Matrix;
import prog.lab5.excpt.*;
/*
import prog.lab5.interfaces.*;        */

public class ParallelMatrixProduct{
	protected int threadNum;

	public ParallelMatrixProduct(int threadNum){
		if(threadNum > 0){
			this.threadNum = threadNum;
		} else {
			MatrixException e = new MatrixException("Bad num of threads"); throw e;
		}
	}

	public Matrix product(Matrix a, Matrix b){
		if(a.getRowSize() != b.getColumnSize() || a.getRowSize() == 0 || b.getColumnSize() == 0){
			MatrixException e = new MatrixException("Matrix sizes are different"); throw e;
		} else {
			Matrix cur = new Matrix(a.getColumnSize(), b.getRowSize());
			
			int curThreadsNum = this.threadNum;
			if(this.threadNum > a.getColumnSize()) {
				curThreadsNum = a.getColumnSize();
			}

			int rowPerThread = a.getColumnSize() / curThreadsNum;
			int remainder = a.getColumnSize() % curThreadsNum;

			Thread[] threads = new Thread[curThreadsNum];
			int pointer = 0;

			for(int i = 0; i < curThreadsNum; i++){
				int calcQuant = ((remainder > 0) ? rowPerThread + 1 : rowPerThread );
				remainder--;
				threads[i] = new MatrixThread(a, b, cur, pointer, pointer + calcQuant - 1);
				pointer += calcQuant;
				threads[i].start();
			}

			try {
				for(Thread thread : threads){
					thread.join();
				}
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			return cur;
		}		
	}
}