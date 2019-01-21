package Basics;

public class RoomAttributes {
    private String roomAttributeId;
    private String description;

    public RoomAttributes(String attributeId, String description) {
        this.roomAttributeId = attributeId;
        this.description = description;
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