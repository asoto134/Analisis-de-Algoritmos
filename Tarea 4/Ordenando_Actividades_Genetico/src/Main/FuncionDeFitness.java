package Main;



public class FuncionDeFitness 
{
    
    //Arreglo con las actividades
    static String  [] actividades = new String  [20] ;
    //Arreglo con la hora de inicio de las actividades, el orden es el mismo que en el arreglo de actividades
    //ademas se esta utilizando la hora en formatos de 24 horas y no de 12 horas.
    static int     []  horaInicioActividad = new int[20];
    //Arreglo con la hora de Fin de las actividades, el orden es el mismo que en el arreglo de actividades
    //ademas se esta utilizando la hora en formatos de 24 horas y no de 12 horas.
    static int     []  horaFinActividad = new int[20];
    
    static byte[] solucion = new byte[20];
    
    
    public static void establecerActividadesYHorarios(String [] pActividades,int [] pHoraInicioActividad,
                                                      int[] pHoraFinActividad  )
    {
        actividades = pActividades;
        horaInicioActividad = pHoraInicioActividad;
        horaFinActividad = pHoraFinActividad;   
    }

    // Establecer una solucion candidata como un arreglo de bytes
    public static void establecerSolucion(byte[] nuevaSolucion) 
    {
        solucion = nuevaSolucion;
    }
    
    

    static void establecerSolucion(String nuevaSolucion) {
        solucion = new byte[nuevaSolucion.length()];
        for (int i = 0; i < nuevaSolucion.length(); i++) {
            String caracter = nuevaSolucion.substring(i, i + 1);
            if (caracter.contains("0") || caracter.contains("1")) {
                solucion[i] = Byte.parseByte(caracter);
            } else {
                solucion[i] = 0;
            }
        }
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static int obtenerFitness(Individuo individuo) 
    {
        Integer [] horas = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        
        int fitness = 0;
        // Iterar por todos los genes del individuo y compararlo
        // con los de nuestro candidato.
        for (int i = 0; i < individuo.tamanno() && i < solucion.length; i++) 
        {
            if (individuo.obtenerGen(i) == solucion[i]) 
            {
                fitness++;
                for(int j = horaInicioActividad[i]; j < horaFinActividad[i]; j++ )
                {
                    if(horas[j] != null)
                    {
                        horas[j] = null;
                    }
                    else
                    {
                        fitness = 0;
                        break;
                    }
                }
            }
        }
        return fitness;
    }
    
    // Obtener el fitness optimo
    static int obtenerMaxFitness() 
    {
        int maxFitness = solucion.length;
        return maxFitness;
    }
}
