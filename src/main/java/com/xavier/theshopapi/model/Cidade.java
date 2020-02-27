package com.xavier.theshopapi.model;

import lombok.Getter;


public enum Cidade {

    MAPUTO("Maputo"),
    MATOLA("Matola"),
    XAI_XAI("Xai-Xai"),
    INHAMBANE("Inhambane"),
    VILANCULOS("Vilanculos"),
    CHIMOIO("Chimoio"),
    BEIRA("Beira"),
    TETE("Tete"),
    QUELIMANE("Quelimane"),
    NAMPULA("Nampula"),
    NACALA("Nacala"),
    PEMBA("Pemba"),
    LICHINGA("Lichinga");

    @Getter
    private String description;

    Cidade(String description) {
        this.description = description;
    }
}
