package TRDZ.tasks;

import java.util.Arrays;

public class Initialization {
	public static final String[] marks = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou", "Unknown"};

	public static void main(String[] args) {
		Notebook[] laptops = generate(10000);
		boolean show=false; //Выводить ли значения масива?
		if (show) {
			System.out.println("Первичный набор:");
			for ( Notebook laptop : laptops ) {System.out.println(laptop.toString());}
			}
	//region Сортировка
		System.out.println("Производится сортировка...");
		long startTime = System.currentTimeMillis();
		for (int i=1; i<=laptops.length; i++) { //517
			for (int j=0; j<laptops.length-i; j++) {
				if (laptops[j].compare(laptops[j+1])) Switch(laptops,j,j+1);
				}
			}
		long endTime = System.currentTimeMillis();
		System.out.println("Время выполнения сортировки:"+(endTime-startTime));
	//endregion
		Integer[] arr = new Integer[10000];
		generate(arr);
		if (show) {
			System.out.println("\nОтсортированный набор:");
			for ( Notebook laptop : laptops ) {System.out.println(laptop.toString());}
			System.out.println("\nМассив: "+ Arrays.toString(arr));
			}
		System.out.println("Производится сортировка...");
		startTime = System.currentTimeMillis();
		Sort(arr);
		endTime = System.currentTimeMillis();
		System.out.println("Время выполнения сортировки:"+(endTime-startTime));
		if (show) {
			System.out.println("Массив: "+ Arrays.toString(arr));
			}
		}

	/**Модуль замены элементов любого не динамического массива местами
	 * @param List массив
	 * @param from индекс первого элемента
	 * @param to индекс второго элемента
	 * @param <TArray> тип массива
	 */
	public static<TArray> void Switch(TArray[] List, int from, int to) {
		TArray getter;
		getter=List[to];
		List[to]=List[from];
		List[from]=getter;
		}

	/**
	 * Сортировка выбором с мин и макс значением
	 * @param arr заданный масив для сортировки
	 */
	public static void Sort(Integer[] arr) {
		int start=0;
		int end=arr.length-1;
		while (start<end) {
			int min=start;
			int max=end;
			for (int i = start; i <= end; i++) {
				if (arr[i]>arr[max]) max=i;
				if (arr[i]<arr[min]) min=i;
				}
			if (max!=start) {
				Switch(arr,min,start);
				Switch(arr,max,end);
				}
			else if (min!=end) {
				Switch(arr, max, end);
				Switch(arr, min, start);
				}
			else {
				Switch(arr,min,max);
				}
			start++;
			end--;
			}
		}

	/**
	 * Создание списка случайных ноутбуков заданого количества
	 * @param total количество ноутбуков
	 * @return полученный массив
	 */
	public static Notebook[] generate(int total) {
		Notebook[] laptops = new  Notebook[total];
		for (int i=0; i<total; i++){
			laptops[i] = new Notebook(marks[(int)(Math.random()*4)], 4*(int)(1+Math.random()*4), 50*(int)(10+Math.random()*30));
			}
		return laptops;
		}

	/**
	 * Заполнение массива числами 0-9
	 * @param arr ззаданный массив
	 * @return заполненый масив
	 */
	public static Integer[] generate(Integer[] arr) {
		for (int i=0; i<arr.length; i++){
			arr[i]=(int)(Math.random()*9);
			}
		return arr;
		}

	}
