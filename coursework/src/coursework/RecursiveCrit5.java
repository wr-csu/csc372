package coursework;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RecursiveCrit5 {
	//make recursive method
    public static int product(int[] nums, int cycle) {	
        //cycle variable will allow users to decide list size	
        if (cycle == 0) {
            return 1;
        }  	
        return nums[cycle - 1] * product(nums, cycle - 1);
    }  
    //try-catch method to handle errors
    public static int returnProperInt(Scanner scnr, String print) {
    	int input = 0;
    	while(true) {
    		System.out.print(print);
    		try {
    			input = scnr.nextInt();
    			break;
    		}catch (InputMismatchException e){
    			System.out.println("Invalid number entered! Please enter an integer");
    			scnr.next(); //clear scanner
    		}
    	}
		return input;	
    }  
    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);	
    	//get iterations number
    	int iterations = returnProperInt(scnr, "Enter number of iterations: ");
    	int actualInputs = 0; //count legitimate inputs
    	boolean checkZero = true;
    	//make integer list
    	int[] nums = new int[iterations];
    	
    	//get user inputs for numbers list
    	for(int i = 0; i < iterations; i++) {   		
    			nums[i] = returnProperInt(scnr, "Enter a number: ");    		
    			//loop break for product of zero
    			if(nums[i] == 0) {
    				System.out.println("Product of any number and zero is always zero");
    				checkZero = false;
    				break;
    			}
    			actualInputs++;
    	}
        //call method
    	int total = (actualInputs == 0) ? 1 : product(nums, actualInputs); 
    	if(checkZero == false) {total = 0;} //returns zero when user inputs zero into list
        System.out.println("Total: " + total);
        //close scanner
        scnr.close();        
	}
} 
