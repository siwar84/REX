package com.PFE.booknetwork.exception;

public enum ErrorCodes {
    PROJECT_NOT_FOUND(1000),
    PROJECT_NOT_VALID(1001),


    EQUIPE_NOT_FOUND(2000),
    EQUIPE_NOT_VALID(2001),

    DEPARTEMENT_NOT_FOUND(3000),
    DEPARTEMENT_NOT_VALID(3001),

    ACTIONCORRECTIVE_NOT_FOUND(4000),
    ACTIONCORRECTIVE_NOT_VALID(4001),

    MEMBRE_NOT_FOUND(5000),
    MEMBRE_NOT_VALID(5001),

    PROBLEMATIQUE_NOT_FOUND(6000),
    PROBLEMATIQUE_NOT_VALID(6001),

    RESPONSABLE_NOT_FOUND(7000),
    RESPONSABLE_NOT_VALID(7001),


    STATUTPROJET_NOT_FOUND(8000),
    STATUTPROJET_NOT_VALID(8001),

    ;



    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

