package dataStructure;

public class Sorting 
{
//	int arr[] = new int[] {20,25,30,10,19,16,2,25,17,30};
	
//	public void bubble_sort()
//	{
//		int i,j,temp;
//		int n = arr.length;
//		
//		for(i=n-1;i>=0;i--)
//		{
//			for(j=0;j<i;j++)
//			{
//				if(arr[j]>arr[j+1])
//				{
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}
//	}
//	
//	public void selection_sort()
//	{
//		int i,j,temp;
//		
//		int min;
//		
//		for(i=0;i<arr.length;i++)
//		{
//			min =i;
//			for(j=i+1;j<arr.length-1;j++)
//			{
//				if(arr[j]<arr[min])
//					min = j;
//			}
//			if(min!=i)
//			{
//				temp = arr[i];
//				arr[i] = arr[min];
//				arr[min] = temp;
//			}
//			
//		}
//	}
//	
//	public void insert_sort()
//	{
//		int i,j,k;
//		
//		for(i=0;i<arr.length;i++)
//		{
//			k = arr[i];
//			for(j = i-1; j>=0; j--)
//			{
//				if(k>arr[j])
//					break;
//				arr[j+1] = arr[j];
//			}
//			arr[j+1] = k;
//		}
//		
//	}
//	
//	public void merge_sort(int arr[], int arr2[],int res[])
//	{
//		int i=0;
//		int j=0;
//		int tar=0;
//		while((arr[i]<arr.length)&&arr2[i]<arr2.length)
//		{
//			if(arr[i]<arr2[j])
//			{
//				res[tar] = arr[i];
//				tar++;
//				i++;
//			}
//			else if(arr2[j]<arr[i])
//			{
//				res[tar] =arr2[j];
//				tar++;
//				j++;
//			}
//			else
//			{
//				res[tar] = arr2[j];
//				tar++;
//				i++;
//				j++;
//			}
//		}
//		
//		while(i<arr.length)
//		{
//			res[tar] = arr[i];
//			tar++;
//			i++;
//		}
//		while(j<arr2.length)
//		{
//			res[tar] = arr2[j];
//			tar++;
//			j++;
//		}
//	}
	
//	public void merge_sort_ver2(int arr[], int res[], int low1, int high1, int low2, int high2)
//	{
//		int i = low1;
//		int j = low2;
//		int tar = low1;
//		
//		while((i<=high1)&&(j<=high2))
//		{
//			if(arr[i]<arr[j])
//			{
//				res[tar] = arr[i];
//				tar++;
//				i++;
//			}
//			else if(arr[j]<arr[i])
//			{
//				res[tar] = arr[j];
//				tar++;
//				j++;	
//			}
//			else
//			{
//				res[tar] = arr[j];
//				tar++;
//				i++;
//				j++;
//			}
//		}
//		
//		while(i<=high1)
//		{
//			res[tar] = arr[i];
//			tar++;
//			i++;
//		}
//		while(j<=high2)
//		{
//			res[tar] = arr[j];
//			tar++;
//			j++;
//		}
//	}
//	
//	public void copy(int arr[], int temp[],int low, int high)
//	{
//		int i = low;
//		while(i<=high)
//		{
//			arr[i] = temp[i];
//			i++;
//		}
////		for(i=low;i<high;i++)
////		{
////			arr[i] = temp[i];
////		}
//	}
//	
//	public void merge_sort1(int arr[], int low, int high)
//	{
//		int mid;
//		int temp[]= new int[arr.length];
//		if(low<high)
//		{
//			mid = (low+high)/2;
//	
//			merge_sort1(arr, low, mid);
//			merge_sort1(arr, mid+1, high);
//			
//			
//			merge_sort_ver2(arr,temp,low,mid,mid+1,high);
//			copy(arr, temp, low ,high);
//		}
//	}
	
//	public void display()
//	{
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.print("->"+arr[i]);
//		}
//	}
	
	public static int partition(int arr[], int low, int high)
	{
		int left, right, pivot, t;
		pivot = arr[low];
		left = low;
		right = high;
		
		while(left<=right)
		{
			System.out.println("hi");
			while((arr[left]<=pivot) && (left<high))
			{
				System.out.println("while1");
				left++;
			}
			while(arr[right]>pivot)
			{
				System.out.println("while2");
				right--;
			}
							
			if(left<right)
			{
				System.out.println("if");
				t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
				left++;
				right--;
			}
			else
			{
				System.out.println("else");
				left++;
			}
		}
		arr[low] = arr[right];
		System.out.println("done");
		arr[right] = pivot;
		return right;
	}
	
	public static void quickSort(int arr[], int low, int high)
	{
		int pivotLoc;
		if(low>=high)
			return;
		
		pivotLoc = partition(arr, low, high);
		quickSort(arr,low, pivotLoc-1);
		quickSort(arr,pivotLoc+1,high);
		
		
		
	}

	

	public static void main(String[] args) 
	{
//		int arr[] = new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
//		int arr2[] = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
//		int res[] = new int[arr.length+arr2.length];
		
		
		int arr[] = {20,30,25,10,19,16,2,17,30};
		Sorting s = new Sorting();
		
		
		
//		System.out.print("Given Array");
//		s.display();
//		s.bubble_sort();
//		System.out.println();
//		System.out.print("Bubble-Sort");
//		s.display();
//		s.selection_sort();
//		System.out.println();
//		System.out.print("Selecton-Sort");
//		s.display();
//		s.insert_sort();
//		System.out.println();
//		System.out.print("Insertion-Sort");
//		s.display();
//		System.out.println();
//		System.out.println();
//		s.merge_sort(arr, arr2, res);
//		s.display();
//		for(int i=0;i<res.length;i++)
//		{
//			System.out.print("->"+res[i]);
//		}
		
//		System.out.println(s.partition(arr,0,arr.length-1));
		quickSort(arr, 0, arr.length-1);
		
//		s.merge_sort1(arr, 0, 6);
		for(int i=0;i<arr.length;i++)
			
			
			{
				System.out.print("->"+arr[i]);
			}
	}
}
