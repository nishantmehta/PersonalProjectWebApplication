package webapp.resource;

import com.codahale.metrics.annotation.Timed;
import webapp.VitalSign.VitalSign;
import webapp.VitalSign.VitalSignStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/health")
@Produces(MediaType.APPLICATION_JSON)
public class WebApplicationResource {
    private VitalSignStore vitalSignStore;
    public WebApplicationResource(VitalSignStore vitalSignStore) {
        this.vitalSignStore = vitalSignStore;
    }

    @POST
    @Timed
    @Path("vitalsign")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addVitalSign(@FormParam("energy") int energy,
                                 @FormParam("smokingurge") int smokingUrge,
                                 @FormParam("didyousmoke") boolean didYouSmoke) {
        var vitalSign = new VitalSign(energy, smokingUrge, didYouSmoke);
        var id = this.vitalSignStore.add(vitalSign);
        return Response.created(
                    UriBuilder.fromResource(WebApplicationResource.class)
                    .build("vitalsign", id.toString())
                )
                .entity(id.toString())
                .build();
    }

    @GET
    @Timed
    @Path("vitalsign")
    public Response getVitalSigns() {
        return Response.ok().entity(this.vitalSignStore.getAllVitalSigns().toString()).build();
    }
}
