public class Coche implements Runnable{
    int ID ;
    int plaza;
    int tiempo;
    Parking parking;

    public Coche(int ID, Parking parking){
        this.ID = ID;
        this.parking = parking;
        this.tiempo = (int) (Math.random()*6 + 1)*1000;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    @Override
    public void run() {
        parking.entrar(this);
        parking.aparcando(this);
        synchronized (this) {
            try {
                this.wait(this.tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parking.salir(this);
        }
    }
}
