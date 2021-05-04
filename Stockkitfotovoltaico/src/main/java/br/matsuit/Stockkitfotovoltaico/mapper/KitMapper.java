package br.matsuit.Stockkitfotovoltaico.mapper;

import br.matsuit.Stockkitfotovoltaico.dto.ModuloDTO;
import br.matsuit.Stockkitfotovoltaico.entity.Modulo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KitMapper {

    KitMapper INSTANCE = Mappers.getMapper(KitMapper.class);

    Modulo toModel(ModuloDTO moduloDTO);

    ModuloDTO toDTO(Modulo modulo);
}
