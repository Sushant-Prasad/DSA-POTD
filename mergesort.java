public static void mergeSort(int arr[], int si,int ei){
if(si>=ei){
    return;
}
    int mid = si + (si-ei)/2;
    mergeSort(arr, si, mid);// sorting left part
    mergeSort(arr, mid+1, ei); // sorting right part
    merge(arr, si,ei,mid); // merging the array
    public static void merge(int arr[],int si,int ei, int mid){
        int temp[] = new int[ei-si+1];
        int i = si;          //iteration for left part,
        int j = mid +1;      // iteration for right part,
        int k = 0;          //iteration for temp array
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]= arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;

        }          

    }

}
public static void main(String args[]){
    int arr[]={6,3,9,5,2};
    int si =0;
    int ei = 6;
}