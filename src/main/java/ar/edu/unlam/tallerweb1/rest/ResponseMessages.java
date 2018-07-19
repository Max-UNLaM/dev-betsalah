package ar.edu.unlam.tallerweb1.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "response")
public class ResponseMessages implements ResponseApi {
    public static final String UNFORBIDDEN_TEXT = "Acceso no autorizado";

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    public ResponseMessages(){
    }

    public ResponseMessages(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
