package com.example.demo.rest;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Autowired
  private PersonService service;

  @ApiOperation(value = "Este método devuelve una persona")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Aqui esta la persona"),
          @ApiResponse(code = 500, message = "Error de servidor"),
          @ApiResponse(code = 404, message = "No se encuentra a la persona")
      }
      )
  @GetMapping("/list/{nif}")
  public PersonDTO findPerson(@PathVariable(name = "nif") String nif) {
    return service.getByNif(nif);
  }

  @ApiOperation(value = "Este método devuelve todas las personas")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Aqui estan las personas"),
          @ApiResponse(code = 500, message = "Error de servidor"),
          @ApiResponse(code = 404, message = "No hay nada disponible en la BBDD")
      }
      )
  @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<PersonDTO> lista() {
    return service.getPersonList();
  }

  @ApiOperation(value = "Este método guarda una persona")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Persona guardad correctamente"),
          @ApiResponse(code = 500, message = "Error de servidor")
      }
      )
  @PostMapping("/person")
  public PersonDTO savePerson(@RequestBody PersonDTO person) {
    return service.save(person);
  }
}
