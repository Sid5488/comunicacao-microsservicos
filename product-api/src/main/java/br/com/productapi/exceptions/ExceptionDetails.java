package br.com.productapi.exceptions;

import lombok.Data;

@Data
public class ExceptionDetails {
    private int status;
    private String message;
}
