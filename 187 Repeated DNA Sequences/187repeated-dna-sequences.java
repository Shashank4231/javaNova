class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> freq = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sequence = s.substring(i, i + 10);

            freq.put(sequence, freq.getOrDefault(sequence, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}