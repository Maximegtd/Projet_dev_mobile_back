package com.formation.velo.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Field {
  private int available_bike_stand;
  private int bike_stand;
  private int available_bikes;
  private int number;
  private String name;
  private String adress;
  private String status;
  private double[] position;

  private int grpDisponible;

  private String grpNom;

  private double[] location;
}
