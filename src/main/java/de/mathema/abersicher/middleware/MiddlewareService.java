package de.mathema.abersicher.middleware;

public interface MiddlewareService<REQ extends MiddlewareBaseRequest, RES extends MiddlewareBaseResponse> {
   RES call(REQ request) throws MiddlewareException;
}


