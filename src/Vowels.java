import java.util.Scanner;

public class Vowels {

    private String currentString;

    /**
     * This method will print the menu for the user.
     * This method should be called every time an action is completed (besides exit program).
     */
    public void printMenu() {
        System.out.println("\n---------MAIN MENU---------");
        System.out.println("1. Read input string");
        System.out.println("2. Compute number of vowels");
        System.out.println("3. Exit program\n");
        System.out.print("Enter option number: ");
    }

    /**
     * What this method does is that it gets in a new input string from the user and stores that result in the object
     * to be used later.
     */
    public void readInputString(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input String: ");
        currentString = sc.nextLine();
    }

    /**
     *Helper method for the recursive countVowels method that just prints out what string you entered.
     * it also initializes the vowel counter to 0.
     */
    private static int vowelCounter; //this is a static counter that is shared across all recursive stacks so that a counter does not have to be passed through.
    public int countVowels() throws Exception{
        if(currentString == null) throw new Exception("Null String, try entering an input string");
        vowelCounter = 0;
        System.out.println("You entered string: "+currentString);
        countVowels(currentString);
        return vowelCounter;
    }

    /**
     * This method first checks if the string is empty, which in that case it's work is done or the recursion will start popping off stacks.
     * Afterwards, this method will look at the last letter in the string, see if it's a vowel and will increment vowelCounter if so.
     * Finally, this method will re-run itself and remove the last character in the string which result in a slightly shorter string
     * every run.
     */
    private String countVowels(String inputString){
        inputString = inputString.toLowerCase(); // this just make it so that we do not have to add 5 more equity symbols for each vowel.
        //base condition, check to make sure that there is a string to work with.
        if(inputString.length() == 0){
            return "";
        }
        //if the first character is a vowel, increment the vowel counter.
        if(inputString.charAt(inputString.length()-1) == 'a' ||inputString.charAt(inputString.length()-1) == 'e'
                || inputString.charAt(inputString.length()-1) == 'i' || inputString.charAt(inputString.length()-1) == 'o'
                || inputString.charAt(inputString.length()-1) == 'u'){
            vowelCounter++;
        }
        //call itself, but remove the last character in the string.
        return countVowels(inputString.substring(0,inputString.length()-1));
    }

    /**
     * This method should be called whenever trying to get the user input for the menu.
     * What is does it that it gets and then validates the user input and then returns it back as an int.
     */
    public int getValidateUserMenuChoice(){
        boolean isValidInput = false;
        while(!isValidInput){
            printMenu(); //print the menu for the user every time they have to make a choice.
            Scanner sc = new Scanner(System.in);
            try{
                int userMenuChoice = Integer.parseInt(sc.nextLine());
                if(userMenuChoice <= 0 || userMenuChoice > 3){ //make sure that the number that we want is between 1-3.
                    System.out.println("Please enter a number between 1-3");
                    sleepFor500ms(); //add a small delay so that the user can actually see what's happening.
                }else{
                    return userMenuChoice; //if it's a valid number, return it back.
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input, please enter an integer.");
                sleepFor500ms();
            }
        }
        throw new IllegalStateException("Menu choice loop was broken out of.");
    }

    /**
     * This method just calls a sleep for 500 ms on the current thread.
     */
    public static void sleepFor500ms(){
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            System.out.println("Thread was interrupted.");
        }
    }
}
