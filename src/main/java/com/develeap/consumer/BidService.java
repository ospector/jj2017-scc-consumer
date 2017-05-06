package com.develeap.consumer;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.develeap.consumer.ReservationStatus.OK;

@Service
public class BidService {

  private final RestTemplate restTemplate;
  private int port = 8090;

  BidService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public boolean buyArtwork(BuyRequest buyRequest) {
    boolean success = false;
    ReservationResponse reservationResponse = reserve(buyRequest);

    boolean reserved = reservationResponse.status==OK;
    if (reserved) {
      // do the rest of the buy stuff
      System.out.println("*** Reservation ID is " + reservationResponse.reservationId);
      success = true;
    }

    return success;
  }

  private ReservationResponse reserve(BuyRequest buyRequest) {
    // Call remote service
    ResponseEntity<ReservationResponse> response = this.restTemplate.exchange(
        RequestEntity
            .post(URI.create("http://localhost:" + port + "/reserve"))
            .contentType(MediaType.APPLICATION_JSON)
            .body(buyRequest),
        ReservationResponse.class);

    return response.getBody();
  }
}

class ReservationResponse {
  public ReservationStatus status;
  public long reservationId;
}

enum ReservationStatus {
  OK, ALREADY_RESERVED, NOT_AVAILABLE
}
