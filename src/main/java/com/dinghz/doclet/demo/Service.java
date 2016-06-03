package com.dinghz.doclet.demo;

/**
 * @author craneding
 * @date 16/5/7
 */
@TransInfo(requestClass = Request.class)
public class Service implements IService {

    public Response doService(Request request) {
        System.out.println(request);

        return new Response();
    }

}
