package dev.robertbrautigam.cdd.backend;

import dev.robertbrautigam.cdd.SystemException;

public interface BackendService<REQ extends BackendBaseRequest, RES extends BackendBaseResponse> {
   RES call(REQ request) throws SystemException;
}


