package com.khalil.marketplace.courier.hermes;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Client for the Hermes PaketShop API. Unlike DHL, Hermes only supports search by city.
 * In production this is an HTTP call and can be slow or fail; here it returns fixed data.
 */
@Component
public class HermesShopClient {

    private static final List<HermesParcelShop> SHOPS = List.of(
            new HermesParcelShop("H-1", "Kiosk am Görlitzer Park", "Wiener Str. 50, 10999 Berlin",
                    new GeoCoordinate(52.4970, 13.4370)),
            new HermesParcelShop("H-2", "Späti Schönhauser", "Schönhauser Allee 120, 10437 Berlin",
                    new GeoCoordinate(52.5390, 13.4120)),
            new HermesParcelShop("H-3", "Hermes PaketShop Ostkreuz", "Sonntagstr. 1, 10245 Berlin",
                    new GeoCoordinate(52.5030, 13.4690)));

    public List<HermesParcelShop> searchByCity(String city) {
        return SHOPS.stream()
                .filter(shop -> shop.fullAddress().endsWith(city))
                .toList();
    }
}
