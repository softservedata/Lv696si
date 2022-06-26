package org.example;
import java.util.*;

public class MyUtils {

    public int[][] arrSort(int[][] arr) {

        ArrayCompare myComparator = new ArrayCompare();
        Arrays.sort(arr, myComparator);
        return arr;
    }

    public List<String> strSort(List<String> originList) {

        List<String> newList = new ArrayList<>(originList);
        StringCompare myComparator = new StringCompare();
        Collections.sort(newList, myComparator);
        return newList;
    }

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map <String, List<String>> newMap = new HashMap<>();
        for(Map.Entry<String, String> entry : phones.entrySet()){

            if(newMap.containsKey(entry.getValue()))  // There is already a name present as a Key
                newMap.get(entry.getValue()).add(entry.getKey());
            else    // There is no name as Key present
                newMap.put(entry.getValue(), new ArrayList<String>(Collections.singletonList(entry.getKey())));
        }
        return newMap;
    }

    public boolean listMapCompare(List<String> list, Map<String, String> map) {

        for(String value : list){
            if(!map.containsValue(value))
                return false;
        }
        for(String value : map.values()) {
            if(!list.contains(value))
                return false;
        }
        return true;
    }

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {

        Set<Student> newSet = new HashSet<>();

        for(Student student : list1) {
            if(list2.contains(student))
                newSet.add(student);
        }

        return newSet;
    }
}

class StringCompare implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {

        if(str1.length() < str2.length())
            return -1;
        if(str2.length() < str1.length())
            return 1;

        int result;
        for(int index = 0; index < str1.length(); index++){
            result = Character.compare(str1.charAt(index), str2.charAt(index));
            if(result != 0)
                return result;
        }
        return 0;
    }
}
class ArrayCompare implements Comparator<int[]> {

    @Override
    public int compare(int[] array1, int[] array2) {

        if (array1.length == 0 && array2.length == 0)
            return 0;
        if (array1.length == 0)
            return 1;
        if (array2.length == 0)
            return -1;

        for (int index = 0; index < 2; index++) {

            if(index == 0) {
                if(array1[index] < array2[index])
                    return 1;
                if(array2[index] < array1[index])
                    return -1;
            } else {

                if(array1.length == 1) {
                    if(0 < array2[index])
                        return -1;
                    if(array2[index] < 0)
                        return 1;
                }

                if(array2.length == 1) {
                    if(0 < array1[index])
                        return 1;
                    if(array1[index] < 0)
                        return -1;
                }
                if(array1[index] < array2[index])
                    return -1;
                if(array2[index] < array1[index])
                    return 1;
            }
        }
        return 0;
    }
}