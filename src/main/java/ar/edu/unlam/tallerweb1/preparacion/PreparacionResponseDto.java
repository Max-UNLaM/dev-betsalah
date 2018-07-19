package ar.edu.unlam.tallerweb1.preparacion;

import ar.edu.unlam.tallerweb1.rest.ResponseApi;

public class PreparacionResponseDto implements ResponseApi {

    @Override
    public String getMessage() {
        return "OK";
    }

    @Override
    public void setMessage(String message) {
    }

    @Override
    public String getCode() {
        return "200";
    }

    @Override
    public void setCode(String code) {

    }
}
