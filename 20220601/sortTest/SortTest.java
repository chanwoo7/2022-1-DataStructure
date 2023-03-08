package sortTest;

import java.io.*;

public class SortTest {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\chado\\Desktop\\2022-1\\�ڷᱸ��\\20220601\\input.txt";
		
		int numN = 100000;
		//int numN = 200000;
		//int numN = 500000;
		//int numN = 1000000;
		//int numN = 2000000;
		//int numN = 5000000;
		//int numN = 10000000;
		
		long beforeTime = System.currentTimeMillis(); // �ڵ� ���� ���� �ð� �޾ƿ���
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			int numCount = 0;
			String line;
			int[] data = new int[numN];
			
			reader.readLine();
			while (numCount < numN) {
				line = reader.readLine();
				int N = Integer.parseInt(line);
				data[numCount] = N;
				numCount++;
			}
			
			BubbleSort2Test.bubbleSort(data);  // ���� ����
			//InsertionSort2Test.insertionSort(data);  // ���� ����
			//SelectionSort2Test.selectionSort(data);  // ���� ����
			//QuickSort2Test.quickSort(data);  // �� ����
			//MergeSortTest.mergeSort(data);  // ���� ����
			
//			// ���� ��� ���
//			for(int i = 0; i < numN; i++) {
//				System.out.println(data[i]);
//			}
		}
		catch (FileNotFoundException e) {System.out.println("FileNotFoundException");}
		catch (IOException e) {System.out.println("IOException");}
		        
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		double diffTime = (afterTime - beforeTime)/1000.0; // �� �ð��� �� ��� (�ʴ����� ��ȯ)
		System.out.println("�ð�����(sec) : "+ diffTime);
	}
}
