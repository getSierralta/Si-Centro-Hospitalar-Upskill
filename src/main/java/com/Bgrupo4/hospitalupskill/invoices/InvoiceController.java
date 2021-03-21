package com.Bgrupo4.hospitalupskill.invoices;

import com.Bgrupo4.hospitalupskill.user.utente.Utente;
import com.Bgrupo4.hospitalupskill.user.utente.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URL;
import java.util.*;

@RestController
@RequestMapping(value = "/invoices/802244746")
@AllArgsConstructor
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    UtenteService utenteService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR', 'UTENTE')")
    public ResponseEntity getInfo(@RequestParam String id) {
        return ResponseEntity.ok(invoiceService.getInfo(id));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR', 'UTENTE')")
    public String getInvoice(@RequestParam String id) {
        return invoiceService.getInvoice(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR', 'UTENTE')")
    public RedirectView createInvoice(@ModelAttribute Invoice invoice) {
        try {
            invoiceService.createInvoice(invoice);
            return new RedirectView("/employee/success");
        } catch (Exception e) {
            return new RedirectView("/employee/error");
        }
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR', 'UTENTE')")
    public ResponseEntity payInvoice(@PathVariable String id) {
        return ResponseEntity.ok(invoiceService.payInvoice(id));
    }
}