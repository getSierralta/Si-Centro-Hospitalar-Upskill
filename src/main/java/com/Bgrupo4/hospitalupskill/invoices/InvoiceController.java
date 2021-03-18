package com.Bgrupo4.hospitalupskill.invoices;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import com.Bgrupo4.hospitalupskill.user.utente.controllers.UtenteManagementController;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/invoices/802244746")
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class InvoiceController {

    @Autowired
    RestTemplate restTemplate;
    UtenteService utenteService;

    // front-end > back-end
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public JSONObject processInvoice(@ModelAttribute Invoice invoice) throws ParseException {
        Optional<Utente> utente = utenteService.getUserById(Long.valueOf(invoice.getNif()));
        String date = invoice.getDueDate();
        invoice.setName(utente.get().getName());
        invoice.setEmail(utente.get().getEmail());
        invoice.setDueDate(date + "T00:00Z");
        return postInvoice(invoice);
    }
/*
    @RequestMapping(value = "/getSortedList", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public List<Invoice> getSortedList(String sort) {
        sort = "nif";
        return getList(sort);
    }
*/
    // back-end > serro.pt
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public JSONObject postInvoice(@RequestBody Invoice invoiceParam) throws ParseException {
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
            String requestUrl = "https://serro.pt/invoices/802244746/create";
            InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public ModelAndView getInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        System.out.println("IC: " + invoiceRequest);

        URL requestUrl = null;
        try {
            requestUrl = new URL("https://serro.pt/invoices/802244746/get/" + invoiceRequest.getId());
        } catch (Exception e) {
            JSONObject requestResponse = new JSONObject();
            requestResponse.put("status", "error");
            requestResponse.put("error", "Invoice not found");
            System.out.println(requestResponse);
        }
        return new ModelAndView("redirect:" + requestUrl);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public JSONObject getInfo(@RequestBody InvoiceRequest invoiceRequest) {
        JSONObject requestResponse = new JSONObject();
        try {
            String requestUrl = "https://serro.pt/invoices/802244746/info/" + invoiceRequest.getId();
            InvoiceResponse response = restTemplate.getForObject(requestUrl, InvoiceResponse.class);
            JSONObject thisInvoice = new JSONObject();
            JSONArray invoiceSummary = new JSONArray();
            Invoice invoice = response.getInvoice();
            String payStatus = "paid";
            if (invoice.getPaidDate() == null) {
                payStatus = "unpaid";
            }
            requestResponse.put("id", invoice.getId()); // add <propriedades do cliente>
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

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public void payInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        String requestUrl = "https://serro.pt/invoices/802244746/pay/" + invoiceRequest.getId();
        // this doesn't work yet
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public List<Invoice> getList(@RequestParam ("search") String search, @RequestParam ("status") String status) {
        String requestUrl = "https://serro.pt/invoices/802244746/list";

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
        List<Invoice> invoices = invoiceResponse.getInvoices();

        return invoices;
    }
}