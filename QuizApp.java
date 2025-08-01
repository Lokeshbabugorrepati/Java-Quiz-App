import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctOption;

    public Question(String questionText, String[] options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        char opt = 'A';
        for (String option : options) {
            System.out.println(opt + ". " + option);
            opt++;
        }
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == Character.toUpperCase(correctOption);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Chennai", "Kolkata"}, 'B'));
        questions.add(new Question(
                "Which language runs in a web browser?",
                new String[]{"Java", "C", "Python", "JavaScript"}, 'D'));
        questions.add(new Question(
                "Who is the founder of Microsoft?",
                new String[]{"Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Elon Musk"}, 'A'));

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            Question q = questions.get(i);
            q.displayQuestion();

            System.out.print("Your answer (A/B/C/D): ");
            char answer = scanner.next().charAt(0);

            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.correctOption);
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());
    }
}
