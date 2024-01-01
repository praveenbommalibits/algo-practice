package com.algopractice.intervals;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MeetingRooms1 {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }
    public static void main(String[] args) {
        MeetingRooms1 rooms = new MeetingRooms1();
        System.out.println(rooms.canAttendMeetings());

    }

    public boolean canAttendMeetings() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0,8));
        list.add(new Interval(8,10));
        list.add(new Interval(12,15));
        list.add(new Interval(14,18));

        if(list == null || list.size()==0)
            return false;



        list.sort(Comparator.comparingInt(a-> a.start));


        for (int i = 0; i <= list.size()-2; i++) {
            if(list.get(i).end > list.get(i+1).start)
                return false;
        }

        return true;

    }
}
