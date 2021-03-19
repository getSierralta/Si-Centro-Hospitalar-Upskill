package com.Bgrupo4.hospitalupskill.invoices;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class InvoiceService {

    private final RestTemplate restTemplate;
    private final UtenteRepository utenteRepository;
    private final String external = "https://serro.pt/invoices/802244746/";

    public JSONObject getInfo(String id) {
        JSONObject requestResponse = new JSONObject();
        try {
            String requestUrl = external + "info/" + id;
            InvoiceResponse invoiceResponse = restTemplate.getForObject(requestUrl, InvoiceResponse.class);
            JSONObject thisInvoice = new JSONObject();
            JSONArray invoiceSummary = new JSONArray();
            Invoice invoice = invoiceResponse.getInvoice();
            String payStatus = "paid";
            if (invoice.getPaidDate() == null) {
                payStatus = "unpaid";
            }
            requestResponse.put("id", invoice.getId() + " " + invoice.getName() + " " + invoice.getNif());
            thisInvoice.put("issuedDate", invoice.getIssuedDate());
            thisInvoice.put("status", payStatus);
            thisInvoice.put("url", invoice.getUrl());
            invoiceSummary.add(thisInvoice);
            requestResponse.put("status", "success");
            requestResponse.put("invoice", invoiceSummary);
        } catch(Exception e) {
            requestResponse.put("status", "error");
            requestResponse.put("error", "Invoice not found");
        }
        return requestResponse;
    }

    public ModelAndView getInvoice(String id) {
        URL requestUrl = null;
        try {
            requestUrl = new URL(external + "get/" + id);
        } catch (Exception e) {
            JSONObject requestResponse = new JSONObject();
            requestResponse.put("status", "error");
            requestResponse.put("error", "Invoice not found");
        }
        return new ModelAndView("redirect:" + requestUrl);
    }

    public ModelAndView payInvoice(String id) {
        String requestUrl = external + "pay/" + id;
        return new ModelAndView(requestUrl);
    }

    public JSONObject createInvoice(Invoice invoice) {
        Optional<Utente> utente = utenteRepository.findById(Long.parseLong(invoice.getNif()));
        String date = invoice.getDueDate();
        try {
            invoice.setName(utente.get().getName());
            invoice.setEmail(utente.get().getEmail());
            invoice.setDueDate(date + "T00:00Z");
        } catch (NoSuchElementException e) {
            System.out.println("Check if this utentes info is missing (NoSuchElementException)");
        }
        return postInvoice(invoice);
    }

    public JSONObject postInvoice(Invoice invoiceParam) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject invoiceRequest = new JSONObject();
        JSONArray allItems = new JSONArray();
        invoiceRequest.put("name", invoiceParam.getName());
        invoiceRequest.put("email", invoiceParam.getEmail());
        invoiceRequest.put("nif", invoiceParam.getNif());
        invoiceRequest.put("dueDate", invoiceParam.getDueDate());
        for (InvoiceItem item : invoiceParam.getItems()) {
            JSONObject thisItem = new JSONObject();
            thisItem.put("description", item.getDescription());
            thisItem.put("value", item.getValue());
            allItems.add(thisItem);
        }
        invoiceRequest.put("items", allItems);
        JSONObject requestResponse = new JSONObject();
        try {
            String requestUrl = external + "create";
            InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
            Invoice invoice = response.getInvoice();
            JSONArray invoiceSummary = new JSONArray();
            JSONObject thisInvoice = new JSONObject();
            String payStatus = "paid";
            if (invoice.getPaidDate() == null) {
                payStatus = "unpaid";
            }
            thisInvoice.put("id", invoice.getId() + " " + invoice.getName() + " " + invoice.getNif());
            thisInvoice.put("issuedDate", invoice.getIssuedDate());
            thisInvoice.put("status", payStatus);
            thisInvoice.put("url", invoice.getUrl());
            invoiceSummary.add(thisInvoice);
            requestResponse.put("status", "success");
            requestResponse.put("invoice", invoiceSummary);
        } catch(HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            requestResponse.put("status", "error");
            requestResponse.put("error", "validationError");
        } catch (HttpClientErrorException.NotFound e) {
            requestResponse.put("status", "error");
            requestResponse.put("error", "Company with that nif not found");
        }
        return requestResponse;
    }

    public List<Invoice> getList(String search, String status) {
        String requestUrl = external + "list";
        if (search != null) {
            System.out.println(search);
            if (search.contains(":")) {
                String[] token = search.split(":");
                if (token.length > 0) {
                    String att = token[0];
                    String value = token[1];
                    requestUrl += "?" + att + "=" + value;
                }
            } else {
                requestUrl += "?search=" + search;
            }
        }
        if (status == null || status.isEmpty()) {
            requestUrl += "";
        } else {
            requestUrl += "&status=" + status;
        }
        ResponseEntity<InvoiceResponse> responseEntity = restTemplate.getForEntity(requestUrl, InvoiceResponse.class);
        InvoiceResponse invoiceResponse = responseEntity.getBody();
        return invoiceResponse.getInvoices();
    }
}
