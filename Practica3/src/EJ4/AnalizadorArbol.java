package EJ4;


import java.util.List;
import EJ1.Queue;
import EJ1.GeneralTree;


public class AnalizadorArbol {
	private GeneralTree<AreaEmpresa> ab;
	
	public AnalizadorArbol() {
		
	}

	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		double promMax = 0.0;
		int valorNivel = 0;
		int cantNodos = 0;
		GeneralTree<AreaEmpresa> aux;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if(aux != null) {
				cantNodos ++;
				valorNivel = valorNivel + aux.getData().getTardanza() ;
				List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
				for (GeneralTree<AreaEmpresa> child : children) {
					cola.enqueue(child);
					
				}
			}else if (!cola.isEmpty()){
				
				promMax = Math.max(promMax, (valorNivel/cantNodos));
				valorNivel = 0;
				cantNodos = 0;
				cola.enqueue(null);
			}
		}
		return promMax;
	}


}
