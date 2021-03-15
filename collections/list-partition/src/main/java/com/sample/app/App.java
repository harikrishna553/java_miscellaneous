package com.sample.app;

import java.util.Arrays;
import java.util.List;

import com.sample.app.util.ListUtil;

public class App {

	private static <T> void printListEle(List<List<T>> inputList, String msg) {
		if (inputList == null || inputList.isEmpty()) {
			return;
		}

		System.out.println(msg);
		System.out.println("****************************");
		for (List<T> list : inputList) {
			System.out.println(list);
		}
		System.out.println("****************************\n\n");
	}

	public static void main(String args[]) {
		List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		List<List<Integer>> partitions = ListUtil.partitionList(inputList, 3);
		printListEle(partitions, "Using plain Java code");

		partitions = ListUtil.partitionList_usingGuava(inputList, 3);
		printListEle(partitions, "Using Guava library");
		
		partitions = ListUtil.partitionList_usingApacheCommonCollections(inputList, 3);
		printListEle(partitions, "Using Apache common collection");

	}

}
