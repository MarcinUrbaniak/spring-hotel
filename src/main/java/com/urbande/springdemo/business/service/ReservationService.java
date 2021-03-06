package com.urbande.springdemo.business.service;

import com.urbande.springdemo.business.domain.RoomReservation;
import com.urbande.springdemo.data.entity.Guest;
import com.urbande.springdemo.data.entity.Reservation;
import com.urbande.springdemo.data.entity.Room;
import com.urbande.springdemo.data.repository.GuestRepository;
import com.urbande.springdemo.data.repository.ReservationRepository;
import com.urbande.springdemo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId())
                    .setRoomName(room.getRoomName())
                    .setRoomNumber(room.getRoomNumber());

            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName())
                    .setLastName(guest.getLastName())
                    .setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id: roomReservationMap.keySet()
             ) {
            roomReservations.add(roomReservationMap.get(id));
        }
        roomReservations.sort(Comparator.comparing(RoomReservation::getRoomName).thenComparing(RoomReservation::getRoomNumber));

        return roomReservations;
    }

}
