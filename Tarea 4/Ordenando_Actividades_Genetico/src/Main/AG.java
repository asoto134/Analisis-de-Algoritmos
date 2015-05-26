package Main;



public class AG {

    public static void main(String[] args) 
    {
        
    //Arreglo con las actividades
    String  [] actividades  =   {"Actividad 0","Actividad 1","Actividad 2","Actividad 3","Actividad 4",
                                 "Actividad 5","Actividad 6","Actividad 7","Actividad 8","Actividad 9",
                                 "Actividad 10","Actividad 11","Actividad 12","Actividad 13","Actividad 14",
                                 "Actividad 15","Actividad 16","Actividad 17","Actividad 18","Actividad 19"};
    //Arreglo con la hora de inicio de las actividades, el orden es el mismo que en el arreglo de actividades
    //ademas se esta utilizando la hora en formatos de 24 horas y no de 12 horas.
    int     []  horaInicioActividad =   {7,9,9,7,10,15,17,20,5,13,14,18,19,15,16,12,14,19,21,22};
    //Arreglo con la hora de Fin de las actividades, el orden es el mismo que en el arreglo de actividades
    //ademas se esta utilizando la hora en formatos de 24 horas y no de 12 horas.
    int     []  horaFinActividad    =   {9,10,11,9,13,17,18,23,7,15,17,20,20,16,18,15,16,20,22,23};
    
    
        
        
        

        // Establecer una solucion candidata
        FuncionDeFitness.establecerSolucion("11111111111111111111");
        
        // Establecer Horarios y Actividades
        FuncionDeFitness.establecerActividadesYHorarios(actividades, horaInicioActividad, horaFinActividad);
                

        // Crear una poblacion inicial
        Poblacion poblacion = new Poblacion(50, true);
        
        // Evolve our Poblacion until we reach an optimum solution
        int contadorDeGeneraciones = 0;
        while (poblacion.obtenerFittest().obtenerFitness() < FuncionDeFitness.obtenerMaxFitness() &&
                contadorDeGeneraciones < 100) 
        {
            contadorDeGeneraciones++;
            System.out.println("Generacion: " + contadorDeGeneraciones + " Mejor: " + poblacion.obtenerFittest().obtenerFitness());
            poblacion = Algoritmo.evolucionarPoblacion(poblacion);
        }
        System.out.println("Solucion encontrada!");
        System.out.println("Generacion: " + contadorDeGeneraciones);
        System.out.println("Genes:");
        Individuo solucion = poblacion.obtenerFittest();
        System.out.println(solucion);
        System.out.println();
        
        ///////////Imprimir Solucion bonita;
        System.out.println("Imprimir Horario");
        for(int i = 0; i < solucion.tamanno() ; i++)
        {
            if(solucion.obtenerGen(i)== 1)
            {
                System.out.println("Actividad: "+actividades[i]+", Empieza a las "
                                    +horaInicioActividad[i]+", Termina a las "+
                                     horaFinActividad[i]);
            }
        } 

    }
}
