/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olari
 */
public class Funcionalidades <T>{
    

    public static int pref(String pref){
        int resp=0;

        if(pref.equals("+") || pref.equals("-"))
            resp=3;
        if(pref.equals("*") || pref.equals("/"))    
           resp= 4;       
        if(pref.equals("^"))
            resp=5;
        
        
        return resp;}

    public static boolean balanceParentesis(String cadena){
        boolean resp=false;
        int letras= cadena.length(), i=0;
        PilaA pila1= new PilaA();
        char letra;
        
        if(!cadena.equals("")){
        
        while(i<letras && i!=-1){
            letra=cadena.charAt(i);
            
            if(letra=='(')
                pila1.push('(');
            
            if(letra==')'){
                if(!pila1.isEmpty() && pila1.peek().equals('('))
                   pila1.pop();
                else
                   i=-2;}
            
            i++;}
        
        if(i!=-1 && pila1.isEmpty())
            resp=true;}
        
       return resp;}
    
    public static boolean esOperador(String caracter){
        boolean resp=false;
        
        switch(caracter){
            case"+":resp=true;break;
            case"-":resp=true;break;
            case"*":resp=true;break;
            case"/":resp=true;break;
            case"^":resp=true;break;}
 
        return resp;}
    
    public static boolean esOperadorSinResta(String caracter){
        boolean resp=false;
        
        switch(caracter){
            case"+":resp=true;break;
            case"*":resp=true;break;
            case"/":resp=true;break;
            case"^":resp=true;break;}
 
        return resp;}
    
    public static boolean esNumero(String caracter){
        boolean resp=false;
        
        switch(caracter){
            case"1":resp=true;break;
            case"2":resp=true;break;
            case"3":resp=true;break;
            case"4":resp=true;break;
            case"5":resp=true;break;
            case"6":resp=true;break;
            case"7":resp=true;break;
            case"8":resp=true;break;
            case"9":resp=true;break;
            case"0":resp=true;break;
        }
 
        return resp;}
    
    public static boolean verificaSintaxis(String cadena){
        PilaA pila= new PilaA();PilaA pila1= new PilaA();
        boolean resp=false, sigue=true;
        String letra;
        int i=0;
        
        while(i<cadena.length() && i!=-1){
            letra=String.valueOf(cadena.charAt(i));

            if(esNumero(letra)){                //NUMEROS
                if(pila.isEmpty() || !String.valueOf(pila.peek()).equals(")"))
                    pila.push(letra);
                else
                    i=-2;}
             
            if(esOperadorSinResta(letra)){     // + / * ^
                if(!pila.isEmpty() && !esOperador(String.valueOf(pila.peek())) && !String.valueOf(pila.peek()).equals(".") && !String.valueOf(pila.peek()).equals("("))
                   pila.push(letra);
                else
                    i=-2;}
            
            if(letra.equals("-")){             // -            
                if(String.valueOf(pila.peek()).equals("."))
                    i=-2;
                if(pila.isEmpty())
                   pila.push(letra);
                
                else{
                    if(String.valueOf(pila.peek()).equals("-")){
                        pila1.push(pila.pop());
                            
                        if(pila.isEmpty() || String.valueOf(pila.peek()).equals("-"))
                            i=-2;
                        else{
                            pila.push(pila1.pop());
                            pila.push(letra);}}
                
                    else
                        pila.push(letra);}         }
                
            if(letra.equals(".")){            // .
                if(esNumero(String.valueOf(pila.peek()))){    
                    
                    sigue=true;
                        while(sigue && i!=-2 && pila.peek()!=null){
                            if(String.valueOf(pila.peek()).equals("."))
                                i=-2;
                            else{
                                if(esOperador(String.valueOf(pila.peek())))
                                    sigue=false;
                            
                                else
                                    pila1.push(pila.pop());}}
                
                    while(pila1.peek()!=null)
                        pila.push(pila1.pop());
                
                    if(i!=-2)
                        pila.push(letra);}
            
                else
                    i=-2;}
            
            
            if(letra.equals("(")){             // (
                if(pila.isEmpty() || esOperador(String.valueOf(pila.peek())))
                   pila.push(letra);           
                else
                   i=-2;}
            
            if(letra.equals(")")){             // )
                if(!pila.isEmpty() && esNumero(String.valueOf(pila.peek())))
                    pila.push(letra);
                if(String.valueOf((pila.peek())).equals(")"))
                    pila.push(letra);
                else    
                    i=-2;}
            
            i++;}   
        
        if(pila.isEmpty())
            i=-1;
        
        if(esOperador(String.valueOf(pila.peek())) || String.valueOf(pila.peek()).equals(".") || String.valueOf(pila.peek()).equals("("))
            i=-1;
        
        if(i!=-1 && balanceParentesis(cadena))
            resp=true;
        
        return resp;}
    
