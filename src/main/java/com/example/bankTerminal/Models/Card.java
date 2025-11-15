package com.example.bankTerminal.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private static final long MIN_CARD_NUMBER = 100000000L;
    private static final long MAX_CARD_NUMBER = 999999999L;

    @Column(nullable = false, unique = true)
    private long cardNumber;

    @Column(nullable = false)
    private String cardType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private int pinCode;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private int ccv;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Card() {
        // пустой конструктор
    }

    public Card(String cardType, User user, LocalDate expiryDate) {
        this.cardType = cardType;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    @PrePersist
    private void onCreate() {
        createdAt = LocalDateTime.now();

        if (cardNumber == 0) {
            cardNumber = ThreadLocalRandom.current().nextLong(MIN_CARD_NUMBER, MAX_CARD_NUMBER + 1);
        }

        // Генерация 4-значного PIN
        pinCode = ThreadLocalRandom.current().nextInt(1000, 10000);

        // Генерация 3-значного CCV
        ccv = ThreadLocalRandom.current().nextInt(100, 1000);
    }

    // Геттеры и сеттеры

    public long getId() {
        return id;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPinCode() {
        return pinCode;
    }

    public int getCcv() {
        return ccv;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
