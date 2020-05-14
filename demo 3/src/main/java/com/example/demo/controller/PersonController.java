package com.example.demo.controller;

import com.example.demo.dto.PersonDataDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.PersonSkillDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonController {

  private final static String MICRO_1_URL = "http://localhost:8080/";

  private final  static String MICRO_2_URL = "http://localhost:8088/";

  private RestTemplate restTemplate = new RestTemplate();

  @GetMapping(value = "/{nif}")
  public PersonDto getPerson(@PathVariable String nif) {
    ResponseEntity<PersonDataDto> dataDto = restTemplate.getForEntity(MICRO_1_URL + nif, PersonDataDto.class);
    ResponseEntity<PersonSkillDto> skillDto = restTemplate.getForEntity(MICRO_2_URL + nif, PersonSkillDto.class);
    PersonDataDto body = dataDto.getBody();
    PersonSkillDto body1 = skillDto.getBody();
    return PersonDto.builder().age(body.getAge()).nif(body.getNif()).skills(body1.getSkills()).completeName(body.getCompleteName()).build();

  }


}
