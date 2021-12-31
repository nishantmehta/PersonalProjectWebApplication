package webapp.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class WebApplicationResource {

    private final AtomicLong counter;

    public WebApplicationResource() {
        this.counter = new AtomicLong();
    }

    public WebApplicationResource(AtomicLong counter) {
        this.counter = counter;
    }

    @GET
    @Timed
    public Long sayHello() {
        return counter.incrementAndGet();
    }
}
