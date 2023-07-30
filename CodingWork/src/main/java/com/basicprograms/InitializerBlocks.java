package com.basicprograms;

public class InitializerBlocks {

    private String name;
    private String city;
    private int age;
    private static int objectsCreated;

    // Called 3rd
    public InitializerBlocks(String name, String city) {
        System.out.println(" Constructor called ");
        this.name = name;
        this.city = city;
        objectsCreated++;
    }

    // Called 2nd -> if similar blocks exist, they will be called in the order of definition
    // Called per object creation
    {
        System.out.println(" Intializer block called ");
        name = "Dishansh";
        city = "Lucknow";
        age =32;
    }

    // Called 1st -> if similar blocks exist, they will be called in the order of definition
    // Called only once
    static {
        System.out.println(" Static Initializer Block called " +objectsCreated);
    }

    public static void main(String[] args) {

        InitializerBlocks ib = new InitializerBlocks("Smriti", "London");
        InitializerBlocks ib2 = new InitializerBlocks("Smriti", "London");
        System.out.println("Name: "+ib.name+" with age: "+ib.age+" and living in city: "+ib.city);

        // ib3 will point to object that ib2 is referencing; changes to either one of them will be impacting both (Hard Copy)
        InitializerBlocks ib3 = ib2;

        // Change instance values of ib3
        ib3.name = "Hannah";
        ib3.age = 23;

        // Change in instance value of ib2
        ib2.city = "Darjeeling";

        System.out.println("Name of ib2: "+ib2.name+" with age of ib2: "+ib2.age+" and living in city of ib2: "+ib2.city);
        System.out.println("Name of ib3: "+ib3.name+" with age of ib3: "+ib3.age+" and living in city of ib3: "+ib3.city);

        // static variables are class level and hence shared by objects
        System.out.println("Number of objects alive: "+InitializerBlocks.objectsCreated);
    }
}
