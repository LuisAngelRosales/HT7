/*LUIS ANGEL ROSALES 19181 
 * DATOS 2020
 * HT7
*/

import java.util.Map;
import java.util.Iterator;

public class Main{
    public static void main(String arg[]){
        ArbolBinario<String> tree = new ArbolBinario<String>(); //Creando nuevo BynarySearchTree<E>
        Association<String,String> assoc = new Association<String,String>(); //Creando Association<K,V> con key y value tipo String
        Map<String, String> map = null; 
        Iterator<String> it = null; 
        String[] words = null;
        /*
         * Leer arbol
         */
        map = assoc.lector();
        it = map.keySet().iterator();
        /*
         * Las asociaciones van en el map
         */

        /*
         * Asociaciones del arbol
         */
		while(it.hasNext()){
            String key = it.next();
            key = key.toLowerCase();
/*
 * Minusculas
 */
            tree.insertar(key); 
            /*                        ^
             * Se inserta en el arbol l
             */
               
        }

        /*
         * Se llaman los metodos que traducen
         */
        System.out.println("\nTexto:\n");
        words = assoc.leerTexto();
        assoc.traducir(words, tree);
        System.out.println("\n");
	}
}