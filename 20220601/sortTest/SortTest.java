package sortTest;

import java.io.*;

public class SortTest {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\chado\\Desktop\\2022-1\\자료구조\\20220601\\input.txt";
		
		int numN = 100000;
		//int numN = 200000;
		//int numN = 500000;
		//int numN = 1000000;
		//int numN = 2000000;
		//int numN = 5000000;
		//int numN = 10000000;
		
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		
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
			
			BubbleSort2Test.bubbleSort(data);  // 버블 정렬
			//InsertionSort2Test.insertionSort(data);  // 삽입 정렬
			//SelectionSort2Test.selectionSort(data);  // 선택 정렬
			//QuickSort2Test.quickSort(data);  // 퀵 정렬
			//MergeSortTest.mergeSort(data);  // 병합 정렬
			
//			// 정렬 결과 출력
//			for(int i = 0; i < numN; i++) {
//				System.out.println(data[i]);
//			}
		}
		catch (FileNotFoundException e) {System.out.println("FileNotFoundException");}
		catch (IOException e) {System.out.println("IOException");}
		        
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		double diffTime = (afterTime - beforeTime)/1000.0; // 두 시간의 차 계산 (초단위로 변환)
		System.out.println("시간차이(sec) : "+ diffTime);
	}
}
