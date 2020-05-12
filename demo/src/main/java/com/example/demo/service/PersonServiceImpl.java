package com.example.demo.service;

import com.example.demo.dao.Person;
import com.example.demo.dao.PersonRepository;
import com.example.demo.dto.PersonDTO;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public PersonDTO getByNif(String nif) {
    return personRepository.findById(nif).map(p -> PersonDTO.builder().nif(p.getNif()).completeName(p.getName() + " " + p.getSurname())
        .age(ZonedDateTime.now().getYear() - p.getBirthYear()).build()).get();
  }

  @Override
  public void delete(Person person) {
    personRepository.delete(person);
  }

  @Override
  public PersonDTO save(PersonDTO person) {
    Person p = new Person();
    String[] s = person.getCompleteName().split(" ");
    p.setName(s[0]);
    p.setSurname(s[1]);
    p.setNif(person.getNif());
    p.setBirthYear(ZonedDateTime.now().getYear() - person.getAge());
    personRepository.save(p);
    return person;
  }

  @Override
  public List<PersonDTO> getPersonList() {
    List<Person> all = personRepository.findAll();
    return all.stream().map(p -> PersonDTO.builder().nif(p.getNif()).completeName(p.getName() + " " + p.getSurname())
        .age(ZonedDateTime.now().getYear() - p.getBirthYear()).build()).collect(Collectors.toList());
  }
}
