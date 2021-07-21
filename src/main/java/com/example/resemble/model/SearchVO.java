package com.example.resemble.model;

public class SearchVO {
    private String id;
    private String email;
    private int page; //페이지는 왜?
    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
