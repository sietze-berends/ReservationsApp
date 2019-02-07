package com.capgemini.molvenohotel.ReserveringsApp.initializer;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.RoomAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Initializes rooms for molveno
 */
public class InitializeRooms {
    private List<Room> rooms = new ArrayList<>();
    public Room room1;
    public Room room2;

    public InitializeRooms() {

        rooms.add(new Room("101", "Single", 999, 1, 0, 0, 1,1, 0, true, false, true, null));
//        rooms.add(new Room("102", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("103", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("104", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("105", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("106", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("107", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("108", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("109", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("110", "Single", 999, 0, 1, 0, 2,2, 0, true, disabledFriendly, null));
//        rooms.add(new Room("111", "Double", 999, 0, 1, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("112", "Double", 999, 0, 1, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("113", "Double", 999, 2, 0, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("114", "Double", 999, 2, 0, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("115", "Double", 999, 0, 1, 0, 3,2, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("116", "Double", 999, 0, 1, 0, 3,2, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("117", "Double", 999, 0, 1, 0, 4,2, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("118", "Double", 999, 0, 1, 0, 4,4, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("119", "2x Double", 999, 1, 2, 1, 6,4, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("201", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("202", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("203", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("204", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("205", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("206", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("207", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("208", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("209", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("210", "Double", 999, 0, 1, 0, 2,2, 0, true, disabledFriendly, null));
//        rooms.add(new Room("211", "Double", 999, 0, 1, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("212", "Double", 999, 0, 1, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("213", "Double", 999, 2, 0, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("214", "Double", 999, 2, 0, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("215", "Double", 999, 0, 1, 0, 3,2, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("216", "Double", 999, 0, 1, 0, 3,2, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("217", "Double", 999, 0, 1, 0, 4,2, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("218", "2x Double", 999, 1, 2, 1, 6,4, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("219", "Double", 999, 0, 1, 0, 4,2, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("301", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("302", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("303", "Single", 999, 1, 0, 0, 1,1, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("304", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("305", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("306", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("307", "Single", 999, 1, 0, 0, 2,1, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("308", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("309", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("310", "Double", 999, 0, 1, 0, 2,2, 0, true, disabledFriendly, null));
//        rooms.add(new Room("311", "Double", 999, 0, 1, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("312", "Double", 999, 0, 1, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("313", "Double", 999, 2, 0, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("314", "Double", 999, 2, 0, 0, 2,2, 0, true, notDisabledFriendly, null));
//        rooms.add(new Room("315", "2x Double", 999, 1, 2, 1, 6,4, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("316", "Double", 999, 0, 1, 0, 3,2, 1, true, notDisabledFriendly, null));
//        rooms.add(new Room("317", "Double", 999, 0, 1, 0, 4,2, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("318", "Double", 999, 0, 1, 0, 4,2, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("319", "Double", 999, 0, 1, 0, 4,2, 2, true, notDisabledFriendly, null));
//        rooms.add(new Room("401", "Single", 999, 1, 0, 0, 1,1, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("402", "Single", 999, 1, 0, 0, 1,1, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("403", "Single", 999, 1, 0, 0, 1,1, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("404", "Single", 999, 1, 0, 0, 1,1, 1, false, notDisabledFriendly, null));
//        rooms.add(new Room("405", "Single", 999, 1, 0, 0, 2,1, 1, false, notDisabledFriendly, null));
//        rooms.add(new Room("406", "Single", 999, 1, 0, 0, 2,1, 1, false, notDisabledFriendly, null));
//        rooms.add(new Room("407", "Single", 999, 1, 0, 0, 2,1, 1, false, notDisabledFriendly, null));
//        rooms.add(new Room("408", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("409", "Single", 999, 1, 0, 0, 1,1, 0, true, disabledFriendly, null));
//        rooms.add(new Room("410", "Single", 999, 0, 1, 0, 2,2, 0, true, disabledFriendly, null));
//        rooms.add(new Room("411", "Single", 999, 0, 1, 0, 2,2, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("412", "Single", 999, 0, 1, 0, 2,2, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("413", "Single", 999, 2, 0, 0, 2,2, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("414", "Single", 999, 2, 0, 0, 2,2, 0, false, notDisabledFriendly, null));
//        rooms.add(new Room("415", "Single", 999, 0, 1, 0, 3,2, 1, false, notDisabledFriendly, null));
//        rooms.add(new Room("416", "Single", 999, 0, 1, 0, 3,2, 1, false, notDisabledFriendly, null));
//        rooms.add(new Room("417", "Single", 999, 0, 1, 0, 4,2, 2, false, notDisabledFriendly, null));
//        rooms.add(new Room("418", "Penthouse", 1313, 4, 2, 2, 10,8, 2, false, notDisabledFriendly, null));
//        rooms.add(new Room("419", "Penthouse", 1313, 4, 2, 2, 10,8, 2, false, notDisabledFriendly, null));

    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getOneRoom(int roomNumber) {
        return rooms.get(roomNumber);
    }
}