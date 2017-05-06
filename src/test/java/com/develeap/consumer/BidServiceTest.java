package com.develeap.consumer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(workOffline = true, ids = "com.develeap.scc:producer:+:stubs:8090")
//@AutoConfigureStubRunner(repositoryRoot = "http://nexus.producer-company.com", ids = "com.develeap.scc:producer:+:stubs:8090")
public class BidServiceTest {

  @Test public void should_accept_attempt_to_buy_available_painting() throws Exception {
    BidService theUnit = new BidService(new RestTemplate());
    Assert.assertTrue(theUnit.buyArtwork(new BuyRequest("123", "Ben Johnson")));
  }

  @Test public void should_fail_to_buy_non_existing_painting() throws Exception {
    BidService theUnit = new BidService(new RestTemplate());
    Assert.assertFalse(theUnit.buyArtwork(new BuyRequest("no-such-painting", "Ben Johnson")));
  }
}