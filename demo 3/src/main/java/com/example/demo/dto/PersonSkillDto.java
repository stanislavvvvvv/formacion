package com.example.demo.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonSkillDto {

  private String nif;

  private List<String> skills;
}
