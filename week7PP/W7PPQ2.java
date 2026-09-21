class Scorecard {
    private boolean[] results;
    private int answerCount;
    private int score;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
        score = 0;
    }

    void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;

            if (correct) {
                score++;
            }
        }
    }

    int getScore() {
        return score;
    }
}

public class W7PP7Q2 {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}