/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olari
 */
public class Ejecutable {
    
    public static <T> String imprimeArr (T[] arr){
        int i, tope=arr.length;
        StringBuilder sb= new StringBuilder();
        
        for(i=tope-1;i>=0;i--){
            if(arr[i]!=null){
            if(i==tope-1)
                sb.append(arr[i]);
            else
                sb.append(arr[i]+", ");
        }}
        return sb.toString();
    }
    
    public static void main(String[] args) {
      
        String cadena="2+4/5*(5-3)^5^4";
        PilaA pila1= new PilaA(); PilaA pila2= new PilaA();
        double resultado;
        
        //pila1=Funcionalidades.delimitaCadena(cadena); 
        
        //resultado=Funcionalidades.Resuelve(pila2);
        
        System.out.println(cadena);
        //System.out.println(imprimeArr(Funcionalidades.delimitaCadena(cadena));
        //System.out.println(imprimeArr(Funcionalidades.conviertePostFijo(pila1)));
        
   
    }
}
