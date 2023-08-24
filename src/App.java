import java.io.FileWriter;
import java.io.IOException;

public class App {
    
    /** 
     * @param args
     * 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    
        int [] A = {15,33,27,10,35,19,42,44};
        int salto;//valor del intervalo a separar el arragel en n subarreglos
        int aux;//guardar posicion arreglo
        int i;
        boolean cambios;//bandera por si se puede hacer un cambio en el arreglo
        //salto es el total del arrelgo el cual se divide en la mitad
        //Salto debe ser diferente de cero porque la minima es 1
        //luego de la primera iteracion dividir el salto en 2 y ese en 2 y asi hasta llegar a un solo arreglo

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;//si se intercambia paselo a falso
                // se da una pasada en el arreglo 
                for (i = salto; i < A.length; i++)  
                {//estaba por defecto >
                    if (A[i - salto] > A[i]) { // (mayor  o menor estaba <  y si están desordenados
                        aux = A[i];           // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true; // se realizo un cambio                                  
                    }
                }
            }
        }
        
        try {
            FileWriter writer = new FileWriter("Archivo.txt");
            for (int elemento : A) {
                writer.write(Integer.toString(elemento));
                writer.write(System.lineSeparator());
            }
            writer.close();
            System.out.println("Arreglo ordenado por inserción escrito en el archivo exitosamente.");
        } catch (IOException e) {
            
        }
    }
}
