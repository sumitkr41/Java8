package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String args[]) {
		
		int num[] = {20,2,4,55,8,6,9,10,23,40,50,150};
		int num1[] = {0,1,2,0,4,0,4,2,6,0,0,4,5,3,0,4,9,7,5};
		System.out.println("get max : "+getMax(num));
		System.out.println("get min : "+getMin(num));
		System.out.println("get >>> :" +sortAs(num));
		
		System.out.println("get all even : "+allEven(num));
		
		System.out.println("All nums end with 0 :" + allNumEndWithZero(num));
		
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp("Sumi", 200, "Hyd",Arrays.asList("Java","Java8","Sql")));
		empList.add(new Emp("Amit", 300, "Bang",Arrays.asList(".net","mvc","Sql")));
		empList.add(new Emp("Rani", 250, "Delh",Arrays.asList("Dba","oracle","mySql")));
		empList.add(new Emp("Swat", 190, "Bang",Arrays.asList("websphare","tomcat","Sql")));
		empList.add(new Emp("Ram", 280, "Bang",Arrays.asList("anglur","react","html")));
		empList.add(new Emp("Deep", 200, "Hyd",Arrays.asList("html","css","bootstrap")));
		
		
		System.out.println("Total Salary : "+addSalOfEmp(empList));
		System.out.println("Total Sal in Hyd :" +addSalofEmpinCity(empList,"Hyd"));
		System.out.println("Emp skills: "+ getSkillofEmp(empList));
		System.out.println("Emp sort by Salary: " );
		sortBySal(empList).stream().forEach(e -> {
			System.out.println(e.getName() +" "+e.getSalary());
		});
		
	
	}
	
	
	
	private static int getMax(int num[]) {
		int temp=num[0];
		for(int i=0;i<num.length;i++) {
			if(num[i]>temp) {
				temp=num[i];
			}
		}
		return temp;
	}
	
	private static int getMin(int num[]) {
		int temp=num[0];
		for(int i=0;i<num.length;i++) {
			if(num[i] < temp) {
				temp=num[i];
			}
		}
		return temp;
	}
	
	private static List<Integer> sortAs(int num[]) {
		int temp=num[0];
		int count =0;
		while(count < num.length) {
			for(int i=1;i<num.length;i++) {
				if(num[i-1] < num[i]) {
					temp = num[i-1];
					num[i-1]=num[i];
					num[i]=temp;
				}
			}
			count++;
		}
		return Arrays.stream(num).boxed().collect(Collectors.toList());
	}
	
	private static int addSalOfEmp(List<Emp> emp) {
		return  emp.stream().collect(Collectors.summingInt(Emp::getSalary));
		
	}
	
	private static int addSalofEmpinCity(List<Emp> emps,String city) {
		return  emps.stream().filter(e -> city.equals(e.getCity()))
				.collect(Collectors.summingInt(Emp::getSalary));
	}
	
	private static Set<String> getSkillofEmp(List<Emp> e) {
		return e.stream().flatMap(emp -> emp.getSkills().stream()).collect(Collectors.toSet());
	}
	
	private static List<Integer> allEven(int num[]){
		List<Integer> temp = Arrays.stream(num).boxed().collect(Collectors.toList());
		List<Integer> even = temp.stream().filter(i -> i%2==0).collect(Collectors.toList());
		return even;
	}
	
	private static List<Emp> sortBySal(List<Emp> emp){
		
		List<Emp> empSort = emp.stream().sorted((e1,e2) -> e1.getSalary()-e2.getSalary()).collect(Collectors.toList());
		return empSort;
	}
	public static void reverseArrayElementsWitoutUsingAnotherArray() {
		int [] inputArray = {10,20,30,40,50,60,70,80,90,100,110};
		
		for (int i = 0;i < (inputArray.length/2);i++) {
			int temp = inputArray[i];
			inputArray[i] = inputArray[inputArray.length-1-i];
			inputArray[inputArray.length-1-i] = temp;
		}
		
		System.out.println(Arrays.toString(inputArray));
	}
	
	public static void maxOccurenceOfElementFromArray() {
		int[] inputArray = {1,2,3};
		Map<Integer, Integer> map = new HashMap<>();
		int occurences = 1;
		int maxOccurenceElement = inputArray[0];
		boolean status = false;
		for (int i : inputArray) {
			if (map.get(i) == null) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i)+1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > occurences) { //If Map contains more than one occurence for the element
												// update maxOccurenceElement with the value
				occurences = entry.getValue();
				maxOccurenceElement = entry.getKey();
				status = true;
			}
		}
		
		if (status) {
			System.out.println("The Max Occurrence  Element is: " + maxOccurenceElement + " which is appered " + occurences + "times" );
		} else {
			System.out.println("All the elements in the given array are Unique");
		}
	}
	
	public static List<Integer> allNumEndWithZero(int nums[]){
		List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		return numList.stream().map(n -> ""+n).filter(n -> n.endsWith("0")).map(n -> new Integer(n)).collect(Collectors.toList());
	}
}
