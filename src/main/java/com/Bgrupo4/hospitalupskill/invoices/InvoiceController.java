package com.Bgrupo4.hospitalupskill.invoices;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping(value = "/invoices/802244746")
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class InvoiceController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Invoice postInvoice(@RequestBody String name, String email, String nif/*, ISO8601DateFormat dueDate, List<InvoiceItem> items*/) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject invoiceRequest = new JSONObject();
        invoiceRequest.put("name", name);
        invoiceRequest.put("email", email);
        invoiceRequest.put("nif", nif);

        /*
        invoiceRequest.put("duedate", dueDate);
        invoiceRequest.put("items", items);
        for (InvoiceItem item : items) {
            invoiceRequest.put("description", item.getDescription());
            invoiceRequest.put("value", item.getValue());
        } */

        String requestUrl = "https://serro.pt/invoices/802244746/create";
        InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
        if(response == null || response.status.equals("error")) {
            System.out.println("No");

        }
        Invoice invoice = response.getInvoice();
        System.out.println("Yes");
        System.out.println(invoice);
        return invoice;
    }
}
