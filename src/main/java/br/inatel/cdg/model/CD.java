package br.inatel.cdg.model;

import lombok.Data;

@Data
public class CD {

    private int ordem;
    private String album;
    private int ano;
    private String gravadora;
    private String tipo;
}
