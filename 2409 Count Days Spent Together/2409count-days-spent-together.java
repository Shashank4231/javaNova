class Solution {
    private int toDay(String date, int[] daysInMonth) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += daysInMonth[i];
        }

        return total;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int start = Math.max(toDay(arriveAlice, daysInMonth),
                toDay(arriveBob, daysInMonth));

        int end = Math.min(toDay(leaveAlice, daysInMonth),
                toDay(leaveBob, daysInMonth));

        return Math.max(0, end - start + 1);
    }
}