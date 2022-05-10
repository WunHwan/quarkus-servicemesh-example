package com.wunhwan.example.app;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * todo...
 *
 * @author wunhwantseng@gmail.com
 * @since todo...
 */
@Path("/user")
public class RestEndpoint {

    @Inject
    @RestClient
    UserRestClient userRestClient;

    @GET
    @Consumes
    @Produces
    public Uni<String> name() {
        return userRestClient.name();
    }

}
