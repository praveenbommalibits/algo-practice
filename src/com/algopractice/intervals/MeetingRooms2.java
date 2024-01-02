package com.algopractice.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }
    public static void main(String[] args) {
        MeetingRooms2 rooms = new MeetingRooms2();
        System.out.println(rooms.minMeetingRooms());

    }

    public int minMeetingRooms() {
        int ans = 1;
        List<MeetingRooms2.Interval> list = new ArrayList<>();


        list.add(new MeetingRooms2.Interval(0,8));
        list.add(new MeetingRooms2.Interval(8,10));
        list.add(new MeetingRooms2.Interval(12,15));
        list.add(new MeetingRooms2.Interval(14,18));

        if(list != null && list.size()==0)
            return 0;

        if(list.size()==1)
            return ans;

        list.sort(Comparator.comparingInt(a-> a.start));

        for (int i = 0; i <= list.size()-2; i++) {
            if(list.get(i).end > list.get(i+1).start)
                ans +=1;
        }

        return ans;

    }
}
