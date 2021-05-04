package br.matsuit.Stockkitfotovoltaico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class KitNotFoundException extends Exception {

    public KitNotFoundException(String moduloName) {
        super(String.format("Modulo com este nome %s não foi encontrado no Sistema.", moduloName));
    }

    public KitNotFoundException(Long id) {
        super(String.format("Modulo com este id %s Não foi encontrado no Sistema.", id));
    }

    /*public KitNotFoundException(String inversorName) {
        super(String.format("Inversor com este nome %s não foi encontrado no Sistema.", inversorName));
    }

    public KitNotFoundException(Long id) {
        super(String.format("Inversor com este id %s Não foi encontrado no Sistema.", id));
    }*/

}