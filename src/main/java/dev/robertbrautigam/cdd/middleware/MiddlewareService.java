package dev.robertbrautigam.cdd.middleware;

import dev.robertbrautigam.cdd.SystemException;

public interface MiddlewareService<REQ extends MiddlewareBaseRequest, RES extends MiddlewareBaseResponse> {
   RES call(REQ request) throws SystemException;
}


