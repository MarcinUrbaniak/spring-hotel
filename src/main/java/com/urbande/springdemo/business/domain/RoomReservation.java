package com.urbande.springdemo.business.domain;

import com.urbande.springdemo.data.entity.Room;

import java.util.Date;

public class RoomReservation {

    private long roomId;
    private long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private Date date;



    public long getRoomId() {
        return roomId;
    }

    public RoomReservation setRoomId(long roomId) {
        this.roomId = roomId;
        return this;
    }

    public long getGuestId() {
        return guestId;
    }

    public RoomReservation setGuestId(long guestId) {
        this.guestId = guestId;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public RoomReservation setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomReservation setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RoomReservation setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RoomReservation setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public RoomReservation setDate(Date date) {
        this.date = date;
        return this;
    }
}
