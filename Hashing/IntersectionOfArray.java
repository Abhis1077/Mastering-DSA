import java.util.HashSet;

public class IntersectionOfArray {
    
    public static void IntArr(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i]))
            System.out.print(arr2[i] + " ");
        }
        
        
    }



    public static void main(String[] args) {
        int arr1[] = {7,6,8};
        int arr2[] = {1,2,3,7};

        IntArr(arr1, arr2);
    }
}
