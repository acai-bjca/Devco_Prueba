package com.devco.types;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TipoDispositivo {

    CELULAR("celular"), 
    LAPTOP("laptop"), 
    IMPRESORA("impresora"),
    TECLADO("teclado"),
    MOUSE("mouse");

    private final String value;

}
