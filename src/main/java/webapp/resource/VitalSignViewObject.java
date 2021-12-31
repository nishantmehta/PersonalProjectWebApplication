package webapp.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record VitalSignViewObject(int energy, int smokingUrge, boolean didYouSmoke) {
}
