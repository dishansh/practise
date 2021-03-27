package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapPrograms {

    class Fruit{
        private String name;
        private String color;
        private double price;

         /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit [color=" + color + ", name=" + name + ", price=" + price + "]";
    }

    public Fruit(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fruit fruit = (Fruit) o;
            return Double.compare(fruit.price, price) == 0 &&
                    name.equals(fruit.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }
    }

    private static Map<String, String> map = new HashMap<>(12);
    private static Map<Fruit, String> fruits = new HashMap<>(12);

    public static void main(String[] args) {
        map.put("12", "Dishansh");
        map.put("12", "Dishansh");
        map.put("12", "Dishansh");
        map.put("12", "Dishansh");

        System.out.println("simple map: "+ map.size());

        MapPrograms prg = new MapPrograms();

        fruits.put(prg.new Fruit("Apple", 1.20), "Apple");
        fruits.put(prg.new Fruit("Orange",2.10), "Apple");

        System.out.println("fruits size: "+fruits.size());

        System.out.println(fruits.getOrDefault(prg.new Fruit("Apple", 1.20), "Kiwi is not present"));

        



    }

    
    

   

}
