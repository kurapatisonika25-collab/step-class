import java.util.*;

interface Question {
    double grade(String correctAnswer, String studentAnswer, double points);
}

class MCQ implements Question {
    public double grade(String correctAnswer, String studentAnswer, double points) {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TF implements Question {
    public double grade(String correctAnswer, String studentAnswer, double points) {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class Essay implements Question {
    public double grade(String correctAnswer, String studentAnswer, double points) {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();
        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class W8PPQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ();
            } else if (type.equals("TF")) {
                question = new TF();
            } else {
                question = new Essay();
            }

            double score = question.grade(correctAnswer, studentAnswer, points);
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}