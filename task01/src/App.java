import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final int LinkedList = 0;

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome.");

        Console cons = System.console();
        String message="";
        double answer;
        String ans="0";
        //String oldMessage;

        while (!"exit".equals(message.toLowerCase())){

            message =cons.readLine(">");
           // message = oldMessage.replaceAll("$","");
            

            if (message.contains("last")){
                message = message.replaceAll("last",ans);
            }

            //List<String> messageList = new LinkedList<>();
           String[] messageArray = message.split(" ");

            answer = Double.parseDouble(ans);

           String firstNumber=messageArray[0];
           double firstNo = Double.parseDouble(firstNumber);
           

           String ariOperations = messageArray[1];
           
           String secondNumber = messageArray[2];
           double secondNo = Double.parseDouble(secondNumber);


              switch (ariOperations){
                case "+":
                answer =firstNo + secondNo;
                ans=Double.toString(answer);
                System.out.printf("This is your answer: %.2f\n",answer);
                break;
    
                case "-":
                answer =firstNo - secondNo;
                ans=Double.toString(answer);
                System.out.printf("This is your answer: %.2f\n",answer);
                break;
    
                case"*":
                answer =firstNo * secondNo;
                ans=Double.toString(answer);
                System.out.printf("This is your answer: %.2f\n",answer);
                break;
    
                case "/":
                answer =firstNo / (secondNo);
                ans=Double.toString(answer);
                System.out.printf("This is your answer: %.2f\n",answer);
                break;
                
                default:
                System.out.println("Your input is invalid");
                break;
            }

            


        }

        System.out.println("Bye bye");

        
        //1.Accepting user input
        //2.saving the last result
        //3. creating switch case
        //4. create while loop for exiting
        
    }
}
