package com.example.demo.service;

import com.example.demo.dao.Person;
import com.example.demo.dto.PersonDTO;
import java.util.List;

public interface PersonService {

  PersonDTO getByNif(String nif);

  void delete(Person person);

  PersonDTO save(PersonDTO person);

  List<PersonDTO> getPersonList();

}
