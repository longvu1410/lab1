package lap_1;

import java.util.ArrayList;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {

		int[] arr1 = this.array;

		// Xác định độ dài của mảng
		int lenght = arr1.length;
		// tạo mảng với độ dài *2
		int[] mirrorArray = new int[lenght * 2];
		// gán giá trị cho từng phẩn tử từ 0 tới length
		for (int i = 0; i < lenght; i++) {
			mirrorArray[i] = arr1[i];
		}
		// gán giá từ phần tử thứ lenght + i
		for (int i = 0; i < lenght; i++) {
			mirrorArray[lenght + i] = arr1[lenght - 1 - i];
		}

		return mirrorArray;
	}
		
	
	public int[] removeDuplicate() {
		//copy original array into new array
		int[] arr = this.array;
		//get the length of the array
		int n = arr.length;
		//creates a boolean array with false elements
		boolean[] isDuplicated = new boolean[n];
		//variable to store the new size of the array after mathcing
		int newSize = 0;
		
		// the first loop checks for duplicated elements
		for (int i = 0; i < n; i++) {
			if (!isDuplicated[i]) {
				
				//the second loop compares the current element (arr[i]) with the elements after it
				for (int j = i + 1; j < n; j++) {
					if (arr[i] == arr[j]) {
						//Mark duplicate elements by setting isDuplicated to true
						isDuplicated[j] = true;
					}
				}
				//increase the new size of the array every time a non-duplicate element is found
				newSize++;
			}
		}
		//create a new array with size newSize to store non-duplicate elements
		int[] result = new int[newSize];
		//index variable to keep tract=k of the current position in the result array
		int index = 0;
		
		//loop to 	copy non-duplicate elements into the result array
		for (int i = 0; i < n; i++) {
			if (!isDuplicated[i]) {
				result[index++] = arr[i];
			}
		}
		//
		return result;
	}

	public int[] getMissingValues() {
		int[] arr = this.array;
		int length = arr.length;

		// Tạo một ArrayList để chứa các giá trị thiếu
		ArrayList<Integer> missingValues = new ArrayList<>();

		for (int i = 0; i < length - 1; i++) {
			int current = arr[i];
			int next = arr[i + 1];

			// Tìm các giá trị thiếu giữa current và next
			for (int j = current + 1; j < next; j++) {
				missingValues.add(j);
			}
		}

		// Chuyển danh sách các giá trị thiếu thành mảng
		int[] result = new int[missingValues.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = missingValues.get(i);
		}

		return result;
	}

	public int[] fillMissingValues(int k) {
		int[] arr = this.array;
		int length = arr.length;

		// Tạo một ArrayList để chứa các giá trị đã điền và giá trị ban đầu
		ArrayList<Integer> filledValues = new ArrayList<>();

		for (int i = 0; i < length - 1; i++) {
			int current = arr[i];
			int next = arr[i + 1];

			// Thêm giá trị ban đầu vào danh sách
			filledValues.add(current);

			// Tìm và thêm các giá trị thiếu với khoảng cách k
			for (int j = current + 1; j < next; j += k) {
				filledValues.add(j);
			}
		}

		// Thêm phần tử cuối cùng của mảng vào danh sách
		filledValues.add(arr[length - 1]);

		// Chuyển danh sách các giá trị đã điền thành mảng
		int[] result = new int[filledValues.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = filledValues.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3 };
		MyArray myarray = new MyArray(input);

		int[] mirroredArray = myarray.mirror();
		for (int num : mirroredArray) {
			System.out.print(num + " ");
		}

		int[] input1 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray myArray = new MyArray(input1);

		int[] missingValues = myArray.getMissingValues();
		for (int value : missingValues) {
			System.out.println(value + " ");
		}
		
		 int[] input3 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		    MyArray myArray1 = new MyArray(input3);

		    int k = 3;
		    int[] filledValues = myArray1.fillMissingValues(k);
		    for (int value : filledValues) {
		        System.out.print(value + " ");
		    }
	}
}
