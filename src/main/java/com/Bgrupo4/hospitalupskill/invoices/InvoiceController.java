package com.Bgrupo4.hospitalupskill.invoices;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/invoices/802244746")
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class InvoiceController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('medico:read')")
    public Invoice postInvoice(@RequestBody Invoice invoiceParam) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject invoiceRequest = new JSONObject();
        JSONArray allItems = new JSONArray();
        invoiceRequest.put("name", invoiceParam.getName());
        invoiceRequest.put("email", invoiceParam.getEmail());
        invoiceRequest.put("nif", invoiceParam.getNif());
        invoiceRequest.put("duedate", invoiceParam.getDueDate()); // edit due date's clumsy date
        for (InvoiceItem item : invoiceParam.getItems()) {
            JSONObject thisItem = new JSONObject();
            thisItem.put("description", item.getDescription());
            thisItem.put("value", item.getValue());
            allItems.add(thisItem);
        }
        invoiceRequest.put("items", allItems);

        String requestUrl = "https://serro.pt/invoices/802244746/create";
        InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
        if(response == null || response.status.equals("error")) {
            System.out.println("No"); // edit responses

        }
        Invoice invoice = response.getInvoice();
        System.out.println("Yes"); // maybe take this out
        System.out.println(invoice);
        return invoice;
    }

    /*
    @RequestMapping(path = "get/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('medico:read')")
    public Optional<Invoice> getInvoice(@PathVariable("nif") String nif, @PathVariable("id") String id) {

    }
    */

}
