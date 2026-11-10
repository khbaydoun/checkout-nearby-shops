package com.khalil.marketplace;

import com.khalil.marketplace.ad.AdRepository;
import com.khalil.marketplace.buyer.BuyerRepository;
import com.khalil.marketplace.location.SellerLocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/** Smoke test: the app starts and the demo data is loaded. */
@SpringBootTest
class MarketplaceApplicationTest {

    @Autowired BuyerRepository buyers;
    @Autowired AdRepository ads;
    @Autowired SellerLocationRepository sellerLocations;

    @Test
    void demoDataIsLoaded() {
        assertThat(buyers.count()).isEqualTo(3);
        assertThat(ads.count()).isEqualTo(5);
        assertThat(sellerLocations.count()).isEqualTo(2);
    }
}
