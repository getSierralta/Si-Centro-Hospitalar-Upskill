package com.Bgrupo4.hospitalupskill.invoices;

public class InvoiceResponse {
    public String status;
    public Invoice invoice;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
