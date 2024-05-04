package EJ2;

import java.util.LinkedList;
import EJ1.Queue;
import java.util.List;

import EJ1.GeneralTree;
public class RecorridosAG {
    private GeneralTree<Integer> tree;
    
    public RecorridosAG() {}
    
    public RecorridosAG(GeneralTree<Integer> a) {
        this.tree = a;
    }
    
    public List <Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, Integer n) {
        List <Integer> l = new LinkedList<Integer>();
        if(!a.isEmpty()) {
        	this.numerosImparesMayoresQuePreOrden(a, n, l);
        }
        return l;
    }
    
    private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, Integer n, List <Integer> l) {
        int dato = a.getData();
        if(dato %2 != 0 && dato > n) l.add(dato);
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child: children) {   //De que otra manera puedo escribir este for??
            numerosImparesMayoresQuePreOrden(child, n, l);
        }
    }
    
    public List <Integer> numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, Integer n) {
    	List<Integer> l = new LinkedList<Integer>();
    	if (!a.isEmpty()) {
    		this.numerosImparesMayoresQueInOrden(a, n, l);
    	}
    	return l;
    }
    private void numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, Integer n, List <Integer> l) {
    	List<GeneralTree<Integer>> children = a.getChildren();
    	if (a.hasChildren()) {
    		this.numerosImparesMayoresQueInOrden(children.get(0), n, l); //el children.get(0) devulve el hijo en la posicion solicitada. Como en el inorden primero se procesa
    																	// el hijo izquierdo, despues la riz y despues los hijos restantes. Se pone que llame con el primer hijo (el izquierdo)
    	}
    	int dato = a.getData();
    	if (dato % 2 !=0 && dato > n) {
    		l.add(dato);
    	}
    	for (int i=1; i < children.size();i++) {
    		this.numerosImparesMayoresQueInOrden(children.get(i), n, l);
    	}
    	
    } 
    public List <Integer> numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a, Integer n) {
    	List<Integer> l = new LinkedList<Integer>();
    	if (!a.isEmpty()) {
    		this.numerosImparesMayoresQuePostOrden(a, n, l);
    	}
    	return l;
    }
    private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a, Integer n, List <Integer> l) {
    	List<GeneralTree<Integer>> children = a.getChildren();
    	int dato = a.getData();
    	for (int i=1; i < children.size();i++) {
    		this.numerosImparesMayoresQueInOrden(children.get(i), n, l);
    	}
    	if (dato % 2 !=0 && dato > n) {
    		l.add(dato);
    	}
    	
    }
    public List<Integer> numerosImparesMayoresQuePorNivel (GeneralTree<Integer> a, Integer n){
    	List <Integer> l = new LinkedList<Integer>();
    	if (a.isEmpty()) {
    		return null;
    	}else {
    		GeneralTree<Integer> aux;
    		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
    		cola.enqueue(a);
    		while (!cola.isEmpty()) {
    			aux=cola.dequeue();
    			if (!aux.isEmpty()) {
    				int dato = aux.getData();
    				if (dato % 2 !=0 && dato > n) {
    		    		l.add(dato);
    		    	}
    			}
    			List<GeneralTree<Integer>> children = aux.getChildren();
    			for (GeneralTree<Integer> child : children) {
    				cola.enqueue(child);
    			}
    		}
    	}
    	 
    	return l;
    	
    }
    
     
}
