package prog.lab8.thread_matrix;

import prog.lab5.matrixes.Matrix;
/*
import prog.lab5.excpt.*;
import prog.lab5.interfaces.*;        */

public class MatrixThread extends Thread {
	private int fromRow;
	private int toRow;
	Matrix a, b, res;

	public MatrixThread(Matrix a, Matrix b, Matrix res, int fromRow, int toRow){
		this.a = a;
		this.b = b;
		this.res = res;
		this.fromRow = fromRow;
		this.toRow = toRow;
	}

	@Override
	public void run(){
		for(int i = fromRow; i <= toRow; i++){
			for(int j = 0; j < res.getRowSize(); j++){
				for(int k = 0; k < res.getColumnSize(); k++){
					res.setElement(i, j, res.getElement(i, j) + (a.getElement(i, k) * b.getElement(k, j)));
				}
			}
		}
	}
}