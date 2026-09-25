class Solution {
    private String s;
    private int pos;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        pos = 0;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }

    private Set<String> parseExpression() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (pos < s.length()
                && s.charAt(pos) != ','
                && s.charAt(pos) != '}') {

            Set<String> part = parseTerm();
            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : part) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }

    private Set<String> parseTerm() {
        char c = s.charAt(pos);

        if (c == '{') {
            pos++;

            Set<String> result = new HashSet<>();

            while (true) {
                Set<String> part = parseExpression();
                result.addAll(part);

                if (s.charAt(pos) == ',') {
                    pos++; 
                } else if (s.charAt(pos) == '}') {
                    pos++; 
                    break;
                }
            }

            return result;
        }

        pos++;

        Set<String> result = new HashSet<>();
        result.add(String.valueOf(c));
        return result;
    }
}