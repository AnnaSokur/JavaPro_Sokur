import java.util.Arrays;

public class TasksMain {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        boolean isPalindrome = Tasks.isPalindrome(s);
        System.out.println("Task 1 is " + isPalindrome);


        int[] nums = {1, 2, 3, 1, 5, 4, 3};
        boolean containsDuplicate = Tasks.containsDuplicate(nums);
        System.out.println("Task 2 is " + containsDuplicate);


        int[] numbers = {3, 2, 4};
        int target = 6;
        int[] result = Tasks.twoSum(nums, target);
        System.out.println("Task 2 is " + Arrays.toString(result));
    }


}
