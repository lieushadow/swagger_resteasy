package cn.liuminhua.swagger.resteasy.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmh on 2017/6/6.
 */
@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class Api {

    @Path("/hello")
    @POST
    public Map<String, Object> sayHello() {
        Map<String, Object> map = new HashMap();
        map.put("name", "liuminhua");
        return map;
    }


}

