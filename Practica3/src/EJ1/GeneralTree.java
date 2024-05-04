package EJ1;

import java.util.LinkedList;
import java.util.List;
import EJ1.Queue;
public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if (this.isEmpty()) {
			return -1;
		}
		return calcularAltura();
	}
	
	private int calcularAltura() {
		if (this.isLeaf()) {
			return 0;
		}else {
			int alturaMax = -1;
			List<GeneralTree<T>> children = this.getChildren();
			for (GeneralTree<T> child: children) {
				alturaMax = Math.max(alturaMax, child.calcularAltura());
			}
			return alturaMax + 1;
		}
	}
	
	public int nivel(T dato){
		if (this.isEmpty()) {
			return -1;
		}
		return calcularNivel(dato);
	}

	private int calcularNivel(T dato) {
		int cont = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		while (!cola.isEmpty()) {
			for (int i=0; i<cola.size();i++) {
				aux = cola.dequeue();
				if (aux.getData().equals(dato)) {
					return cont;
				}else {
					for(GeneralTree<T> child : aux.getChildren()) {
						cola.enqueue(child);
					}
				}
			}
			cont ++;	
		}
		return -1;	
	} 
	public int ancho(){
		if (this.isEmpty()) {
			return -1;
		}
		return calcularAncho();
	}
	private int calcularAncho() {
		int max = 0;
		int cantAct = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree<T> child : children) {
					cola.enqueue(child);
					cantAct ++;
				}
			}else if (!cola.isEmpty()){
				max = Math.max(max, cantAct);
				cantAct = 0;
				cola.enqueue(null);
			}
		}
		return max;
	}
}