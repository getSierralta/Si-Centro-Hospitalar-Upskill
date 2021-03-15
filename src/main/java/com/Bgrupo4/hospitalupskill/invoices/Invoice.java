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

    public void addItem(InvoiceItem invoiceItem) {
        items.add(invoiceItem);
    }

    public String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nif='" + nif + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", paidDate='" + paidDate + '\'' +
                ", value='" + value + '\'' +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
