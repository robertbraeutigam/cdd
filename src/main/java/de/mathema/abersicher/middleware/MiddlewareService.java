package de.mathema.abersicher.middleware;

import de.mathema.abersicher.SystemException;

public interface MiddlewareService<REQ extends MiddlewareBaseRequest, RES extends MiddlewareBaseResponse> {
   RES call(REQ request) throws SystemException;
}


