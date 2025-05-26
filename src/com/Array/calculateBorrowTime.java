package com.Array;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class calculateBorrowTime {
    public static void main(String[] args) {
        String booksLog = "1 borrow 09:00, 2 borrow 10:00, 1 return 12:00, 3 borrow 13:00, 2 return 15:00, 3 return 16:00";
        System.out.println(solution(booksLog));
    }

    private static List<String> solution(String booksLog) {
        Map<Integer, LocalTime> borrowMap = new HashMap<>(); // stores current borrow time
        Map<Integer, Duration> totalDurationMap = new HashMap<>(); // accumulates borrow durations

        String[] entries = booksLog.split(", ");

        for (String entry : entries) {
            String[] parts = entry.split(" ");
            int id = Integer.parseInt(parts[0]);
            String action = parts[1];
            LocalTime time = LocalTime.parse(parts[2]);

            if (action.equals("borrow")) {
                borrowMap.put(id, time);
            } else if (action.equals("return")) {
                LocalTime borrowTime = borrowMap.get(id);
                if (borrowTime != null) {
                    Duration session = Duration.between(borrowTime, time);
                    totalDurationMap.put(id, totalDurationMap.getOrDefault(id, Duration.ZERO).plus(session));
                    borrowMap.remove(id); // remove completed borrow
                }
            }
        }

        Duration maxDuration = totalDurationMap.values().stream().max(Duration :: compareTo).orElse(Duration.ZERO);

        // Format and sort results by descending total borrow time
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Duration> entry : totalDurationMap.entrySet()) {
            if(entry.getValue().equals(maxDuration)){
                long hours = entry.getValue().toHours();
                long minutes = entry.getValue().toMinutesPart();
                result.add(entry.getKey() + " " + String.format("%02d:%02d", hours, minutes));
            }
        }

        result.sort(Comparator.comparingInt(a ->
            Integer.parseInt(a.split(" ")[0]))
        );


        // Return with the longest borrow times
        return result;
    }
}
