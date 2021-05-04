package br.matsuit.Stockkitfotovoltaico.controller;

import br.matsuit.Stockkitfotovoltaico.dto.ModuloDTO;
import br.matsuit.Stockkitfotovoltaico.exception.KitAlreadyRegisteredException;
import br.matsuit.Stockkitfotovoltaico.exception.KitNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages kit stock")

public interface KitControllerDocs {

    @ApiOperation(value = "Kit creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criado com Sucesso"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    ModuloDTO createModulo(ModuloDTO moduloDTO) throws KitAlreadyRegisteredException;

    @ApiOperation(value = "Returns Modulo found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success modulo found in the system"),
            @ApiResponse(code = 404, message = "Modulo with given name not found.")
    })
    ModuloDTO findByName(@PathVariable String name) throws KitNotFoundException;

    @ApiOperation(value = "Returns a list of all modulos registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all modulos registered in the system"),
    })
    List<ModuloDTO> listModulos();

    @ApiOperation(value = "Delete a modulo found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success modulo deleted in the system"),
            @ApiResponse(code = 404, message = "Modulo with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws KitNotFoundException;
}