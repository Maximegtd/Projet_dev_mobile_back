package com.formation.park.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "park")
public class Park implements Serializable {
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((grp_nom == null) ? 0 : grp_nom.hashCode());
    result = prime * result + ((grp_disponible == null) ? 0 : grp_disponible.hashCode());
    long temp;
    temp = Double.doubleToLongBits(lattitude);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(longitude);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((recordId == null) ? 0 : recordId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Park other = (Park) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (grp_nom == null) {
      if (other.grp_nom != null)
        return false;
    } else if (!grp_nom.equals(other.grp_nom))
      return false;
    if (grp_disponible == null) {
      if (other.grp_disponible != null)
        return false;
    } else if (!grp_disponible.equals(other.grp_disponible))
      return false;
    if (Double.doubleToLongBits(lattitude) != Double.doubleToLongBits(other.lattitude))
      return false;
    if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
      return false;
    if (recordId == null) {
      if (other.recordId != null)
        return false;
    } else if (!recordId.equals(other.recordId))
      return false;
    return true;
  }

  private static final long serialVersionUID = -767070904974486421L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String grp_nom;
  private Integer grp_disponible;
  private double lattitude;
  private double longitude;
  private String recordId;
}