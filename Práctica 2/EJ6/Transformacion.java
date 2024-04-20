package EJ6;

import ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> tree;
	
	public Transformacion (BinaryTree<Integer> unTree) {
		this.tree = unTree;
	}
	
	public int suma(BinaryTree<Integer> arbol) {
		int suma = 0;
		if (arbol.isLeaf()) {
			suma = arbol.getData();
			arbol.setData(0);
			return suma;
		}
		if (arbol.hasLeftChild()) {
			suma(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			suma(arbol.getRightChild());
		}
		int aux = arbol.getData();
		tree.setData(suma);
		return suma + aux;
	}
	
	private BinaryTree<Integer> suma (){
		if (this.tree.isEmpty()) {
			return null;
		}
		suma(this.tree);
		return this.tree;
	}

}
