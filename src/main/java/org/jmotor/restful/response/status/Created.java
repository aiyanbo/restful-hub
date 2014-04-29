package org.jmotor.restful.response.status;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class Created implements Status {
    private String uri;
    private String entity;
    private String identity;

    @Override
    public Response build(Object... parameters) {
        Created created = new Created();
        String entity = (String) parameters[1];
        String identity = String.valueOf(parameters[2]);
        String url = String.valueOf(parameters[0]) + "/" + entity + "/" + identity;
        created.setUri(url);
        created.setEntity(entity);
        created.setIdentity(identity);
        return Response.status(Response.Status.CREATED).entity(created).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
