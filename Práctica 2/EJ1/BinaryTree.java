package EJ1;

import EJ1.Queue;


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
	   int cant = 0; // se resetea cada vez que se ejecuta el contarHojas()??
	   if (this.hasLeftChild()) {
		   cant = cant + this.getLeftChild().contarHojas();
	   }
	   if (this.hasRightChild()) {
		   cant = cant + this.getRightChild().contarHojas();
	   }
	   return cant; //Está bien que sea un único contador??
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



	public class Main {
	    public static void main(String[] args) {
	        // Crear nodos para el árbol
	        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
	        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
	        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
	        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
	        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
	        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);

	        // Construir la estructura del árbol
	        nodo1.addLeftChild(nodo2);
	        nodo1.addRightChild(nodo3);
	        nodo2.addLeftChild(nodo4);
	        nodo2.addRightChild(nodo5);
	        nodo3.addLeftChild(nodo6);

	        // Mostrar la cantidad de hojas del árbol
	        System.out.println("Cantidad de hojas del árbol: " + nodo1.contarHojas());
	        
	    }
	}
}

