import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class Parking {

    Vector<Coche> plazas = new Vector(5);
    Semaphore semaforoEntrada = new Semaphore(5);
    Semaphore semaforoEntrada1 = new Semaphore(1);


    public void entrar(Coche coche){
        try{
            semaforoEntrada.acquire();
            semaforoEntrada1.acquire();
            System.out.println("El coche "+coche.ID+" esta entrando al parking");
            semaforoEntrada1.release();
            aparcando(coche);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void aparcando(Coche coche){
        plazas.add(coche);
        coche.setPlaza(plazas.indexOf(coche));
        System.out.println("El coche "+coche.ID+" esta aparcando en la plaza Nº "+coche.plaza);
    }

    public void salir(Coche coche){
        plazas.remove(coche.plaza);
        semaforoEntrada.release();
        System.out.println("El coche "+coche.ID+" esta saliendo del parking");
    }
}


/*
coches "numero de coches saliendo/entrando del parking"
	- Dentro del parking esta un tiempo aleatorio
plazas "el numero de plazas que tiene el parking"
	- Plazas numeradas, cuando un coche aparca se le guarda el Num de plaza

en la entrada un semaforo

"Entrada del coche $id aparca en la plaza $Num_plaza"
"Quedan $plazas plazas disponibles"
"El coche $id esta saliendo"

Constructora(num coches,num plazas)
 */