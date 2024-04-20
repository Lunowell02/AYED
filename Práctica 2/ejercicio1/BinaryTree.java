package ejercicio1;

import java.util.LinkedList;
import ejercicio1.Queue;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		if (this.isLeaf()) {
		   return 1;
	   }
	   int cant = 0; //DUDA: NO SE INICIALIZA EN 0 CADA VEZ QUE SE LLAMA RECURSIVAMENTE A LA FUNCIÓN
	   if (this.hasLeftChild()) {
		   cant = cant + getLeftChild().contarHojas();
	   }
	   if (this.hasRightChild()) {
		   cant = cant + getRightChild().contarHojas();
	   }
		return cant;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> newTree = new BinaryTree<T>(this.getData());
    	if (!this.isLeaf()) {
	    	if (this.hasLeftChild()) {
	    		newTree.addRightChild(this.getLeftChild());
	    	}
	    	if (this.hasRightChild()) {
	    		newTree.addLeftChild(this.getRightChild());
	    	}
    	}
 	   return newTree;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> ab;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this); //Se encola todo el arbol
		cola.enqueue(null); //Para determinar el cambio de nivel
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null){
				System.out.println(ab.getData());
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if (this.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			}else if (!cola.isEmpty()){
				System.out.println(); 
				cola.enqueue(null); // Es para hacer un salto de linea y que la impresion sea mas entendible

				}
			}
		}
		
}

