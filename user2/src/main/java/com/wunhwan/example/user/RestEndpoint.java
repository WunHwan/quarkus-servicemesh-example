package com.wunhwan.example.user;

import io.smallrye.mutiny.Uni;

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

    @GET
    @Consumes
    @Produces
    public Uni<String> name() {
        return Uni.createFrom().item("lisi");
    }

}
