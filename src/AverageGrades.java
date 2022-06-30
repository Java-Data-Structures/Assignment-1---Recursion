import java.util.Scanner;

public class AverageGrades {

    private int storedClassSize; //the user entered class size
    private Integer[] storedGrades; // an array of user entered grades.

    /**
     * This method will print the menu for the user.
     * This method should be called every time an action is completed (besides exit program).
     */
    public void printMenu() {
        System.out.println("\n---------MAIN MENU---------");
        System.out.println("1. Read class size");
        System.out.println("2. Read class grades");
        System.out.println("3. Compute class average");
        System.out.println("4. Exit program\n");
        System.out.print("Enter option number: ");
    }

    /**
     * This method gets and validates user input for classroom size.
     */
    public void readValidateClassroomSize(){
        boolean isClassroomSizeValid = false;
        while(!isClassroomSizeValid){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please input classroom size: ");
            try{
                storedClassSize = Integer.parseInt(sc.nextLine());
                isClassroomSizeValid = true;
            }catch (NumberFormatException e){
                System.out.println("Invalid input, please enter an integer.");
            }
        }
    }

    /**
     * What this method does is that it gets the grades for every person,validates it, and then makes it into an Array of Integers
     * which is then stored in the class for later.
     */
    public void readValidateClassGrades(){
        boolean isClassroomGradesValid = false;
        while(!isClassroomGradesValid){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the grades for each person in the class, separated by a space.");
            String[] tempArray = sc.nextLine().split(" "); //a little bit of a bad algorithm, but there is no space complexity limit here.
            if(tempArray.length != storedClassSize){ //exception handling to catch if the amount of grades is not equal to the size the classroom is (since we were asked to initialize the array based on the class size.)
                System.out.println("The amount of grades is different than classroom size!!");
                return;
            }
            storedGrades = new Integer[storedClassSize];
            for(int i =0;i< tempArray.length;i++){
                try{
                    storedGrades[i] = Integer.parseInt(tempArray[i]);
                    if(storedGrades[i] < 0 || storedGrades[i] > 100){
                        System.out.println("Please enter grades between 0-100");
                        break;
                    }
                    if(i == tempArray.length - 1 ){ //if we made it to the last cell with no problems, then the input is valid.
                        isClassroomGradesValid = true;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid input, please enter the grades in the correct format.");
                }
            }
        }
    }

    /**
     * This is a helper method that just prints out the entered class size and grades and then calls the actual recursive method.
     */
    public double findAverage()throws Exception{
        if(storedClassSize == 0 || storedGrades == null) throw new Exception("You cannot find the average without giving more information"); //Exception handling for the average grades.
        System.out.println("You entered class size:    "+storedClassSize);
        System.out.print("You entered grades:        ");
        for(Integer x: storedGrades){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.print("Class average:             ");
        return ((double)findAverage(storedGrades,0,0)/storedClassSize);
    }

    /**
     * This is a recursive method that gets the raw total of all the grades and then returns to the helper method in order
     * to divide by the class size (find the average).
     */
    private int findAverage(Integer[] array,int indexPos, int totalRawGrade){
        if(indexPos == array.length){
            return totalRawGrade;
        }else{
            totalRawGrade += array[indexPos];
            return findAverage(array,++indexPos,totalRawGrade);
        }
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
                if(userMenuChoice <= 0 || userMenuChoice > 4){ //make sure that the number that we want is between 1-3.
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
