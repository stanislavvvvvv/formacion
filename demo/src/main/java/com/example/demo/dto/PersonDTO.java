package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDTO {

  private String nif;

  private String completeName;

  private Integer age;
}
