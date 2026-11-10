package com.khalil.marketplace.buyer;

import jakarta.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    /** Geocoded from the address when the buyer saved it. Can be null if geocoding failed. */
    private Double latitude;
    private Double longitude;

    protected Buyer() {
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
}
