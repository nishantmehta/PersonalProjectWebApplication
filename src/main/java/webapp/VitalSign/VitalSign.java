package webapp.VitalSign;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize
public record VitalSign(UUID id,
                        LocalDateTime timestamp,
                        int energy,
                        int urgeToSmoke,
                        boolean didYouSmoke) {
    public VitalSign(int energy, int urgeToSmoke, boolean didYouSmoke) {
        this(UUID.randomUUID(), LocalDateTime.now(), energy, urgeToSmoke, didYouSmoke);
    }
}
