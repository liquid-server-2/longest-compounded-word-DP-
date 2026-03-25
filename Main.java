import java.io.*;
import java.util.*;

class solve {
    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        // change input file name here
        Scanner sc = new Scanner(new File("Input_01.txt"));
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) list.add(s);
        }
        sc.close();

        HashSet<String> set = new HashSet<>(list);

        // Sorting in descending order of length
        Collections.sort(list, (a, b) -> b.length() - a.length());

        int max = list.isEmpty() ? 0 : list.get(0).length();

        String a1 = "", a2 = "";
        for (String w : list) {
            set.remove(w);
            if (ispossible(w, set, max)) {
                if (a1.length() == 0) a1 = w;
                else {
                    a2 = w;
                    set.add(w);
                    break;
                }
            }
            set.add(w);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Longest Compound Word: " + a1);
        System.out.println("Second Longest Compound Word: " + a2);
        System.out.println("Time taken: " + (t2 - t1) + " ms");
    }

    static boolean ispossible(String w, HashSet<String> set, int max) {
        int n = w.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - max); j < i; j++) {
                if (dp[j] && set.contains(w.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
