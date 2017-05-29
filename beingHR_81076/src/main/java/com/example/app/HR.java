package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HR implements IHRFunctions {

	public String[] employeeList(String[] listOfEmployees) {
		String sortedEmployeeList[] = new String[listOfEmployees.length];
		sortedEmployeeList = listOfEmployees;
		Arrays.sort(sortedEmployeeList);
		return sortedEmployeeList;
	}

	public String[] topPerformers(String[] listOfEmployees,
			List<int[]> parameters) {
		String topPerformers[] = new String[3];
		List<Map> global = new ArrayList();
		int out = 0;
		int count = 0;
		for (int[] empPara : parameters) {
			out = 0;
			for (int array : empPara) {
				out = out + array;
			}
			out = out / 5;
			Map map = new HashMap();
			map.put("emp", listOfEmployees[count]);
			count = count + 1;
			map.put("avg", out);
			global.add(map);

		}
		List<Map> maps = new ArrayList<Map>();
		Collections.sort(global, new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
				return (int) o2.get("avg") - (int) o1.get("avg");
			}
		});

		for (int i = 0; i < global.subList(0, 3).size(); i++) {
			topPerformers[i] = (String) global.get(i).get("emp");
		}
		return topPerformers;
	}

	public String parameterTopper(String[] listOfEmployees,
			List<int[]> parameters, String parameterType) {
		String parameterTopper = "";
		int varingParameterType = 0;
		ArrayList<Map> globalList = new ArrayList();
		int i = 0;
		int j = 0;
		String[] performanceParametersLocaVal = { "Creativity",
				"Communication", "TechnicalSkills", "PersonalHabits",
				"TakeInitiative" };
		for (String par : performanceParametersLocaVal) {
			if (par.equals(parameterType)) {
				varingParameterType = j;
			}
			j = j + 1;
		}
		for (int[] param : parameters) {
			int res = param[varingParameterType];
			Map map = new HashMap();
			map.put("score", res);
			map.put("emp", listOfEmployees[i]);
			i = i + 1;
			globalList.add(map);
		}
		Collections.sort(globalList, new Comparator<Map>() {

			@Override
			public int compare(Map o1, Map o2) {
				return (int) o2.get("score") - (int) o1.get("score");
			}

		});

		parameterTopper = (String) globalList.get(0).get("emp");
		return parameterTopper;
	}

	public String[] lazyEmployees(String[] listOfEmployees, int[] attendenceList) {

		String[] list = new String[3];
		for (int i = 0; i < attendenceList.length; i++) {
			for (int j = i + 1; j < attendenceList.length; j++) {
				if (attendenceList[i] > attendenceList[j]) {
					int temo = attendenceList[i];
					attendenceList[i] = attendenceList[j];
					attendenceList[j] = temo;
					String da = listOfEmployees[i];
					listOfEmployees[i] = listOfEmployees[j];
					listOfEmployees[j] = da;
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			list[i] = listOfEmployees[i];
		}
		return list;
	}

}
