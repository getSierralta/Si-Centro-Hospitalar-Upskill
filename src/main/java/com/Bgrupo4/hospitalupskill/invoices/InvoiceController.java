package com.Bgrupo4.hospitalupskill.invoices;

import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    public JSONObject postInvoice(@RequestBody Invoice invoiceParam) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = df.parse(invoiceParam.getDueDate());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject invoiceRequest = new JSONObject();
        JSONArray allItems = new JSONArray();
        invoiceRequest.put("name", invoiceParam.getName());
        invoiceRequest.put("email", invoiceParam.getEmail());
        invoiceRequest.put("nif", invoiceParam.getNif());
        invoiceRequest.put("duedate", date.toString());
        for (InvoiceItem item : invoiceParam.getItems()) {
            JSONObject thisItem = new JSONObject();
            thisItem.put("description", item.getDescription());
            thisItem.put("value", item.getValue());
            allItems.add(thisItem);
        }
        invoiceRequest.put("items", allItems);

        String requestUrl = "https://serro.pt/invoices/802244746/create";
        InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
        JSONObject requestResponse = new JSONObject();

        if(response == null || response.status.equals("error")) {
            if (HttpStatus.BAD_REQUEST.isError()) {
                requestResponse.put("status", "error");
                requestResponse.put("error", "validationError");
            }
            if (HttpStatus.NOT_FOUND.isError()) {
                requestResponse.put("status", "error");
                requestResponse.put("error", "Company with that nif not found");
            }
            return requestResponse;
        }

        Invoice invoice = response.getInvoice();
        JSONArray invoiceSummary = new JSONArray();
        JSONObject thisInvoice = new JSONObject();

        String payStatus = "paid";
        if (invoice.getPaidDate() == null) {
            payStatus = "unpaid";
        }

        thisInvoice.put("id", invoice.getId()); // add <propriedades do cliente>
        thisInvoice.put("issuedDate", invoice.getIssuedDate());
        thisInvoice.put("status", payStatus);
        thisInvoice.put("url", invoice.getUrl());

        invoiceSummary.add(thisInvoice);

        requestResponse.put("status", "success");
        requestResponse.put("invoice", invoiceSummary);

        return requestResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('medico:read')")
    public ModelAndView getInvoice(@RequestBody InvoiceAuth invoiceAuth) {
        URL requestUrl = null;
        try {
            requestUrl = new URL("https://serro.pt/invoices/" + invoiceAuth.getNif() + "/get/" + invoiceAuth.getId());
        } catch (Exception e) {
            JSONObject requestResponse = new JSONObject();
            requestResponse.put("status", "error");
            requestResponse.put("error", "Invoice not found");
            System.out.println(requestResponse);
        }
        return new ModelAndView("redirect:" + requestUrl);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('medico:read')")
    public void getInfo(@RequestBody InvoiceAuth invoiceAuth) {
        String requestUrl = "https://serro.pt/invoices/" + invoiceAuth.getNif() + "/get/" + invoiceAuth.getId();
        JSONObject requestResponse = new JSONObject();

        // UNDER CONSTRUCTION
            Invoice response = restTemplate.getForObject(requestUrl, Invoice.class);
            JSONObject thisInvoice = new JSONObject();
            JSONArray invoiceSummary = new JSONArray();

            String payStatus = "paid";
            if (response.getPaidDate() == null) {
                payStatus = "unpaid";
            }

            requestResponse.put("id", response.getId()); // add <propriedades do cliente>
            thisInvoice.put("issuedDate", response.getIssuedDate());
            thisInvoice.put("status", payStatus);
            thisInvoice.put("url", response.getUrl());

            invoiceSummary.add(thisInvoice);

            requestResponse.put("status", "success");
            requestResponse.put("invoice", invoiceSummary);
        // THIS IS MADNESS

    }

}
