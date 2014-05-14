package org.jmotor.restful.response.status;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class Created implements Status {
    private String uri;
    private String identity;
    private Date createdAt;

    /**
     * Build response
     *
     * @param parameters [0]: base uri
     *                   [1]: identity
     * @return response entity
     */
    @Override
    public Response build(Object... parameters) {
        Created created = new Created();
        String identity = String.valueOf(parameters[1]);
        String url = String.valueOf(parameters[0]) + "/" + identity;
        created.setUri(url);
        created.setIdentity(identity);
        created.setCreatedAt(new Date());
        return Response.status(Response.Status.CREATED).entity(created).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
