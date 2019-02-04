package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

import java.util.Objects;

/**
 * Class that models an attribute of a room, e.g. "jacuzzi" or "child friendly"
 */

public class RoomAttribute {
    private String roomAttributeId;
    private String description;

    public RoomAttribute(String attributeId, String description) {
        this.roomAttributeId = attributeId;
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoomAttribute{" +
                "roomAttributeId='" + roomAttributeId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomAttribute that = (RoomAttribute) o;
        return roomAttributeId.equals(that.roomAttributeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomAttributeId);
    }

    public String getRoomAttributeId() {
        return roomAttributeId;
    }

    public void setRoomAttributeId(String roomAttributeId) {
        this.roomAttributeId = roomAttributeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}