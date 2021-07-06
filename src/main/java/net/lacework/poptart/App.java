package net.lacework.poptart;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.lacework.poptart.resource.HelloWorldResource;
import net.lacework.poptart.config.PoptartConfig;
import net.lacework.poptart.health.TemplateHealthCheck;

public class App extends Application<PoptartConfig> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "poptart";
    }

    @Override
    public void initialize(Bootstrap<PoptartConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(PoptartConfig configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
