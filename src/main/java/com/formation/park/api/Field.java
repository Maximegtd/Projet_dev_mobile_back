package com.formation.park.api;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@lombok.Data

public class Field {

  @SerializedName("grp_identifiant")
  private String grpIdentifiant;

  @SerializedName("grp_disponible")
  private int grpDisponible;

  @SerializedName("grp_nom")
  private String grpNom;

  private double[] location;

}