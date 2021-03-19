package com.Bgrupo4.hospitalupskill.listadeespera;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListaThread implements Runnable{

    private final ListaDeEsperaService listaDeEsperaService;

    @Override
    public void run() {
        listaDeEsperaService.activate();
    }
}
