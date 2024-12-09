package com.ecommerce.ecommerce.Order.presenters.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PaymentDetailsDTO {
    @NotBlank
    @Size(min = 16)
    private String cardNumber;
    @NotBlank
    @Size(min = 3)
    private String CVV;
    @NotBlank
    private String expirationDate;

    public PaymentDetailsDTO(String cardNumber, String CVV, String expirationDate) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expirationDate = expirationDate;
    }

    public @NotBlank String getExpirationDate() {
        return expirationDate;
    }

    public @NotBlank @Size(min = 16) String getCardNumber() {
        return cardNumber;
    }

    public @NotBlank @Size(min = 3) String getCVV() {
        return CVV;
    }

    public void setExpirationDate(@NotBlank String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCVV(@NotBlank @Size(min = 3) String CVV) {
        this.CVV = CVV;
    }

    public void setCardNumber(@NotBlank @Size(min = 16) String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
