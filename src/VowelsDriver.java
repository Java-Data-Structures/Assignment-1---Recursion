public class VowelsDriver {
    //The instructions were a  bit confusing, I believe that this is what was requested.
    //sample driver utilizing the Vowels class.
    public static void main(String[] args) {
        Vowels vowels = new Vowels();
        boolean isProgramRunning = true;
        do{
            switch (vowels.getValidateUserMenuChoice()){
                case 1:
                    vowels.readInputString();
                    break;
                case 2:
                    try{
                        System.out.println("Number of vowels:   "+vowels.countVowels());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    isProgramRunning = false;
                    break;
                default:
                    throw new IllegalStateException("Invalid menu choice."); //This should never get thrown as we check to make sure it is range of the menu in the validation.
            }
        }while(isProgramRunning);

    }
}
