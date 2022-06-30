public class AverageGradesDriver {
    //The instructions were a  bit confusing, I believe that this is what was requested.
    //Sample driver utilizing the AverageGrades class.
    public static void main(String[] args) {
        AverageGrades averageGrades = new AverageGrades();
        boolean isProgramRunning = true;
        do{
            switch (averageGrades.getValidateUserMenuChoice()){
                case 1:
                    averageGrades.readValidateClassroomSize();
                    break;
                case 2:
                    averageGrades.readValidateClassGrades();
                    break;
                case 3:
                    try{
                        System.out.printf("%.2f",averageGrades.findAverage()); // this will just print our value to 2 decimal places.
                        System.out.println();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    isProgramRunning = false;
                    break;
                default:
                    throw new IllegalStateException("Invalid menu choice."); //This should never get thrown as we check to make sure it is range of the menu in the validation.
            }
        }while(isProgramRunning);
    }
}
