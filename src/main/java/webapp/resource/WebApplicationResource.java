package webapp.resource;

import com.codahale.metrics.annotation.Timed;
import webapp.VitalSign.VitalSign;
import webapp.VitalSign.VitalSignStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVitalSign(VitalSignViewObject vitalSignViewObject) {
        VitalSign vitalSign = new VitalSign(vitalSignViewObject.energy(),
                vitalSignViewObject.smokingUrge(),
                vitalSignViewObject.didYouSmoke());
        UUID id = this.vitalSignStore.add(vitalSign);
        return Response.ok().entity(id).build();
    }

    @GET
    @Timed
    @Path("vitalsign")
    public Response getVitalSigns() {
        return Response.ok().entity(this.vitalSignStore.getAllVitalSigns().toString()).build();
    }

}
