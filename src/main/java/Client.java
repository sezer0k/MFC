import java.util.concurrent.atomic.AtomicBoolean;

class Client implements Runnable {
    private int category;
    private AtomicBoolean window1Occupied;
    private AtomicBoolean window2Occupied;
    private AtomicBoolean window3Occupied;
    private int[] departedClients;

    public Client(int category, AtomicBoolean window1Occupied, AtomicBoolean window2Occupied, AtomicBoolean window3Occupied, int[] departedClients) {
        this.category = category;
        this.window1Occupied = window1Occupied;
        this.window2Occupied = window2Occupied;
        this.window3Occupied = window3Occupied;
        this.departedClients = departedClients;
    }

    @Override
    public void run() {
        if (category == 1) { // Молодые
            if (!window1Occupied.getAndSet(true)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                window1Occupied.set(false);
            } else {
                departedClients[0]++;
            }
        } else if (category == 2) { // Пожилые
            if (!window2Occupied.getAndSet(true)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                window2Occupied.set(false);
            } else {
                departedClients[1]++;
            }
        } else if (category == 3) { // Бизнесмены
            if (!window3Occupied.getAndSet(true)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                window3Occupied.set(false);
            } else {
                departedClients[2]++;
            }
        }
    }
}