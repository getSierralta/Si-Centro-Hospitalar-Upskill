package com.Bgrupo4.hospitalupskill.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {
    private String id;
    private String name;
    private String email;
    private String nif;
    private String dueDate;
    private String issuedDate;
    private String paidDate;
    private String value;
    private List<InvoiceItem> items;
    private String url;



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNif() {
        return nif;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public String getValue() {
        return value;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public String getUrl() {
        return url;
    }
}
