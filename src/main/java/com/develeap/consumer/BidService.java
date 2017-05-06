package com.develeap.consumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Service
public class BidService {

  private final RestTemplate restTemplate;
  private int port = 8090;

  BidService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public boolean buyArtwork(BuyRequest buyRequest) {
    throw new NotImplementedException();
  }
}
