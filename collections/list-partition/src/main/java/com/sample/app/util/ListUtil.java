package com.sample.app.util;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.*;

import org.apache.commons.collections4.ListUtils;

import com.google.common.collect.Lists;

public class ListUtil {

	public static <T> List<List<T>> partitionList(List<T> inputList, int size) {
		List<List<T>> result = new ArrayList<>();

		if (inputList == null || inputList.isEmpty()) {
			result.add(inputList);
			return result;
		}

		if (size <= 0) {
			result.add(inputList);
			return result;
		}

		int sizeOfList = inputList.size();
		List<T> temp = new ArrayList<>();

		int step = size;
		int counter = 0;

		while (counter < sizeOfList) {
			temp.add(inputList.get(counter));
			counter++;
			step--;

			if (step == 0) {
				step = size;
				result.add(temp);
				temp = new ArrayList<>();
			}

		}

		if ((sizeOfList % size) != 0) {
			result.add(temp);
		}

		return result;
	}

	public static <T> List<List<T>> partitionList_usingGuava(List<T> inputList, int size) {
		return Lists.partition(inputList, 3);
	}

	public static <T> List<List<T>> partitionList_usingApacheCommonCollections(List<T> inputList, int size) {
		return ListUtils.partition(inputList, 3);
	}

}