package org.abondar.experimental.problems.dynamic;

import org.abondar.experimental.problems.strings.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dynamic {

    public int countWays(int n) {
        if (n < 0) return 0;

        if (n == 0) return 1;

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public int countWaysMemo(int n) {
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        return countWaysMemo(n, memo);
    }

    public int magicIndex(int[] A) {
        return magicIndex(A, 0, A.length - 1);
    }


    public List<List<Integer>> powerSet(List<Integer> set) {
        List<List<Integer>> res = new ArrayList<>();

        // makes 2^n
        Integer maxSubs = 1 << set.size();
        for (int i = 0; i < maxSubs; i++) {
            List<Integer> subset = getSubset(i, set);
            res.add(subset);
        }

        return res;
    }

    public int recursiveMult(int a, int b) {
        int bigger = a > b ? a : b;
        int smaller = a < b ? a : b;

        return multHelper(smaller, bigger);
    }

    private int multHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return bigger;


        int s = smaller >> 1;

        int halfProd = multHelper(s, bigger);

        if (smaller % 2 == 0) return halfProd + halfProd;


        return halfProd + halfProd + bigger;
    }


    public Tower[] hanoiTowers(int numDisks) {

        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = numDisks - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(numDisks, towers[2], towers[1]);

        return towers;
    }


    public boolean paintFill(Color[][] screen, int r, int c, Color newColor) {
        if (screen[r][c] == newColor) return false;
        return paintFill(screen, r, c, screen[r][c], newColor);
    }

    private boolean paintFill(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }

        if (screen[r][c] == oldColor) {
            screen[r][c] = newColor;

            paintFill(screen, r - 1, c, oldColor, newColor);
            paintFill(screen, r + 1, c, oldColor, newColor);
            paintFill(screen, r, c - 1, oldColor, newColor);
            paintFill(screen, r, c + 1, oldColor, newColor);
        }
        return true;
    }


    public List<String> maxPermutationsNoDups(String str) {
        Strings as = new Strings();
        if (!str.isEmpty() && !as.isUnique(str)) throw new RuntimeException("Chars are not unique");


        int len = str.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            res.add("");
            return res;
        }

        for (int i = 0; i < len; i++) {
            // find all perms without char i
            String before = str.substring(0, i);
            String after = str.substring(i + 1, len);
            List<String> partials = getPerms(before + after);

            //prepend i to permutation
            for (String s : partials) {
                res.add(str.charAt(i) + s);
            }
        }

        return res;
    }


    private List<String> getPerms(String s) {
        List<String> res = new ArrayList<>();
        getPerms("", s, res);
        return res;
    }

    private void getPerms(String prefix, String reminder, List<String> res) {
        if (reminder.length() == 0) res.add(prefix);

        int len = reminder.length();
        for (int i = 0; i < len; i++) {
            String before = reminder.substring(0, i);
            String after = reminder.substring(i + 1, len);
            char c = reminder.charAt(i);
            getPerms(prefix + c, before + after, res);
        }
    }


    public List<String> maxPermutationsDups(String str) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> freqs = buildFreqsMap(str);
        getPerms(freqs, "", str.length(), res);

        return res;
    }

    private void getPerms(Map<Character, Integer> freqs, String prefix, int remaining, List<String> res) {
        if (remaining == 0) {
            res.add(prefix);
            return;
        }

        freqs.forEach((c, count) -> {
            if (count > 0) {
                freqs.put(c, count - 1);
                getPerms(freqs, prefix + c, remaining - 1, res);
                freqs.put(c, count);
            }
        });

    }


    public List<String> parentheses(int pairs) {
        List<String> res = new ArrayList<>();
        char[] str = new char[pairs * 2];

        addParen(res, pairs, pairs, str, 0);

        return res;
    }


    public int coins(int n) {
        int[] denoms = {25, 10, 5, 1};

        return makeChange(n, denoms, 0);
    }

    public int boxesStack(List<Box> boxes) {
        Collections.sort(boxes);
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];

        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int createStack(List<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).compareTo(bottom) > 0) {
                int height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }

        }

        maxHeight += bottom.getHeight();
        stackMap[bottomIndex] = maxHeight;

        return maxHeight;
    }


    public int countEval(String expr, boolean res) {
        if (expr.length() == 0) return 0;
        if (expr.length() == 1) return strToBool(expr) == res ? 1 : 0;

        int ways = 0;

        for (int i = 1; i < expr.length(); i += 2) {
            char c = expr.charAt(i);
            String left = expr.substring(0, i);
            String right = expr.substring(i + 1);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;

            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }

            int subways = res ? totalTrue : total - totalTrue;
            ways += subways;
        }

        return ways;
    }

    private boolean strToBool(String expr) {
        return expr.equals("1");
    }


    private int makeChange(int amount, int[] denoms, int i) {
        if (i > denoms.length - 1) return 1;

        int denomVal = denoms[i];
        int ways = 0;

        for (int j = 0; j * denomVal <= amount; j++) {
            int amountRemaining = amount - i * denomVal;
            ways += makeChange(amountRemaining, denoms, i + 1);
        }

        return ways;
    }

    private void addParen(List<String> res, int left, int right, char[] str, int i) {
        if (left < 0 || right < left) return;

        if (left == 0 && right == 0) {
            res.add(String.copyValueOf(str));
        } else {
            str[i] = '(';
            addParen(res, left - 1, right, str, i + 1);

            str[i] = ')';
            addParen(res, left, right - 1, str, i + 1);

        }
    }


    private Map<Character, Integer> buildFreqsMap(String s) {
        Map<Character, Integer> freqsMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!freqsMap.containsKey(c)) {
                freqsMap.put(c, 0);
            }

            freqsMap.put(c, freqsMap.get(c) + 1);
        }

        return freqsMap;
    }


    private List<Integer> getSubset(int i, List<Integer> set) {
        List<Integer> subset = new ArrayList<>();
        int index = 0;

        //div j by 2
        for (int j = i; j > 0; j >>= 1) {
            // if elem is in set add it
            if ((j & 1) == 1) {
                subset.add(set.get(index));
            }

            index++;
        }
        return subset;
    }

    private int magicIndex(int[] a, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = a[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }


        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicIndex(a, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);

        return magicIndex(a, rightIndex, end);
    }

    private int countWaysMemo(int n, int[] memo) {
        if (n < 0) return 0;

        if (n == 0) return 1;

        if (memo[n] > -1) return memo[n];

        memo[n] = countWaysMemo(n - 1, memo) + countWaysMemo(n - 2, memo) + countWaysMemo(n - 3, memo);

        return memo[n];
    }

    public String countAndSay(int n) {
        if (n < 1 || n > 30) {
            return "";
        }

        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        char head = prev.charAt(0);
        int count = 0;

        for (int i = 0; i < prev.length(); i++) {
            char cur = prev.charAt(i);
            if (head == cur) {
                count++;
            } else {
                res.append(count);
                res.append(head);
                count = 1;
                head = cur;
            }
        }

        res.append(count);
        res.append(head);

        return res.toString();
    }


    public int cutRodMem(int[] data, int rodLen) {
        int[] memory = new int[rodLen + 1];

        Arrays.fill(memory, Integer.MIN_VALUE);


        return memAux(data, memory, rodLen);
    }

    private int memAux(int[] data, int[] memory, int rodLen) {
        int res = Integer.MIN_VALUE;
        ;

        if (memory[rodLen] >= 0) {
            return memory[rodLen];
        }

        if (rodLen == 0) {
            res = 0;
        } else {

            for (int i = 0; i < rodLen; i++) {
                res = Math.max(res, data[i] + memAux(data, memory, rodLen - i - 1));
            }
        }

        memory[rodLen] = res;

        return res;
    }

    public int cutRodBottomUp(int[] data, int rodLen) {
        int[] memory = new int[rodLen + 1];

        memory[0] = 0;

        for (int i = 1; i <= rodLen; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, data[j] + memory[i - j - 1]);
            }
            memory[i] = max;
        }

        return memory[rodLen];
    }


    public int matrixChainMultOrder(int[] chain) {
        int[][] memory = new int[chain.length][chain.length];

        for (int chainLen = 2; chainLen < chain.length; chainLen++) {
            for (int i = 1; i < chain.length - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                if (j == chain.length) {
                    continue;
                }
                memory[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = memory[i][k] + memory[k + 1][j] + chain[i - 1] * chain[k] * chain[j];
                    if (cost < memory[i][j]) {
                        memory[i][j] = cost;
                    }
                }
            }
        }

        return memory[1][chain.length - 1];
    }

    public int longestCommonSubsequenceLen(String s1, String s2) {
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        int[][] len = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    len[i][j] = 0;
                } else if (s1c[i - 1] == s2c[j - 1]) {
                    len[i][j] = len[i - 1][j - 1] + 1;
                } else {
                    len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
                }
            }
        }

        return len[s1.length()][s2.length()];
    }

    ;
}
