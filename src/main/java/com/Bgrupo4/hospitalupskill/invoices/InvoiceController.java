package com.Bgrupo4.hospitalupskill.invoices;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public ResponseEntity getInfo(@RequestParam String id) {
        return ResponseEntity.ok(invoiceService.getInfo(id));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public String getInvoice(@RequestParam String id) {
        return invoiceService.getInvoice(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public RedirectView createInvoice(@ModelAttribute Invoice invoice) {
        try {
            invoiceService.createInvoice(invoice);
            return new RedirectView("/employee/success");
        } catch (Exception e) {
            return new RedirectView("/employee/error");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public List<Invoice> getList(@RequestParam ("search") String search, @RequestParam ("status") String status) {
        return invoiceService.getList(search, status);
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ADMIN', 'RESPONSAVEL', 'COLABORADOR')")
    public ResponseEntity payInvoice(@PathVariable String id) {
        return ResponseEntity.ok(invoiceService.payInvoice(id));
    }
}