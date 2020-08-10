package google;

/**
Given a hotel which has 10 floors [0-9] and each floor has 26 rooms [A-Z].
You are given a sequence of rooms, where + suggests room is booked, - room is
freed.
You have to find which room is booked maximum number of times.
You may assume that the list describe a correct sequence of bookings in
chronological order;
that is, only free rooms can be booked and only booked rooms can be freeed. All
rooms are initially free.
Note that this does not mean that all rooms have to be free at the end.
In case, 2 rooms have been booked the same number of times, return the
lexographically smaller room.

You may assume:
N (length of input) is an integer within the range [1, 600]
each element of array A is a string consisting of three characters: "+" or "-";
a digit "0"-"9";
and uppercase English letter "A" - "Z", the sequence is correct.
That is every booked room was previously free and every freed room was
previously booked.
Example:
Input: ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
Output: "1A"
Explanation: 1A as it has been booked 2 times.
 */
import java.util.*;

public class MostBookedRoom {
  public static String mostBookedHotelRoom(String[] roomActivity) {
    // this is constant space, it will never be greater than 260
    HashMap<String, Integer> roomFreq = new HashMap<>();

    int min = Integer.MAX_VALUE;
    String mostBookedRoom = "";
    for (String el : roomActivity) {
      // we only keep track of booked times.
      // if a booking activity
      if (el.charAt(0) == '+') {
        String room = el.substring(1);
        int freq = roomFreq.getOrDefault(room, 0) + 1;
        roomFreq.put(room, freq);
        if (freq < min) {
          min = freq;
          mostBookedRoom = room;
        } else if (freq == min) {
          mostBookedRoom = compareRoom(mostBookedRoom, room);
        }
      }
    }
    return mostBookedRoom;
  }

  private static String compareRoom(String room1, String room2) {
    // when room 1 is smaller
    if (room1.compareTo(room2) <= 0) {
      return room1;
    }
    return room2;
  }

  public static void main(String[] args) {
    String[] books1 = { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+1A", "-1A", "+1A" };
		String[] books2 = {"+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+1E", "-1E","+2A", "-2A", "+2A", "-2A", "+2A", "-2A", "+2A", 
				"-2A","+2B", "-2B", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B"};
		System.out.println(MostBookedRoom.mostBookedHotelRoom(books1)); //1A
		System.out.println(MostBookedRoom.mostBookedHotelRoom(books2)); //1B
  }
}
/**

{ 1A : 2, 3E: 1, 4F: 1 }
// go through the rooms and add the frequency of their of their bookings to a
map
// keep track of the smaller room
 */