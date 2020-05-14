package com.example.demo.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDto {

  private String nif;

  private String completeName;

  private Integer age;

  private List<String> skills;
}
