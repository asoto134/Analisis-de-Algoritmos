/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;

/**
 *
 * @author Adrian Soto
 */
public class Analisis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        int[][] MatrizPruebas = generaMatrizPruebas(10,5);
        
        ////PRUEBAS CON LOS ARREGLOS
        for (int[] MatrizPrueba : MatrizPruebas) 
        {
            int[] respuesta = Algoritmo.Goku(MatrizPrueba);
            imprimirArreglo(MatrizPrueba);
            System.out.println("El indice del mayor numero es: "+ respuesta[1]+ ", y el indice del segundo mayor numero es: " + respuesta[0]);
            System.out.println();
        }
    }

    
    
    /**
     * Este algoritmo imprime el arrglo de entrada.
     * @param arreglo arreglo de n numeros enteros.
     */
    public static void imprimirArreglo(int[] arreglo)
    {
        System.out.print("[");
        System.out.print(arreglo[0]);
        for(int i = 1;i<arreglo.length;i++)
        {
            System.out.print(",");
            System.out.print(arreglo[i]);
        }
        System.out.println("]");
    }

    
    
    /**
     * Este algoritmo genera una matriz de enteros con los datos de la entrada
     * para generar una secuencia de pruebas mas efectiva.
     * @param cantidadArreglos cantidad de arreglos que tendra la matriz.
     * @param largoArreglos cantidad de numeros que tendra cada arreglo en la matriz.
     */
    public static int[][] generaMatrizPruebas(int cantidadArreglos, int largoArreglos)
    {
        int[][] matriz = new int[cantidadArreglos][largoArreglos];
        for(int i = 0; i < cantidadArreglos;i++)
        {
            for(int j = 0; j< largoArreglos;j++)
            {
                matriz[i][j] = (int)(Math.random()*(100-0+1)+0);
            }
        }
        return matriz;
    }
    
    
}
