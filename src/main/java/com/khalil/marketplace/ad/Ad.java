package com.khalil.marketplace.ad;

import jakarta.persistence.*;

/** An ad ("Anzeige") a seller posted. */
@Entity
@Table(name = "ad")
public class Ad {

    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long priceCents;

    @Column(nullable = false)
    private long sellerId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdStatus status;

    protected Ad() {
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public long getPriceCents() { return priceCents; }
    public long getSellerId() { return sellerId; }
    public AdStatus getStatus() { return status; }
}
