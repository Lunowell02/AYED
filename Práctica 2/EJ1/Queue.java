package EJ1;

import java.util.LinkedList;
import java.util.List;

public class Queue<T>  {
	private List<T> data;
	
	public Queue(){
		this.data = new LinkedList<T>();
	}
	public List<T> getData() {
		return this.data;
	}
	public int size() {
		return this.data.size();
	}
	public boolean isEmpty() {
		if (this.getData() == null) {
			return true;
		}else {
			return false;
		}
	}
	public void enqueue(T dato) {
		this.data.add(dato);
	}
	
	public T dequeue(){
		if (this.data.isEmpty()) {
			return null;
		}else {
			return this.data.remove(0); //ahi me devuelve el primer elemento eliminado??
		}
	}
	
	public T head() {
		if (this.data.isEmpty()) {
			return null;
		}else {
			return this.data.get(0); 
		}
	}
	
	public String toString() {
		return this.getData().toString();
	}
}
