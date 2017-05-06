package com.develeap.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
class BidController {
  static final private String BUY_OK="Congratulations";
  static final private String NOT_FOR_SALE="Sorry, item is not available";

  @Autowired
  private BidService bidService;

  @RequestMapping(method = RequestMethod.POST,
      value = "/buy",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public String buyArtwork(@RequestBody BuyRequest buyRequest) throws MalformedURLException {
    // [1] Call the service
    boolean success = bidService.buyArtwork(buyRequest);

    // [2] format some answer to client
    return (success? BUY_OK : NOT_FOR_SALE);
  }
}



