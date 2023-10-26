import java.util.concurrent.atomic.AtomicBoolean;


public class MFC {
    public static void main(String[] args) {
        AtomicBoolean window1Occupied = new AtomicBoolean(false);
        AtomicBoolean window2Occupied = new AtomicBoolean(false);
        AtomicBoolean window3Occupied = new AtomicBoolean(false);

        int totalClients = 1000;

        int[] departedClients = new int[3];

        for (int i = 0; i < totalClients; i++) {
            int randomCategory = (int) (Math.random() * 3) + 1;

            Thread clientThread = new Thread(new Client(randomCategory, window1Occupied, window2Occupied, window3Occupied, departedClients));
            clientThread.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double percentYoung = (double) departedClients[0] / totalClients * 100;
        double percentElderly = (double) departedClients[1] / totalClients * 100;
        double percentBusinessman = (double) departedClients[2] / totalClients * 100;

        System.out.println("Процент ушедших молодых клиентов: " + percentYoung + "%");
        System.out.println("Процент ушедших пожилых клиентов: " + percentElderly + "%");
        System.out.println("Процент ушедших бизнесменов: " + percentBusinessman + "%");
    }
}
