package com.develeap.consumer;

public class BuyRequest {
  public String artworkId;
  public String buyer;

  public BuyRequest(String artworkId, String buyer) {
    this.artworkId = artworkId;
    this.buyer = buyer;
  }

  public BuyRequest() {
  }
}

