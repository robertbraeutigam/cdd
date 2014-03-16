package de.mathema.abersicher.backend;

public interface BackendService<REQ extends BackendBaseRequest, RES extends BackendBaseResponse> {
   RES call(REQ request) throws BackendException;
}


