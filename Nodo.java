/*LUIS ANGEL ROSALES 19181 
 * DATOS 2020
 * HT7
*/


public class Nodo<E>{
	String datos;
	Nodo<E> left;
	Nodo<E> right;	
	public Nodo(String datos){
		this.datos = datos;
		left = null;
		right = null;
	}
}