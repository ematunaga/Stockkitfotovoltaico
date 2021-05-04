package br.matsuit.Stockkitfotovoltaico.builder;

import br.matsuit.Stockkitfotovoltaico.dto.ModuloDTO;
import br.matsuit.Stockkitfotovoltaico.enums.ModuloType;
import lombok.Builder;

@Builder
public class ModuloDTOBuilder {


    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Painel Fotovoltaico 535W - JAM72S30 - Mono - Half Cell";

    @Builder.Default
    private String brand = "JA";

    @Builder.Default
    private int max = 27;

    @Builder.Default
    private int quantity = 10;

    @Builder.Default
    private ModuloType type = ModuloType.MONOCRISTALINO;

    public ModuloDTO toModuloDTO() {
        return new ModuloDTO(id,
                name,
                brand,
                max,
                quantity,
                type);
    }
}