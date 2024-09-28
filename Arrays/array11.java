package Arrays;
//max sum of subarray using kadanes algorithm
// time complexicity is O(n)
import java.util.*;

public class array11 {
    public static void kadanes(int a[],int n){
        int i;
        int cs=0;
        int ms = Integer.MIN_VALUE;
        for(i=0;i<n;i++){
            cs= cs + a[i];
        
        if(cs<0){
            cs=0;
        }
    
        ms = Math.max(cs,ms);
    }
        System.out.println("Maximum sum is "+ms);

    }
     public static void main(String args[]){
    int i,n;
    int a[]=new int[50];
    System.out.println("enter size of array");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("enter elements of array :");
    for(i=0;i<n;i++){
        a[i]= sc.nextInt();

    }
    
   kadanes(a,n);

    
}
}
