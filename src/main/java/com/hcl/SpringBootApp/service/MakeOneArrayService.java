package com.hcl.SpringBootApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hcl.SpringBootApp.model.MakeOneArray;
import com.hcl.SpringBootApp.model.MakeOneArrayResponse;
@Component
public class MakeOneArrayService {

	public static MakeOneArrayResponse getOneArray(MakeOneArray makeOneArray) {
		Integer[] aray1 = makeOneArray.getArray1();
		Integer[] aray2 = makeOneArray.getArray2();
		Integer[] aray3 = makeOneArray.getArray3();
		List<Integer> value = merge(aray1, aray2, aray3);
		MakeOneArrayResponse response = new MakeOneArrayResponse();
		response.setArray(value.toArray(new Integer[value.size()]));
		return response;
	}

	private static List<Integer> merge(Integer[]... arrays) {
		List<Integer> result = new ArrayList<>();
		for (Integer[] array : arrays) {
			Collections.addAll(result, array);
		}
		Integer[] array = result.toArray(new Integer[0]);
		List<Integer> list = Arrays.asList(array);
		Set<Integer> sortedSet = new TreeSet<>(list);
		return sortedSet.stream().collect(Collectors.toList());
	}

}