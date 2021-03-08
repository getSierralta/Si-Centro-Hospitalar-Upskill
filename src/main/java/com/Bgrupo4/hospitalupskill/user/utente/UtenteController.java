package com.Bgrupo4.hospitalupskill.user.utente;


import com.Bgrupo4.hospitalupskill.registration.RegistrationService;
import com.Bgrupo4.hospitalupskill.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/utente")
@RequiredArgsConstructor
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    FileService fileService;
    private final RegistrationService registrationService;

    @GetMapping(path = "{id}")
    public Optional<Utente> getUser(@PathVariable("id") Long id){
        return utenteService.getUserById(id);
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(UtenteRegistrationRequest request){
        System.out.println("inside the register");
        return utenteService.registerUtente(request);
    }

    @GetMapping(path = "/register/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping(value = "/profileutente")
    public String showProfile(){
        return "/utente/profileutente";
    }

    @GetMapping(value = "/checkinutente")
    public String showCheckIn(){
        return "/utente/check-in-utente";
    }

    @GetMapping(value = "/tracknumberutente")
    public String showTrackNumber(){
        return "/utente/tracknumberutente";
    }

    @GetMapping(value = "/getnumber")
    public String showGetNumber(){
        return "/utente/getnumber";
    }

    @GetMapping(value = "/billsutente")
    public String showBills(){
        return "/utente/bills";
    }

    @GetMapping(value = "/filesutente")
    public String showFiles(ModelMap map){
        map.put("fileList", fileService.getFiles());
        return "/utente/files";
    }

    @GetMapping(value = "/contactsutente")
    public String showContacts(){
        return "/utente/contactsutente";
    }

    @GetMapping(value = "/settings")
    public String showSettings(){
        return "/utente/settings";
    }

    @GetMapping(value = "/calendariogeralutente")
    public String showCalendar(){
        return "/utente/calendariogeralutente";
    }

    @GetMapping(value = "/calendarutente")
    public String showEvents(){
        return "/utente/calendar";
    }
}
