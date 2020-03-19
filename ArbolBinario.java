/*LUIS ANGEL ROSALES 19181 
 * DATOS 2020
 * HT7
 * https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
*/

public class ArbolBinario<E extends Comparable<E>> {
    public Nodo<E> raiz;
	public ArbolBinario(){
		this.raiz = null;
    }
    
    public Nodo<E> getRaiz(){
        return this.raiz;
    }

	public boolean encontrar(String identificador){
		Nodo<E> actual = raiz;
		while(actual!=null){
			if(actual.datos.compareTo(identificador) == 0){
				return true;
			}else if(actual.datos.compareTo(identificador) > 0){
				actual = actual.left;
			}else{
				actual = actual.right;
			}
		}
		return false;
	}
	public boolean eliminar(String identificador){
		Nodo<E> padre = raiz;
		Nodo<E> actual = raiz;
		boolean hijoIzquierda = false;
		while(actual.datos.compareTo(identificador) != 0){
			padre = actual;
			if(actual.datos.compareTo(identificador) > 0){
				hijoIzquierda = true;
				actual = actual.left;
			}else{
				hijoIzquierda = false;
				actual = actual.right;
			}
			if(actual ==null){
				return false;
			}
		}

		if(actual.left==null && actual.right==null){
			if(actual==raiz){
				raiz = null;
			}
			if(hijoIzquierda ==true){
				padre.left = null;
			}else{
				padre.right = null;
			}
		}

		else if(actual.right==null){
			if(actual==raiz){
				raiz = actual.left;
			}else if(hijoIzquierda){
				padre.left = actual.left;
			}else{
				padre.right = actual.left;
			}
		}
		else if(actual.left==null){
			if(actual==raiz){
				raiz = actual.right;
			}else if(hijoIzquierda){
				padre.left = actual.right;
			}else{
				padre.right = actual.right;
			}
		}else if(actual.left!=null && actual.right!=null){
			
		
			Nodo<E> sucesorr	 = getPadre(actual);
			if(actual==raiz){
				raiz = sucesorr;
			}else if(hijoIzquierda){
				padre.left = sucesorr;
			}else{
				padre.right = sucesorr;
			}			
			sucesorr.left = actual.left;
		}		
		return true;		
	}
	
	public Nodo<E> getPadre(Nodo<E> deleleNode){
		Nodo<E> sucesor =null;
		Nodo<E> padreSucesor =null;
		Nodo<E> actual = deleleNode.right;
		while(actual!=null){
			padreSucesor = sucesor;
			sucesor = actual;
			actual = actual.left;
		}

		if(sucesor!=deleleNode.right){
			padreSucesor.left = sucesor.right;
			sucesor.right = deleleNode.right;
		}
		return sucesor;
	}
	public void insertar(String identificador){
		Nodo<E> nuevoNodo = new Nodo<E>(identificador);
		if(raiz==null){
			raiz = nuevoNodo;
			return;
		}
		Nodo<E> actual = raiz;
		Nodo<E> padre = null;
		while(true){
			padre = actual;
			if(identificador.compareTo(actual.datos)<0){				
				actual = actual.left;
				if(actual==null){
					padre.left = nuevoNodo;
					return;
				}
			}else{
				actual = actual.right;
				if(actual==null){
					padre.right = nuevoNodo;
					return;
				}
			}
		}
    }
    
	public void mostrarEnOrden(Nodo<E> raiz){
		if(raiz!=null){
			mostrarEnOrden(raiz.left);
			System.out.print(" " + raiz.datos);
            mostrarEnOrden(raiz.right);
		}
    }		
}

