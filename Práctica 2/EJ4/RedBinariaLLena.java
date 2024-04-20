package EJ4;

import ejercicio1.BinaryTree;

public class RedBinariaLLena {
	private BinaryTree<Integer> red;
	
	public RedBinariaLLena (BinaryTree<Integer> unaRed) {
		this.red = unaRed;
	}
	
	private int llamado () { //Pregunto si el arbol no está vacio, si no esta vacio llama al metodo que calcula el retardo del envio
		if (!red.isEmpty()) {
			return retardoReenvio(this.red);
		}else {
			return 0;
		}
	}
	
	private int retardoReenvio(BinaryTree<Integer> arbol) {
		int redHI = 0;
		int redHD = 0;
		if (arbol.hasLeftChild()) {
			redHI = retardoReenvio(arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			redHD = retardoReenvio(arbol.getRightChild());
		}
		return (arbol.getData() + Math.max(redHI, redHD)); // devuelve el mayor numero 
	}
	
	public static void main (String[] args) {
        System.out.println("Test mayor retardo");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(3));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        RedBinariaLLena red = new RedBinariaLLena(ab);
        System.out.println("El mayor retardo posible es de: " + red.llamado() + " segundos");
    }
}
	
