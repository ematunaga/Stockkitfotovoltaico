package br.matsuit.Stockkitfotovoltaico.controller;

import br.matsuit.Stockkitfotovoltaico.dto.ModuloDTO;
import br.matsuit.Stockkitfotovoltaico.dto.QuantityDTO;
import br.matsuit.Stockkitfotovoltaico.exception.KitAlreadyRegisteredException;
import br.matsuit.Stockkitfotovoltaico.exception.KitNotFoundException;
import br.matsuit.Stockkitfotovoltaico.exception.KitStockExceededException;
import br.matsuit.Stockkitfotovoltaico.service.KitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kitphoto")
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class KitController implements KitControllerDocs {

    private final KitService kitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModuloDTO createModulo(@RequestBody @Valid ModuloDTO moduloDTO) throws KitAlreadyRegisteredException {
        return kitService.createModulo(moduloDTO);
    }

    @GetMapping("/{name}")
    public ModuloDTO findByName(@PathVariable String name) throws KitNotFoundException {
        return kitService.findByName(name);
    }

    @GetMapping
    public List<ModuloDTO> listModulos() {
        return kitService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws KitNotFoundException {
        kitService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public ModuloDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws KitNotFoundException, KitStockExceededException {
        return kitService.increment(id, quantityDTO.getQuantity());
    }
}