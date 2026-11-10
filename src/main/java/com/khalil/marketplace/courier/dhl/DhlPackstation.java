package com.khalil.marketplace.courier.dhl;

/** A DHL Packstation or post office, as returned by the DHL location API. */
public record DhlPackstation(String packstationId, String street, String postalCode, String city,
                             double latitude, double longitude, boolean open24h) {
}
