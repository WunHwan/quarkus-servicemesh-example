package com.wunhwan.example.app;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

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
@RegisterRestClient(configKey = "user-api")
public interface UserRestClient {

    @GET
    @Consumes
    @Produces
    Uni<String> name();

}
