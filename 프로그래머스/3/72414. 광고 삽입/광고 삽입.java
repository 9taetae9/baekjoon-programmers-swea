class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSeconds = toSeconds(play_time);
        int advSeconds = toSeconds(adv_time);
        long[] total = new long[playSeconds + 2];  

       
        for (String log : logs) {
            String[] parts = log.split("-");
            int start = toSeconds(parts[0]);
            int end = toSeconds(parts[1]);
            total[start] += 1;
            total[end] -= 1;
        }

        
        for (int i = 1; i <= playSeconds; i++) {
            total[i] += total[i - 1];
        }

        
        for (int i = 1; i <= playSeconds; i++) {
            total[i] += total[i - 1];
        }

        long maxView = total[advSeconds - 1];
        int maxStart = 0;

        for (int i = advSeconds; i <= playSeconds; i++) {
            long view = total[i] - total[i - advSeconds];
            if (view > maxView) {
                maxView = view;
                maxStart = i - advSeconds + 1;
            }
        }

        return toTime(maxStart);
    }


    private int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 +
               Integer.parseInt(parts[1]) * 60 +
               Integer.parseInt(parts[2]);
    }


    private String toTime(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}