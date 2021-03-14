package com.Bgrupo4.hospitalupskill.invoices;

import java.util.List;

public class InvoiceResponse {
    public String status;
    public Invoice invoice;
    public List<Invoice> invoices;

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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
