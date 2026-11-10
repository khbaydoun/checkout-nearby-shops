package com.khalil.marketplace.buyer;

import jakarta.persistence.Embeddable;

/** Postal address of a buyer. Embedded into the buyer table (no own table). */
@Embeddable
public record Address(String street, String postalCode, String city) {
}
