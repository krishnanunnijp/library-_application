package com.university.library.entity;

import java.time.LocalDateTime;

import com.university.library.model.ReservationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservations")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Book book;

    @ManyToOne(optional = false)
    private LibraryMember member;

    private LocalDateTime reservationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    private LocalDateTime pickupExpiryDate;

    // getters and setters
}
