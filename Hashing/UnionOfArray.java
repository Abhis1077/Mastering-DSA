import java.util.HashSet;

public class UnionOfArray {
    
    public static void UniArr(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        
        for (int ele : set) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        int arr1[] = {7,6,8};
        int arr2[] = {1,2,3,7};
       
        UniArr(arr1, arr2);
    }
}
