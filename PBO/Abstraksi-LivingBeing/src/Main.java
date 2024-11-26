public class Main {
    public static void main(String[] args) {
        LivingBeing azka = new Human();
        LivingBeing sapi = new Animals();
        LivingBeing anggrek = new Plant();

        System.out.println("Manusia:");
        azka.breathe();
        azka.grow();

        System.out.println("Hewan:");
        sapi.breathe();
        sapi.grow();

        System.out.println("Tumbuhan:");
        anggrek.breathe();
        anggrek.grow();
    }
}