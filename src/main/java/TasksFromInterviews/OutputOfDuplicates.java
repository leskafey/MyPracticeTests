package TasksFromInterviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OutputOfDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        findDuplicates(input);
    }

        public static void findDuplicates(String input){
            Map<String, Integer> map = new HashMap<>();
            String[] elements = input.split(",");
            for (String element : elements){
                if (map.containsKey(element)) {
                    map.put(element, map.get(element)+1);
                } else {
                    map.put(element, 1);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                   System.out.println("Повторяющиеся элементы: " + entry.getKey());
                }
            }
        }
    }
