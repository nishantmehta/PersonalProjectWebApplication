package webapp;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import webapp.VitalSign.MemoryVitalSignStore;
import webapp.config.WebApplicationConfig;
import webapp.resource.WebApplicationResource;

public class WebApplicationMain extends Application<WebApplicationConfig> {
    public static void main(String[] args) throws Exception {
        new WebApplicationMain().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<WebApplicationConfig> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/static/"));

    }

    @Override
    public void run(WebApplicationConfig configuration,
                    Environment environment) {
        final WebApplicationResource resource = new WebApplicationResource(new MemoryVitalSignStore());
        environment.jersey().register(resource);
        environment.healthChecks().register("template", new HealthCheck() {
            @Override
            protected Result check() throws Exception {
                return Result.healthy();
            }
        });

    }

}
