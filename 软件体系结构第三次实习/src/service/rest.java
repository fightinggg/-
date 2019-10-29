package service;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
@Path("/rest")
public class rest {
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "hello";
    }

    @GET
    @Path("/sendEmail")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendEmail(@QueryParam("_url") String _url, @QueryParam("_payload") String _payload) {
        return service.sendEmail(_url, _payload);
    }

    @GET
    @Path("/sendEmailBatch")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendEmailBatch(@QueryParam("_url") String _url, @QueryParam("_payload") String _payload) {
        return service.sendEmailBatch(_url, _payload);
    }

    @GET
    @Path("/validateEmailAddress")
    @Produces(MediaType.TEXT_PLAIN)
    public String validateEmailAddress(@QueryParam("_url") String _url) {
        return service.validateEmailAddress(_url);
    }
}