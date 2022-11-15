package com.formation.velo.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataNantesClient {

  @GET("/api/records/1.0/search/?dataset=244400404_parkings-publics-nantes-disponibilites&q=&facet=grp_nom&facet=grp_statut&&rows=126")
  Call<OpenDataVeloNantes> getRecords();
}
