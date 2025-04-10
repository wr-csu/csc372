package coursework;
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

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
    	
    	//get iterations number
    	System.out.print("Enter number of iterations: ");
    	int iterations = scnr.nextInt();
    	//make integer list
    	int[] nums = new int[iterations];
    	
    	//get user inputs for numbers list
    	for(int i = 0; i < iterations; i++) {   		
    		System.out.printf("Enter %d number(s): ", iterations - i);
    		nums[i] = scnr.nextInt();    		
    		//loop break for product of zero
    		if(nums[i] == 0) {
    			System.out.println("Product of any number and zero is always zero");
    			break;
    		}
    	} 	
        //call method
        int total = product(nums, iterations);
        
        if(iterations == 0) {total = 0;} //otherwise it prints 1 for cycle == 0
        
        System.out.println("Total: " + total);
        //close scanner
        scnr.close();        
	}
}
