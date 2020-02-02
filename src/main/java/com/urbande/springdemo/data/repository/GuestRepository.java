package com.urbande.springdemo.data.repository;

import com.urbande.springdemo.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
