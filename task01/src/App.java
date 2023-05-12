import java.io.Console;

public class App {
    private static final int LinkedList = 0;

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome.");
        Console cons = System.console();
        String message = "";
        double answer;
        String ans = "0";
        double firstNo = 0;
        double secondNo = 0;

        while (!"exit".equals(message.toLowerCase())) {

            message = cons.readLine(">");

            String[] messageArray = message.split(" ");

            answer = Double.parseDouble(ans);

            if (messageArray[0].equalsIgnoreCase("$last")) {
                firstNo = answer;

            } else {
                String firstNumber = messageArray[0];
                firstNo = Double.parseDouble(firstNumber);
            }

            if (messageArray[2].equalsIgnoreCase("$last")) {
                secondNo = answer;

            } else {
                String secondNumber = messageArray[2];
                secondNo = Double.parseDouble(secondNumber);
            }

            String ariOperations = messageArray[1];

            switch (ariOperations) {
                case "+":
                    answer = firstNo + secondNo;
                    ans = Double.toString(answer);
                    System.out.printf("This is your answer: %.2f\n", answer);
                    break;

                case "-":
                    answer = firstNo - secondNo;
                    ans = Double.toString(answer);
                    System.out.printf("This is your answer: %.2f\n", answer);
                    break;

                case "*":
                    answer = firstNo * secondNo;
                    ans = Double.toString(answer);
                    System.out.printf("This is your answer: %.2f\n", answer);
                    break;

                case "/":
                    answer = firstNo / (secondNo);
                    ans = Double.toString(answer);
                    System.out.printf("This is your answer: %.2f\n", answer);
                    break;

                default:
                    System.out.println("Your input is invalid");
                    break;
            }

        }

        System.out.println("Bye bye");

        // 1.Accepting user input
        // 2.saving the last result
        // 3. creating switch case
        // 4. create while loop for exiting

    }
}
