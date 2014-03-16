package de.mathema.abersicher.backend;

import de.mathema.abersicher.SystemException;

public interface BackendService<REQ extends BackendBaseRequest, RES extends BackendBaseResponse> {
   RES call(REQ request) throws SystemException;
}


