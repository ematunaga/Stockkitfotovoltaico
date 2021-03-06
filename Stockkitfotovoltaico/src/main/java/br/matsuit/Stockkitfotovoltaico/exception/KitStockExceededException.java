package br.matsuit.Stockkitfotovoltaico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class KitStockExceededException extends Exception {

    public KitStockExceededException(Long id, int quantityToIncrement) {
        super(String.format("Modulos with %s ID to increment informed exceeds the max stock capacity: %s", id, quantityToIncrement));
    }
}