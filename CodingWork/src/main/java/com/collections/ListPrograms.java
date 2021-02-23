package com.collections;

import java.util.*;

public class ListPrograms {

    public static void runThroughList() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Dishansh");
        nameList.add("Smriti");
        System.out.println("List : " + nameList);

        //List<String> safeNameList = Collections.synchronizedList(nameList);

        nameList.add("Bhavya");
        System.out.println("List : " + nameList);

        // Set from a List
        Set<String> setFromList = new HashSet<>(nameList);

        // List from a Set
        List<String> listFromSet = new ArrayList<>(setFromList);

        // Old way of sorting list
        Collections.sort(listFromSet);

        // Another way of sorting list
        listFromSet.sort(Comparator.naturalOrder());

        Set<String> setFromSet = new TreeSet<>(setFromList);
        System.out.println(setFromSet);

        nameList.remove(1);
        System.out.println("List : " + nameList);

        Iterator<String> nameListIterator = nameList.iterator();
        while (nameListIterator.hasNext()) {
            System.out.println(nameListIterator.next());
            nameList.add("Ashish");
            nameListIterator.remove();

        }
    }

    public static void runThroughMap() {
        Map<String, String> nameMap = new LinkedHashMap<>();
        nameMap.put("5", "Ashish");
        nameMap.put("2", "Ashish");
        nameMap.put("1", "Smriti");
        nameMap.put("3", "Smriti");
        nameMap.put("4", "Dishansh");
        nameMap.put("6", "Smriti");

        System.out.println(nameMap);

        // Sorting Map by Key
        Map<String, String> sortedMap = new TreeMap<>(nameMap);
        System.out.println(sortedMap);

        // 1 -> Entry Set
        for (Map.Entry<String, String> mapEntry : nameMap.entrySet()) {
            System.out.println(mapEntry.getKey() + " : " + mapEntry.getValue());
        }

        // 2 -> Using Key Set
        for (String str : nameMap.keySet()) {
            System.out.println(str + " : " + nameMap.get(str));
        }

        // Sorting Map by Value
        List<Map.Entry<String, String>> mapList = new ArrayList<>(nameMap.entrySet());
        mapList.sort(Map.Entry.comparingByValue());

        // Lambda's way
        //Collections.sort(mapList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> mapEntry : mapList) {
            sortedMap.put(mapEntry.getKey(), mapEntry.getValue());
        }
        System.out.println(sortedMap);
    }

    public static void main(String[] args) {
        runThroughList();
        runThroughMap();
    }
}
