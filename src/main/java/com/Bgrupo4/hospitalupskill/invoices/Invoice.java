package com.Bgrupo4.hospitalupskill.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
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

    public String getDueDateS() {
        String[] split = dueDate.split("T");
        return split[0];
    }

    public String getIssuedDateS() {
        String[] split = issuedDate.split("T");
        return split[0];
    }

    public String getPaidDateS() {
        String[] split = paidDate.split("T");
        return split[0];
    }
}
