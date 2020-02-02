package com.urbande.springdemo.data.repository;

import com.urbande.springdemo.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
