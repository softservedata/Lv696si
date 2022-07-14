package org.example;

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter;

        private Iterator() {
            counter = 0;
        }

        public boolean hasNext() {
            return names.length > (counter + 1);
        }

        public String next() {
            String strToReturn = names[counter];
            counter++;
            return strToReturn;
        }
    }
}