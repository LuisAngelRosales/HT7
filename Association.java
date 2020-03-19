/*LUIS ANGEL ROSALES 19181 
 * DATOS 2020
 * HT7
*/

import java.util.Map;
import java.io.*;
import java.util.LinkedHashMap;

public class Association<K extends Comparable<K>,V>{    
    private Map<String, String> mapa = new LinkedHashMap<String, String>();

    
    /* Lee el archivo text.txt y lo mete a la lista para separarlo
     * 
     */
    public String[] leerTexto(){
        String[] partes = null;
        String nombreArchivo = "text.txt";

        String linea = null;

        try {

            FileReader fileReader = 
                new FileReader(nombreArchivo);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((linea = bufferedReader.readLine()) != null) {
                partes = linea.split(" ");
            }
            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "No se abrio el archivo '" + 
                nombreArchivo + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Hubo un error en la lectura '" 
                + nombreArchivo + "'");                  
        }
        return partes;
    }       
    
   /*
    * Traduce text.txt con las palabras del diccionario.
    */
    public void traducir(String[] palabras, ArbolBinario<String> tree){
        for(int n=0;n<palabras.length;n++){
            
            if(tree.encontrar(palabras[n].toLowerCase())||tree.encontrar(palabras[n].substring(0,1).toUpperCase())){
                System.out.print(mapa.get(palabras[n])+" ");
            }else{
                if(n == palabras.length-1 && tree.encontrar(palabras[n].substring(0,palabras[n].length()-1))){
                    System.out.print(mapa.get(palabras[n].substring(0,palabras[n].length()-1))+" ");
                }else{
                    System.out.print("*"+palabras[n]+"* ");
                }               
            }
        } 
    }   

    /* Lee el archivo dictionary.txt
     * devuelve un map tipo lhm
     */
 	public Map<String, String> lector(){
         String[] partes = null;
         String nombreArchivo = "dictionary.txt";

         String linea = null;
         String numeroLinea = null;

         try {

             FileReader lectorDeArchivos = 
                 new FileReader(nombreArchivo);

             BufferedReader bufferedReader = 
                 new BufferedReader(lectorDeArchivos);

             while((linea = bufferedReader.readLine()) != null) {
                 numeroLinea = linea.substring(1,linea.length()-1);
                 partes = numeroLinea.split(", ");

                 mapa.put(partes[0],partes[1]);
                 partes = null;
             }
             bufferedReader.close();         
         }
         catch(FileNotFoundException ex) {
             System.out.println(
                 "No se abrio el archivo '" + 
                 nombreArchivo + "'");                
         }
         catch(IOException ex) {
             System.out.println(
                 "Hubo un error en la lectura '" 
                 + nombreArchivo + "'");                  
         }
         return mapa;
     }  
}