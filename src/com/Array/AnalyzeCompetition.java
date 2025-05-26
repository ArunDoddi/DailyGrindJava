package com.Array;

import java.util.*;

public class AnalyzeCompetition {

    public static void main(String[] args) {
        String logs = "1 solve 09:00 50, 2 solve 10:00 60, 1 fail 11:00, 3 solve 13:00 40, 2 fail 14:00, 3 fail 15:00";

        System.out.println(analyzeCompetition(logs));

        for (int[] arr : analyzeCompetition(logs)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static List<int[]> analyzeCompetition(String logs) {
        Map<Integer, int[]> participantMap = new HashMap<>();
        String[] logEntries = logs.split(", ");

        for (String entry : logEntries) {
            String[] parts = entry.split(" ");
            int id = Integer.parseInt(parts[0]);
            String status = parts[1];

            // Initialize participant record if not present
            participantMap.putIfAbsent(id, new int[]{id, 0, 0, 0});

            int[] record = participantMap.get(id);

            if (status.equals("solve")) {
                int points = Integer.parseInt(parts[3]);
                record[1] += points; // total score
                record[2] += 1;      // number of solves
            } else if (status.equals("fail")) {
                record[3] += 1;      // number of fails
            }
        }

        // Convert to list and sort by total score descending
        List<int[]> resultList = new ArrayList<>(participantMap.values());
        resultList.sort((a, b) -> Integer.compare(b[1], a[1]));

        return resultList;
    }
}
