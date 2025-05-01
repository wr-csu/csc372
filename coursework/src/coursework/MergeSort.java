package coursework;
import java.util.ArrayList;
public class MergeSort {

	public static void mergeSort(ArrayList<Student> students) {
		int numsLength = students.size();
		if(numsLength < 2) { //length check
			return;
		}
		int mid = numsLength / 2; // set midpoint for mergeSort split
				
		ArrayList <Student> leftHalf =  new ArrayList<>(students.subList(0, mid));
		ArrayList <Student> rightHalf =  new ArrayList<>(students.subList(mid, numsLength));
		
		//recursion
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		//merge back together
		merge(students, leftHalf, rightHalf);
	}
	
	private static void merge(ArrayList<Student> students,ArrayList<Student> leftHalf, ArrayList<Student> rightHalf) {
		int leftLength = leftHalf.size();
		int rightLength = rightHalf.size();
		
		//variables for arrays positions for each array: i in left, j in right, k in original array 
		int i = 0, j = 0, k = 0;
		
		while(i < leftLength && j < rightLength) {
			if(leftHalf.get(i).getRollNo() <= rightHalf.get(j).getRollNo()) { // compare roll numbers
				students.set(k, leftHalf.get(i));
				i++;//move lefthalf's position over to next number
			}
			else {
				students.set(k, rightHalf.get(j));
				j++; //move righthalf's position over to next number
			}
			k++;//move students array position over to set the next position's number
		}
		
		//account for any remaining numbers in either side
		while(i < leftLength) {
			students.set(k, leftHalf.get(i));
			i++;
			k++;
		}
		while(j < rightLength) {
			students.set(k, rightHalf.get(j));
			j++;
			k++;
		}	
	}		
}
