package br.inatel.cdg.service;

import br.inatel.cdg.model.CD;
import br.inatel.cdg.model.Gravadora;
import br.inatel.cdg.model.Tipo;

import java.util.ArrayList;
import java.util.List;


public class ServiceCD {


    public List<CD> getListByGravadora(List<CD> cds, Gravadora gravadora){
        List<CD> cdsByGravadora = new ArrayList<>();

        cds.stream().filter((cd ->
                        cd.getGravadora().equals(gravadora.name()))).
                forEach(cd -> cdsByGravadora.add(cd));

        return cdsByGravadora;
    }


    public List<CD> getByTipo(List<CD> cds ,
                                            Tipo tipo){
        List<CD> cdsByTipo = new ArrayList<>();

        cds.stream().filter((cd ->
                      cd.getTipo().replaceAll("\\s+", "").equals(tipo.name()))).
                forEach(cd -> cdsByTipo.add(cd));

        return cdsByTipo;
    }
}
