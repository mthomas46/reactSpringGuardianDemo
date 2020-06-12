package com.example.reactSpringDemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuardianResponse {
    Guardian[] Response;
    int ErrorCode;
    int ThrottleSeconds;
    String ErrorStatus;
    String Message;


    public GuardianResponse(Guardian[] guardians, int errorCode, int throttleSeconds, String errorStatus, String message) {
        this.Response = guardians;
        ErrorCode = errorCode;
        ThrottleSeconds = throttleSeconds;
        ErrorStatus = errorStatus;
        Message = message;
    }

    public GuardianResponse() {
    }

    public Guardian[] getResponse() {
        return Response;
    }

    @JsonSetter("Response")
    public void setResponse(Guardian[] response) {
        Response = response;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    @JsonSetter("ErrorCode")
    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    public int getThrottleSeconds() {
        return ThrottleSeconds;
    }

    @JsonSetter("ThrottleSeconds")
    public void setThrottleSeconds(int throttleSeconds) {
        ThrottleSeconds = throttleSeconds;
    }

    public String getErrorStatus() {
        return ErrorStatus;
    }

    @JsonSetter("ErrorStatus")
    public void setErrorStatus(String errorStatus) {
        ErrorStatus = errorStatus;
    }

    public String getMessage() {
        return Message;
    }

    @JsonSetter("Message")
    public void setMessage(String message) {
        Message = message;
    }
    @Override
    public String toString(){
        return"this is a string";
    }
}
