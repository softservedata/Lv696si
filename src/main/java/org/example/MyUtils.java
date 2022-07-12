package org.example;
import java.math.BigDecimal;
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
                newMap.put(entry.getValue(), new ArrayList<>(Collections.singletonList(entry.getKey())));
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

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {

        Set<Student> newSet = new HashSet<>();

        for (Student student : list1) {
            if (list2.contains(student))
                newSet.add(student);
        }

        return newSet;
    }

    public List<Employee> largestEmployees(List<Employee> workers) {

        int maxExp = 0;
        BigDecimal maxSal = BigDecimal.valueOf(0);
        List<Employee> maxWorkers = new ArrayList<>();

        for (Employee worker : workers) {
            if (worker == null)
                break;
            if (worker.getExperience() > maxExp)
                maxExp = worker.getExperience();
            if (worker.getPayment().compareTo(maxSal) > 0)
                maxSal = worker.getPayment();
        }

        for (Employee worker : workers) {
            if (worker == null)
                break;
            if (worker.getExperience() == maxExp) {
                if (!maxWorkers.contains(worker))
                    maxWorkers.add(worker);
            }
            if (worker.getPayment().compareTo(maxSal) == 0) {
                if (!maxWorkers.contains(worker))
                    maxWorkers.add(worker);
            }
        }
        return maxWorkers;
    }

    public List<Person> maxDuration(List<Person> persons) {

        int maxStudyYears = 0;
        int maxWorkYears = 0;
        List<Person> maxYearPeople = new ArrayList<>();

        for (Person person : persons) {
            if (person == null)
                break;
            if (person.getClass().equals(Worker.class)) {
                if (maxWorkYears < ((Worker) person).getExperienceYears())
                    maxWorkYears = ((Worker) person).getExperienceYears();
            } else if (person.getClass().equals(org.example.Student.class)) {
                if (maxStudyYears < ((org.example.Student) person).getStudyYears())
                    maxStudyYears = ((org.example.Student) person).getStudyYears();
            }
        }

        for (Person person : persons) {
            if (person == null)
                break;
            if (person.getClass().equals(Worker.class)) {
                if (((Worker) person).getExperienceYears() == maxWorkYears) {
                    if (!maxYearPeople.contains(person))
                        maxYearPeople.add(person);
                }
            } else if (person.getClass().equals(org.example.Student.class)) {
                if (((org.example.Student) person).getStudyYears() == maxStudyYears) {
                    if (!maxYearPeople.contains(person))
                        maxYearPeople.add(person);
                }
            }
        }

        return maxYearPeople;
    }

    public double sumPerimeter(List<?> figures) {
        double sumPer = 0;

        for (Object figure : figures) {
            if (figure == null)
                break;
            if (figure instanceof Square)
                sumPer += ((Square) figure).getPerimeter();
        }
        return sumPer;
    }

    public List<Shape> maxAreas(List<Shape> shapes) {

        List<Shape> maxAreaList = new ArrayList<>();
        double maxCircleArea = 0;
        double maxRectArea = 0;

        for (Shape figure : shapes) {
            if (figure instanceof Circle) {
                if (figure.getArea() > maxCircleArea)
                    maxCircleArea = figure.getArea();
            }
            if (figure instanceof Rectangle) {
                if (figure.getArea() > maxRectArea)
                    maxRectArea = figure.getArea();
            }
        }

        for (Shape figure: shapes) {
            if (figure instanceof Circle) {
                if (figure.getArea() == maxCircleArea) {
                    if (!maxAreaList.contains(figure))
                        maxAreaList.add(figure);
                }
            }
            if (figure instanceof Rectangle) {
                if (figure.getArea() == maxRectArea) {
                    if (!maxAreaList.contains(figure))
                        maxAreaList.add(figure);
                }
            }
        }
        return maxAreaList;
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