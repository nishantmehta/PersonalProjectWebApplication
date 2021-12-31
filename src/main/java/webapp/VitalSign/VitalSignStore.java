package webapp.VitalSign;


import java.util.List;
import java.util.UUID;

public interface VitalSignStore {
    UUID add(VitalSign vitalSign);
    List<VitalSign> getAllVitalSigns();
    List<VitalSign> getVitalSign(int numberOfRecentEvents);
}
