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
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public ResponseEntity getInfo(@RequestParam String id) {
        return ResponseEntity.ok(invoiceService.getInfo(id));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public ResponseEntity getInvoice(@RequestParam String id) {
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public ResponseEntity createInvoice(@ModelAttribute Invoice invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public List<Invoice> getList(@RequestParam ("search") String search, @RequestParam ("status") String status) {
        return invoiceService.getList(search, status);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public void payInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        String requestUrl = "https://serro.pt/invoices/802244746/pay/" + invoiceRequest.getId();
        // this doesn't work yet
    }
}