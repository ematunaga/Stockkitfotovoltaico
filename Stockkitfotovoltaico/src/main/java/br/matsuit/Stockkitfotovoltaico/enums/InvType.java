package br.matsuit.Stockkitfotovoltaico.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum InvType {

    MICROINVERSOR("microinversor"),
    INVERSOR("inversor");

    private final String description;
}
