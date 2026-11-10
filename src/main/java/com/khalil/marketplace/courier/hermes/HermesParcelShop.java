package com.khalil.marketplace.courier.hermes;

/** A Hermes PaketShop (usually a kiosk or small shop), as returned by the Hermes API. */
public record HermesParcelShop(String shopId, String name, String fullAddress, GeoCoordinate coordinate) {
}
