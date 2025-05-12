package dataStructure;

public class BinarySearch 
{
	public int search(int arr[], int key)
	{
		int i;
		
		for(i =0; i<arr.length;i++)
		{
			if(arr[i]==key)
				return i;
		}
		return -1;
	}
	
	
	public void insert_sort(int arr[])
	{
		int i,j,k;
		
		for(i=0;i<arr.length;i++)
		{
			k = arr[i];
			for(j = i-1; j>=0; j--)
			{
				if(k>arr[j])
					break;
				arr[j+1] = arr[j];
			}
			arr[j+1] = k;
		}
		
	}
	
	//only used for sorted data;
	public int binarySearch(int arr[],int key)
	{
		int low = 0;
		int high = arr.length-1;
		int mid = (low+high)/2;
		
		while(arr[mid] !=key && low<high)
		{
			if(key<arr[mid])
				high = mid -1;
			else
				low = mid+1;
			
			mid = (low+high)/2;
		}
		if(arr[mid]==key)
			return mid;
		else
			return -1;
	}
	
	public static void main(String[] args)
	{
		
		
		BinarySearch bs = new BinarySearch();
		int arr[] = {10,40,55,65,85,25,12,19,16,90};
//		System.out.println(bs.search(arr, 25));
		bs.insert_sort(arr);
		System.out.println(bs.binarySearch(arr, 12));
	}

}
