package functional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
	
	// Constructor Chaining
	public Test(int x,int y) {}
	public Test(int x) {this(10,20);}
	public Test() { this(10);}
	
	
	
	
	public static void main(String[] args) {
		// Predicate
		Predicate<String> sLengthEven = s->s.length()%2==0;
		System.out.println(sLengthEven.test("Sumit"));
		
		Predicate<String> greater = g->g.length()>5;
		System.out.println(greater.test("Karanataka"));
		System.out.println(sLengthEven.and(greater).test("MAYAPURI"));
		
		List<Integer> lt = new ArrayList<Integer>();
		lt.add(12);
		lt.add(19);
		lt.add(13);
		lt.add(15);
		lt.add(18);
		
		Predicate<Integer> isEven = e-> e%2==0;
		
		List<Integer> newLt =  lt.stream().filter(isEven).collect(Collectors.toList());
		newLt.forEach(System.out :: println);
		for (Integer integer : newLt) {
			System.out.print(integer +", ");
		}
			
		
		// BiPredicate
		BiPredicate<String, Integer> greaterThen = (g,l)->g.length()>l;
		System.out.println(greaterThen.test("Karanataka",5));
		
		
		List<Integer> lt1 = Arrays.asList(1,2,3,5,6,7,11,10);
		
		// MAX 
		OptionalLong max = lt1.stream().mapToLong(v->v).max();
		System.out.println("max : "+max);
		// MIN
		OptionalLong min = lt1.stream().mapToLong(v->v).min();
		System.out.println("min : "+min);
		///////////////////////////////////////////////////////
		
		List<Employ> emplist = new ArrayList<Employ>();
		emplist.add(new Employ(1, "sumit1@gmail.com"));
		emplist.add(new Employ(2, "amit@gmail.com"));
		emplist.add(new Employ(3, "rani@gmail.com"));
		
		List<Employ> elt = emplist.stream().sorted((o1,o2)-> o1.getId().compareTo(o2.getId())).collect(Collectors.toList());
		//// get emp email in saparate list
		
		List<String> empEmails = emplist.stream().map(Employ:: getEmail).collect(Collectors.toList());
//		List<String> empEmails = emplist.stream().map(emplist.l).collect(Collectors.toList());
		
	}

}
