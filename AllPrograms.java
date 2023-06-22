import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    int empId;
    String empName;
    int empSal;

    Employee(int empId, String empName, int empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }
    
    public int getEmpId() {
        return this.empId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public int getEmpSal() {
        return this.empSal;
    }
}

public class AllPrograms {
    public static void main(String[] args) {
        //Q1) How do you reverse a string in Java?
        //reverseString();

        //Q2) How do you swap two numbers without using a third variable in Java?
        //swapNumberWithoutThird();

        //Q3) Write a Java program to check if a vowel is present in a string.
        //checkIfVowel();

        //Q4) Write a Java program to check if the given number is a prime number.
        // System.out.println(checkNumberIsPrime());
        
        //Q5) Write a Java program to print a Fibonacci sequence using recursion.
        // for (int i = 0; i < 10; i++) {
        //     System.out.print(PrintFibonacci(i) +" "); 
        // }        
        // System.out.println("");

        //Q6) Write a Java program to print a Fibonacci sequence Normal.
        // PrintFibonacciNormal(10);

        //Q7) How do you check if a list of integers contains only odd numbers in Java?
        //checkListContainOddNum();

        //Q8) How do you remove spaces from a string in Java?
        //removeWhitespaceFromString();

        //Q9) How do you sort an array in Java?
        //sortArray();

        //Q10) How can you find the factorial of an integer in Java?
        //factorial();
        
        //Q11) Write Java program that checks if two arrays contain the same elements.
        //checkTwoArray();

        //Q12) How do you get the sum of all elements in an integer array in Java?
        //sumOfInteger();

        //Q13) How do you find the second largest number in an array in Java?
        // findSecondLargestNum();

        //Q14) Write a Java program that sorts HashMap by value?.
        //sortHashMapByValue();

        //Q15) How do you merge two lists in Java?
        // mergeTwoList();

        //Q16) How do you remove all occurrences of a given character from an input string in Java?
        // removeAllOccurancesOfChrFromStr();

        //Q17) How do you get distinct characters and their count in a string in Java?
        //getOccurancesInMap();
        //getOccurancesInMapOldWay();

        //Q18) Create employee records and fetch employee name list whos sal > 50k
        //fetchEmployeeList();

        //Q19) Create employee records and sort by empSal desc
        //sortEmployeeList();

        //Q20) fetch duplicate char from string
        //findDuplicates();

        //Q21) find hightest number from array
        //getHighestNumber();

        //Q22) sort even number from array and count 1st five number
        //sortAndCountFirtsFiveNum();

        //Q23) bubble sort
        //bubbleSort();

        //Q24) selection sort
        selectionSort();

    }

