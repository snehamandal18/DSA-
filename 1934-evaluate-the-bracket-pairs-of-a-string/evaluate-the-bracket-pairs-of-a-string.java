class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
         HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Normal alphabet character
            if (s.charAt(i) != '(') {
                result.append(s.charAt(i));
                i++;
            }

            // Bracket pair
            else {
                i++; // skip '('

                StringBuilder temp = new StringBuilder();

                // Collect key until ')'
                while (s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }

                String key = temp.toString();

                // Use value if key exists, otherwise '?'
                result.append(map.containsKey(key) ? map.get(key) : "?");

                i++; // skip ')'
            }
        }

        return result.toString();
    }
}