package br.matsuit.Stockkitfotovoltaico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class KitAlreadyRegisteredException extends Exception{
    public KitAlreadyRegisteredException(String moduloName) {
        super(String.format("Modulo com este nome %s já foi registrado no sistema.", moduloName));
    }
    //public KitAlreadyRegisteredException(String inversorName) {
        //super(String.format("Inversor com este nome %s já foi registrado no sistema.", inversorName));
    //}
}
