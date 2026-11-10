package com.khalil.marketplace.buyer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/buyers")
class BuyerController {

    private final BuyerRepository buyers;

    BuyerController(BuyerRepository buyers) {
        this.buyers = buyers;
    }

    /** Returns the buyer's city only; the full address is personal data. */
    @GetMapping("/{buyerId}")
    BuyerView get(@PathVariable long buyerId) {
        Buyer buyer = buyers.findById(buyerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buyer " + buyerId + " not found"));
        return new BuyerView(buyer.getId(), buyer.getName(), buyer.getAddress().city());
    }

    record BuyerView(long id, String name, String city) {
    }
}
