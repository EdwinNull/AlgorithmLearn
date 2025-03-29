package Stimulate_Enum;

import java.util.*;

public class A787MergeSort {
    static int n;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n+1];
        for(int i = 1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        mergesort(arr,1,n);
        for(int i =1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    public static void mergesort(int arr[],int l,int r){
        if(l==r){
            return;
        }
        int mid = l+(r-l)/2;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static void merge(int arr[],int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = arr[l+i];
        }
        for(int j=0;j<n2;j++){
            R[j] = arr[mid+1+j];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
