package org.jmotor.restful.response;

import org.jmotor.restful.response.status.Created;
import org.jmotor.restful.response.status.Deleted;
import org.jmotor.restful.response.status.Updated;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class Success {
    public final static Created Created = new Created();
    public final static Deleted Deleted = new Deleted();
    public final static Updated Updated = new Updated();
}
