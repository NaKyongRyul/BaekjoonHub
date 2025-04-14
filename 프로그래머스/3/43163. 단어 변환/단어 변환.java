import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean isTargetExist = false;
        for (String word : words) {
            if (word.equals(target)) {
                isTargetExist = true;
                break;
            }
        }
        if (!isTargetExist) return 0;

        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<WordNode> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[words.length];

        queue.add(new WordNode(begin, 0));

        while (!queue.isEmpty()) {
            WordNode current = queue.poll();

            if (current.word.equals(target)) {
                return current.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!isVisit[i] && isTransform(current.word, words[i])) {
                    isVisit[i] = true;
                    queue.add(new WordNode(words[i], current.depth + 1));
                }
            }
        }

        return 0;
    }

    public boolean isTransform(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }

    class WordNode {
        String word;
        int depth;

        WordNode(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
