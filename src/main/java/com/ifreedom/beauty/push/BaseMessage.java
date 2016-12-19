package com.ifreedom.beauty.push;

/**
 * @atuhor:eavawu
 * @date:10/12/2016
 * @todo:
 */
public class BaseMessage {
    private String title;
    private String message;
    private String custom;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}
