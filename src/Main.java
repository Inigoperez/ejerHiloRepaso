public class Main {
    private static int i=0;

    public static void main(String[] args) {
        Parking parking= new Parking();
        while (i<10){
            i++;
            Coche coche = new Coche(i,parking);
            coche.run();
        }
    }
}
