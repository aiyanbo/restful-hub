package org.jmotor.restful.header;

/**
 * Component:
 * Description:
 * Date: 14-6-27
 *
 * @author Andy Ai
 */
public interface XHeaders {
    String RATE_LIMIT = "X-RateLimit-Limit";
    String RATE_RESET = "X-RateLimit-Reset";
    String RATE_REMAINING = "X-RateLimit-Remaining";
    String TOTAL_COUNT = "X-Total-Count";
    String POLL_INTERVAL = "X-Poll-Interval";
    String RESULT_FIELDS = "X-Result-Fields";
    String EXPANSION_FIELDS = "X-Expansion-Fields";
}
