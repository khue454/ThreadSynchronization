package thread.synchronization.model;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class Choptick {
    private int id;
    private boolean isUsed;

    public Choptick(int id) {
        this.id = id;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void useChoptick() {
        isUsed = true;
    }

    public void putdownChoptick() {
        isUsed = false;
    }
}
