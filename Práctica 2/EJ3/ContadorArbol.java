package EJ3;

import java.util.ArrayList;
import java.util.List;

import EJ1.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol (BinaryTree<Integer> unArbol) {
		this.arbol = unArbol;
	}
	
	public boolean esPar(int num) {
		return num % 2 == 0;
	}
	
	public List<Integer> numerosParesInOrden(){
		List<Integer> numerosPares = new ArrayList<Integer>();
		obtenerInOrden(this.arbol,numerosPares);
		return numerosPares;
	}
	
	public void obtenerInOrden(BinaryTree<Integer> nodo, List<Integer> numerosPares ) {
		if (nodo == null) {
			return;
		}else {
			if (nodo.hasLeftChild()) {
				obtenerInOrden(nodo.getLeftChild(),numerosPares);
			}
			if (esPar(nodo.getData())) {
				numerosPares.add(nodo.getData());
			}
			if (nodo.hasRightChild()) {
				obtenerInOrden(nodo.getRightChild(),numerosPares);
			}
		}
	}
	public List<Integer> numerosParesPostOrden(){
		List<Integer> numerosPares = new ArrayList<Integer>();
		obtenerPostOrden(this.arbol,numerosPares);
		return numerosPares;
	}
	public void obtenerPostOrden(BinaryTree<Integer> nodo, List<Integer> numerosPares ) {
		if (nodo == null) {
			return;
		}else {
			if (nodo.hasLeftChild()) {
				obtenerInOrden(nodo.getLeftChild(),numerosPares);
			}
			if (nodo.hasRightChild()) {
				obtenerInOrden(nodo.getRightChild(),numerosPares);
			}
			if (esPar(nodo.getData())) {
				numerosPares.add(nodo.getData());
			}
		}
	}
}
