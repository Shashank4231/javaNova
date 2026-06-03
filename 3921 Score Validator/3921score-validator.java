class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0, counter = 0;
        int i = 0;

        while (i < events.length && counter < 10) {
            if (events[i].equals("0") || events[i].equals("1") || events[i].equals("2")
                    || events[i].equals("3") || events[i].equals("4")
                    || events[i].equals("5") || events[i].equals("6")) {
                score += Integer.parseInt(events[i]);
            }

            if (events[i].equals("W"))
                counter++;

            if (events[i].equals("WD") || events[i].equals("NB"))
                score++;

            i++;
        }

        return new int[] { score, counter };
    }
}