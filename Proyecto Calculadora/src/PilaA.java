
public class PilaA <T> implements PilaADT <T>{
    
    private T[] pila;
    private int tope;
    private final int MAXIMO=1;

    public PilaA() {
    pila= (T[])new  Object [MAXIMO];
    tope=-1;}

    public PilaA(int max) {
    pila= (T[])new  Object [max];
    tope=-1;}

    public T[] getPila() {
        return pila;
    }
   
    public void Expande(){
        T[] masGrande = (T[]) new Object[pila.length*2];
        
        for(int i=0; i<=tope; i++)
            masGrande[i]= pila[i];
           
        pila= masGrande;}
    
    @Override
    public void push(T dato) {
        if(tope == pila.length-1)
            Expande();
       
        tope++;
        pila[tope]= dato;}

    @Override
    public T pop() {
        if(isEmpty()){}
            //throw new Excepcion("La pila no tiene datos");
        
        T eliminado= pila[tope];
        pila[tope]=null;
        tope--;
        
        return eliminado;}

    @Override
    public boolean isEmpty() {
        return tope==-1;}

    @Override
    public T peek() {
    T resp;    
       if(tope!=-1)
          return pila[tope];
       else
           return null;}
       
    
}
