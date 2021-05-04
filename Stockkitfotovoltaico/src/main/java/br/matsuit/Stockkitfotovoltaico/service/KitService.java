package br.matsuit.Stockkitfotovoltaico.service;


import br.matsuit.Stockkitfotovoltaico.dto.ModuloDTO;
import br.matsuit.Stockkitfotovoltaico.entity.Modulo;
import br.matsuit.Stockkitfotovoltaico.exception.KitAlreadyRegisteredException;
import br.matsuit.Stockkitfotovoltaico.exception.KitNotFoundException;
import br.matsuit.Stockkitfotovoltaico.exception.KitStockExceededException;
import br.matsuit.Stockkitfotovoltaico.mapper.KitMapper;
import br.matsuit.Stockkitfotovoltaico.repository.KitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class KitService {

    private final KitRepository kitRepository;
    private final KitMapper kitMapper = KitMapper.INSTANCE;

    public ModuloDTO createModulo(ModuloDTO moduloDTO) throws KitAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(moduloDTO.getName());
        Modulo modulo = kitMapper.toModel(moduloDTO);
        Modulo savedModulo = kitRepository.save(modulo);
        return kitMapper.toDTO(savedModulo);
    }

    public ModuloDTO findByName(String name) throws KitNotFoundException {
        Modulo foundModulo = kitRepository.findByName(name)
                .orElseThrow(() -> new KitNotFoundException(name));
        return kitMapper.toDTO(foundModulo);
    }

    public List<ModuloDTO> listAll() {
        return kitRepository.findAll()
                .stream()
                .map(kitMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws KitNotFoundException {
        verifyIfExists(id);
        kitRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws KitAlreadyRegisteredException {
        Optional<Modulo> optSavedBeer = kitRepository.findByName(name);
        if (optSavedBeer.isPresent()) {
            throw new KitAlreadyRegisteredException(name);
        }
    }

    private Modulo verifyIfExists(Long id) throws KitNotFoundException {
        return kitRepository.findById(id)
                .orElseThrow(() -> new KitNotFoundException(id));
    }

    public ModuloDTO increment(Long id, int quantityToIncrement) throws KitNotFoundException, KitStockExceededException {
        Modulo beerToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() + quantityToIncrement);
            Modulo incrementedBeerStock = kitRepository.save(beerToIncrementStock);
            return kitMapper.toDTO(incrementedBeerStock);
        }
        throw new KitStockExceededException(id, quantityToIncrement);
    }
}
