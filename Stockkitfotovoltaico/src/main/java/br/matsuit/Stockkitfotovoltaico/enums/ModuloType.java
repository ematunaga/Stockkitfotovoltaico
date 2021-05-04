package br.matsuit.Stockkitfotovoltaico.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum ModuloType {

        MONOCRISTALINO("monocristalino"),
        POLICRISTALINO("policristalino");

        private final String description;
}
