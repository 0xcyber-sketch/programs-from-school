package opgave01;

public class BubbleSort {

	public static void main(String[] args) {
		String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};
		
		bubbleSort(s);
		
		for (String sr : s) {
			System.out.println(sr);		}
	}
	public static void swap(String[] list, int i, int j) {
		String temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	public static void bubbleSort(String[] array) {
		for (int i = array.length -1 ; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (array[j].compareTo(array[j+1]) > 0) {
					swap(array,j, j +1);
				}
			}
		}
	}
}
