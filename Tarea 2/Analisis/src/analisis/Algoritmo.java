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
public class Algoritmo 
{
    
/**
 * Este algoritmo se llama recursivamente hasta dividir el arreglo en un arreglo de tamaño 1
 * luego empieza a unir todos los arreglos con GokuSuperSaiyajin para verificar donde se encuentra 
 * el indice del mayor numero y el segundo mayor numero en el arreglo.
 *@param arreglo arreglo de n numeros enteros.
 *@return Un arreglo con el indice del segundo mayor y mayor numero, en el arreglo respectivamente.
 *@see int[].
 */
    public static int[] Goku(int[] arreglo)
    {
        if(arreglo.length == 2)
        {
            if(arreglo[0] <= arreglo[1])
            {
                int[] respuesta = {0,1};
                return respuesta;
            }
            else
            {
                int[] respuesta = {1,0};
                return respuesta;
            }
        }
        else
        {
            int mitad = arreglo.length / 2;
            int[] arreglo1 = new int[mitad];
            int[] arreglo2 = new int[arreglo.length-mitad];
            for (int i = 0;i< arreglo.length;i++)
            {
                if(i < mitad)
                {
                    arreglo1[i] = arreglo[i];
                }
                else
                {
                    arreglo2[i-mitad] = arreglo[i];
                }
            }
            return GokuSuperSaiyajin(arreglo1, arreglo2, mitad, arreglo.length-mitad);
        }
    }
    

/**
 * Este algoritmo mezcla y une virtualmente los dos arreglos verificando cual es el indice 
 * del segundo mayor y mayor numero entre los dos arreglos unidos consecutivamente.
 *@param arreglo1 arreglo de n numeros enteros.
 *@param arreglo2 arreglo de n numeros enteros.
 *@param largoArreglo1  arreglo de n numeros enteros.
 *@param largoArreglo2  arreglo de n numeros enteros.
 *@return Un arreglo con el indice del segundo mayor y mayor numero, en el arreglo respectivamente.
 *@see int[]. 
 */
    public static int[] GokuSuperSaiyajin(int[] arreglo1,int[] arreglo2, int largoArreglo1, int largoArreglo2)
    {
        int[] respuesta = new int[2];
        int[] arregloTemp = new int[largoArreglo1+largoArreglo2];
        int indiceSegundoMayorNumero = 0;
        int indiceMayorNumero = 0;
        arregloTemp[0] = arreglo1[0];
        for (int i = 1; i < largoArreglo1;i++)
        {
            if(arreglo1[i] > arregloTemp[indiceSegundoMayorNumero])
            {
                indiceSegundoMayorNumero = i;
            }
            if(arreglo1[i] > arregloTemp[indiceMayorNumero])
            {
                indiceSegundoMayorNumero = indiceMayorNumero;
                indiceMayorNumero = i;
            }
            arregloTemp[i] = arreglo1[i];
        }
        for (int j = 0; j < largoArreglo2;j++)
        {
            if(arreglo2[j] > arregloTemp[indiceSegundoMayorNumero])
            {
                indiceSegundoMayorNumero = largoArreglo1+j;
            }
            if(arreglo2[j] > arregloTemp[indiceMayorNumero])
            {
                indiceSegundoMayorNumero = indiceMayorNumero;
                indiceMayorNumero = largoArreglo1+j;
            }
            arregloTemp[largoArreglo1+j] = arreglo2[j];
        }
        respuesta[0] = indiceSegundoMayorNumero;
        respuesta[1] = indiceMayorNumero;
        return respuesta;
    }
    
    
}
