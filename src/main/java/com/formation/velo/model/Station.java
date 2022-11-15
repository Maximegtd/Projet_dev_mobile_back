package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "stations")
public class Station implements Serializable {

  private static final long serialVersionUID = -767070904974486421L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private double lattitude;
  private double longitude;
  private String status;
  private Integer bike_stands;
  private Integer available_bikes;
  private Integer available_bike_stands;
  private String recordid;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Station station = (Station) o;
    return Objects.equals(id, station.id)
        && Objects.equals(name, station.name)
        && Objects.equals(lattitude, station.lattitude)
        && Objects.equals(longitude, station.longitude)
        && Objects.equals(status, station.status)
        && Objects.equals(bike_stands, station.bike_stands)
        && Objects.equals(available_bikes, station.available_bikes)
        && Objects.equals(available_bike_stands, station.available_bike_stands)
        && Objects.equals(recordid, station.recordid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lattitude, longitude, status, bike_stands, available_bikes, available_bike_stands,
        recordid);
  }
}
