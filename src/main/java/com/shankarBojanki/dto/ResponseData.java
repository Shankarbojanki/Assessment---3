package com.shankarBojanki.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {

    private boolean status;
    private List<String> messages = new ArrayList<>();
    private Object data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
