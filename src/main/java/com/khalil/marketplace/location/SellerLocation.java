package com.khalil.marketplace.location;

import jakarta.persistence.*;

/** Where a seller is based (used for "pickup in person" and shipping). One row per seller. */
@Entity
@Table(name = "seller_location")
public class SellerLocation {

    @Id
    private Long sellerId;

    private String street;
    private String zip;
    private String city;

    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

    protected SellerLocation() {
    }

    public Long getSellerId() { return sellerId; }
    public String getStreet() { return street; }
    public String getZip() { return zip; }
    public String getCity() { return city; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }
}