    /**
     * Función que delimita los números y regresa una pila
     */
    
    public static PilaA delimitaCadena(String cadena){
        PilaA pila1= new PilaA(); PilaA pila2= new PilaA(); 
        String numero="", letra="";
        int i=0; 
       
        while(i<cadena.length()){
            letra=String.valueOf(cadena.charAt(i));
            
            if(i==cadena.length()-1){
                if(letra.equals(")")){
                    if(pila1.peek().equals(")"))
                        pila1.push(letra);                   
                    else{
                        pila1.push(numero);
                        pila1.push(letra);}}
                else{
                    numero=numero+letra;
                    pila1.push(numero);}}
            
            else{
                
                if(esNumero(letra) || letra.equals("."))
                    numero=numero+letra;
                
                if(esOperadorSinResta(letra)){
                    if(pila1.isEmpty()){
                        pila1.push(numero); 
                        pila1.push(letra);}
                    else
                        if(pila1.peek().equals(")"))
                            pila1.push(letra); 
                        else{
                            pila1.push(numero); 
                            pila1.push(letra); }
                
                        numero="";    }
                
                if(letra.equals(")")){
                    if(pila1.peek().equals(")"))
                       pila1.push(letra);
                    else{
                       pila1.push(numero); 
                       pila1.push(letra);}
                    numero="";}
                
                if(letra.equals("(")){
                    if(!numero.equals("")){
                        pila1.push(numero);
                        pila1.push(letra);
                        numero="";}
                    else
                        pila1.push(letra);}
                                
                if(letra.equals("-")){
                    if(!numero.equals("")){
                        pila1.push(numero); pila1.push(letra); numero="";}
                    
                    else{
                    if(pila1.isEmpty() || esOperador(String.valueOf(pila1.peek())) || pila1.peek().equals("(") /*|| pila1.peek().equals(")")*/)
                        numero="-";
                             
                    else{
                        if(numero.equals(""))
                            pila1.push(letra); 
                            
                        else{    
                            pila1.push(numero); 
                            pila1.push(letra);}numero="";}
                            
                        }}}
                
                    i++;}
    
            while(pila1.peek()!=null)
                pila2.push(pila1.pop());
    
            return pila2;}
    
    /**
     * Función que convierte la expresión de infijo a postfijo y lo regresa en una pila
     */
     
    public static PilaA conviertePostFijo(PilaA Expresion){
        PilaA Operadores= new PilaA(); PilaA Salida= new PilaA();
        String valor;
        
        while(!Expresion.isEmpty()){
            valor=String.valueOf(Expresion.peek());
            
            
            if(esOperador(valor)|| valor.equals("(") || valor.equals(")")){
               
                if(esOperador(valor)){
                
                    if(Operadores.isEmpty())
                  Operadores.push(Expresion.pop());
               
                else{
                  if(pref(valor) < pref(String.valueOf(Operadores.peek())))
                      Salida.push(Operadores.pop());
                        
                  
                  if(pref(valor) == pref(String.valueOf(Operadores.peek())))
                       Salida.push(Operadores.pop());
                      
                  Operadores.push(Expresion.pop());}}
            
            if(valor.equals("("))
               Operadores.push(Expresion.pop());
            
            if(valor.equals(")")){
                while(!String.valueOf(Operadores.peek()).equals("("))
                    Salida.push(Operadores.pop());
                
                    Operadores.pop();Expresion.pop();}}

            else
                Salida.push(Expresion.pop());}

        while(!Operadores.isEmpty())
            Salida.push(Operadores.pop());
            
        while(!Salida.isEmpty())
            Operadores.push(Salida.pop());
        

        return Operadores;}  
    
    /**
     * Función que resuelve la expresión expresada en formato postfija y regresa el resultado en un dato tipo double
     */
    
    public static <T> double Resuelve (PilaA pila){
        PilaA pila1= new PilaA(); 
        double operacion1, operacion2, resp=0.0;
        Object aux;

            while(pila.peek()!=null){
                aux=String.valueOf(pila.peek());
                
                if(!aux.equals("+") && !aux.equals("-") && !aux.equals("*") && !aux.equals("^") && !aux.equals("/"))
                    pila1.push(pila.pop());
                    
                else{
                    operacion1=Double.parseDouble(String.valueOf(pila1.pop()));
                    operacion2=Double.parseDouble(String.valueOf(pila1.pop()));

                    switch (String.valueOf(aux)){
                        case "+": resp=operacion2+operacion1;break;
                        case "-": resp=operacion2-operacion1;break;
                        case "*": resp=operacion2*operacion1;break;
                        case "/": resp=operacion2/operacion1;break;
                        case "^": resp=Math.pow(operacion2, operacion1);break;}

                    pila1.push(String.valueOf(resp));
                    pila.pop();}}

       return Double.parseDouble(String.valueOf(pila1.peek()));}
 
    
}
