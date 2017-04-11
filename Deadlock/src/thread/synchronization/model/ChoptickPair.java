package thread.synchronization.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class ChoptickPair {
    private static List<Choptick> chopticks = new ArrayList<Choptick>() {{
        add(new Choptick(1));
        add(new Choptick(2));
        add(new Choptick(3));
        add(new Choptick(4));
        add(new Choptick(5));
    }};
    private boolean canUseChoptick(int choptickId) {
        return !chopticks.get(choptickId).isUsed();
    }

    public Choptick getChoptickOnLeft(int philosopherId) {
        return getChoptick(philosopherId);
    }

    public Choptick getChoptickOnRight(int philosopherId) {
        if(philosopherId+1 == chopticks.size()){
            return getChoptick(0);
        }
        return getChoptick(philosopherId + 1);
    }

    private Choptick getChoptick(int choptickId) {
        if (canUseChoptick(choptickId)) {
            chopticks.get(choptickId).useChoptick();
            return chopticks.get(choptickId);
        }
        return null;
    }
}
