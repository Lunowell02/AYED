package EJ5;

import ejercicio1.BinaryTree;
public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> unArbol) {
		this.arbol = unArbol;
	}
	
	public int llamar(int p) {
        if (!this.arbol.isEmpty()) {
        	return sumaElementosProfundidad(p, this.arbol, 0);
        }else {
        	return 0;
        }
    }
    
    private int sumaElementosProfundidad(int p, BinaryTree<Integer> ab, int nivActual) {
        if(p == nivActual) {
            return ab.getData();
        } else {
            int suma = 0;
            if(ab.hasLeftChild()) suma+= sumaElementosProfundidad(p, ab.getLeftChild(), nivActual+1);
            if(ab.hasRightChild()) suma+= sumaElementosProfundidad(p, ab.getRightChild(), nivActual+1);
            return suma;
        }
    }
}

//NO LO ENTIENDO