    private static void selectionSort() {
        int[] arr = {7,2,9,3,1};
        int selection = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            selection = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[selection]) {
                    selection = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[selection];
            arr[selection] = temp;
        }

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void bubbleSort() {
        int[] arr = {7,2,9,3,1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sortAndCountFirtsFiveNum() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        int asInt = Arrays.stream(test).filter(x -> x % 2 == 0).limit(5).reduce((a,b) -> a + b).getAsInt();
        System.out.println(asInt);
    }

    private static void getHighestNumber() {
        int[] arr = {10,2,5,50,4,7,};

        //ASC
        Arrays.stream(arr).boxed().sorted().forEach(System.out::println);
        System.out.println("");
        //DSC
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void findDuplicates() {
        String str = "ilovemycountry";
        List<String> asList = Arrays.asList(str.split(""));
        //fetch in Set
        Set<String> collect = asList.stream().filter(x -> Collections.frequency(asList, x) > 1).collect(Collectors.toSet());
        System.out.println(collect);

        //get distinct
        asList.stream().distinct().forEach(System.out::print);
        System.out.println("");
        //first non repetable char
        String string = asList.stream().filter(x -> Collections.frequency(asList, x) == 1).findFirst().get();
        System.out.println(string);
    }

    private static void sortEmployeeList() {
        List<Employee> lst = new ArrayList<>();
        lst.add(new Employee(1, "Sahil", 37000));
        lst.add(new Employee(1, "Sunil", 67000));
        lst.add(new Employee(1, "kartik", 27000));
        lst.add(new Employee(1, "rahul", 137000));
        lst.add(new Employee(1, "Aniket", 17000));

        List<Employee> empList = lst.stream().sorted(Comparator.comparing(Employee::getEmpSal)
                                .reversed()).collect(Collectors.toList());

        for (Employee employee : empList) {
            System.out.println(employee.empSal);
        }
        
    }

    private static void fetchEmployeeList() {
        List<Employee> lst = new ArrayList<>();
        lst.add(new Employee(1, "Sahil", 37000));
        lst.add(new Employee(1, "Sunil", 67000));
        lst.add(new Employee(1, "kartik", 27000));
        lst.add(new Employee(1, "rahul", 137000));
        lst.add(new Employee(1, "Aniket", 17000));

        List<String> empList = lst.stream().filter(x -> x.empSal > 50000).map(x -> x.empName).collect(Collectors.toList());
        System.out.println(empList);
    }

    private static void getOccurancesInMapOldWay() {
        Map<String, Integer> map = new HashMap<>();
        String str = "ilovemycountry";
        String[] split = str.split("");

        for (int i = 0; i < split.length - 1; i++) {
            if(map.containsKey(split[i])) {
                map.put(split[i], map.get(split[i]) + 1);
            }else{
                map.put(split[i], 1);
            }
        }

        System.out.println(map);
    }

    private static void getOccurancesInMap() {
        String str = "ilovemycountry";
        List<String> asList = Arrays.asList(str.split(""));

        Map<String, Long> collect = asList.stream().collect(Collectors
                                    .groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
        
    }

    private static void removeAllOccurancesOfChrFromStr() {
        String str = "mayureshkapdule";
        String removeChar = "a";

        str = str.replace(removeChar, "");
        System.out.println(str);
    }

    private static void mergeTwoList() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        List<String> list2 = new ArrayList<>();
        list2.add("2");

        List<String> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        System.out.println(mergedList);
    }

    private static void sortHashMapByValue() {
        Map<String, Integer> scores = new HashMap<>();

		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);

        //default sorting
        scores.entrySet().stream().sorted(Map.Entry.comparingByValue());

        //reverse sorting
        //scores.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Score::getScore)));

        Iterator itr = scores.values().iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + ", ");
        }


        
    }

    private static void findSecondLargestNum() {
        int[] arr = {1,3,2,6,8,3};
        Integer integer = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(integer);
    }

    private static void sumOfInteger() {
        int[] arr = {1,3,2,6,8,3};
        int asInt = Arrays.stream(arr).reduce((a, b) -> a + b).getAsInt();
        System.out.println(asInt);
    }

    private static void checkTwoArray() {
        Integer[] a1 = {1,2,3,2,1};
		Integer[] a2 = {1,2,3,5};

        Set<Object> set = new HashSet<>(Arrays.asList(a1));
        Set<Object> set1 = new HashSet<>(Arrays.asList(a2));

        // if size is different, means there will be a mismatch
		if (set.size() != set1.size()) {
            System.out.println(false);
            return;
        }
        for (Object object : set) {
            // element not present in both?
			if (!set.contains(object)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
        return;
    }

    private static void factorial() {
        int num = 5;
        int temp = 1;
        for (int i = 1; i < num; i++) {
            temp = temp * i;//1*2*3*4
        }

        System.out.println(temp);
    }


    private static void sortArray() {
        int[] array = {1, 2, 3, -1, -2, 4};
        Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }


    private static void removeWhitespaceFromString() {
        String input = "i love my country";
        StringBuilder sb = new StringBuilder();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if(!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }





    private static void checkListContainOddNum() {
        int[] arr = {8,2,4,10,6};

        long count = Arrays.stream(arr).filter(x -> x % 2 != 0).count();
        if(count > 0) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }


    private static void PrintFibonacciNormal(int i) {
        List<Integer> lst = new ArrayList<>();
        int a = 0;
        int b = 1;
        lst.add(a);
        lst.add(b);
        for (int j = 0; j < i; j++) {
            int temp = a + b;
            a = b;
            b = temp;
            lst.add(temp); 
        }

        System.out.print(lst);
    }


    private static int PrintFibonacci(int count) {
       if(count == 0 || count == 1) {
        return count;
       }else{
        return PrintFibonacci(count - 1) + PrintFibonacci(count - 2);
       }        
    }


    private static boolean checkNumberIsPrime() {
        int num = 2;
        if(num == 0 || num == 1) {
            return false;
        }else if(num == 2){
            return true;
        }
        for (int i = 2; i < num / 2; i++) {         
            if(num % i == 0) {
                return false;            
            }
        }
        return true;
    }


    private static void checkIfVowel() {
        String str = "mayuresh";
        System.out.println(str.toLowerCase().matches(".*[aeiou].*"));
    }


    private static void reverseString() {
        String str = "mayuresh";
        String revStr = "";
        char[] charArray = str.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            revStr = revStr + charArray[i];
        }
        System.out.println(revStr);
    }

    private static void swapNumberWithoutThird() {
        int a = 10;
        int b = 20;
        System.out.println("A befor " +a+ " B befor " +b);
        b = b + a; //30
        a = b - a; //20
        b = b - a; //10
        System.out.println("A After " +a+ " B After " +b);
    }
}


