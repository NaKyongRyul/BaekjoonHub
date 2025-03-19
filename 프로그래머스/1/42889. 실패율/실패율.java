import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageUsers = new int[N + 2];

        for (int stage : stages) {
            stageUsers[stage]++;
        }

        List<Stage> stageList = new ArrayList<>();
        int totalPlayers = stages.length;

        for (int i = 1; i <= N; i++) {
            int users = stageUsers[i];
            double failureRate = 0.0;

            if (totalPlayers > 0) {
                failureRate = (double) users / totalPlayers;
            }

            stageList.add(new Stage(i, failureRate));
            totalPlayers -= users;
        }

        Collections.sort(stageList, (a, b) -> {
            if (Double.compare(a.failureRate, b.failureRate) == 0) {
                return Integer.compare(a.stageNumber, b.stageNumber);
            } else {
                return Double.compare(b.failureRate, a.failureRate);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNumber;
        }

        return answer;
    }

    static class Stage {
        int stageNumber;
        double failureRate;

        public Stage(int stageNumber, double failureRate) {
            this.stageNumber = stageNumber;
            this.failureRate = failureRate;
        }
    }
}
