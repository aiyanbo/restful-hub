package org.jmotor.restful;

import org.jmotor.restful.provider.mapper.ConstraintViolationExceptionMapper;
import org.jmotor.restful.provider.mapper.EntityNotFoundExceptionMapper;
import org.jmotor.restful.provider.mapper.NotAllowedExceptionMapper;
import org.jmotor.restful.provider.mapper.NotFoundExceptionMapper;
import org.jmotor.restful.provider.mapper.ThrowableMapper;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class RestfulhubFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(ThrowableMapper.class);
        featureContext.register(NotFoundExceptionMapper.class);
        featureContext.register(NotAllowedExceptionMapper.class);
        featureContext.register(EntityNotFoundExceptionMapper.class);
        featureContext.register(ConstraintViolationExceptionMapper.class);
        return true;
    }
}
