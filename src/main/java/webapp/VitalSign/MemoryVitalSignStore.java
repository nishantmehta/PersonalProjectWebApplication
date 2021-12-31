package webapp.VitalSign;

import java.util.*;

public class MemoryVitalSignStore implements VitalSignStore{
    List<VitalSign> store = new LinkedList<>();

    @Override
    public UUID add(VitalSign vitalSign) {
        store.add(vitalSign);
        return vitalSign.id();
    }

    @Override
    public List<VitalSign> getAllVitalSigns() {
        return Collections.unmodifiableList(store);
    }

    @Override
    public List<VitalSign> getVitalSign(int numberOfRecentEvents) {
        return store.subList(store.size() - numberOfRecentEvents, store.size());
    }
}
