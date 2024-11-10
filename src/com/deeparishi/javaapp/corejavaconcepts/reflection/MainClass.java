package com.deeparishi.javaapp.corejavaconcepts.reflection;


import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Set;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class className = Class.forName("com.deeparishi.javaapp.corejavaconcepts.reflection.DummyClass");

        // To get Annotation used in that class
        Annotation[] annotations = className.getAnnotations();

        // To get the constructors
        Constructor[] constructors = className.getConstructors(); // Constructor

        // Declared Annotation, get the private annotation as well
        Annotation[] declaredAnnotations = className.getDeclaredAnnotations();

        // It will get the private and public fields as well
        Field[] declaredFields = className.getDeclaredFields();

        // It will get only the public fields as well
        Field[] fields = className.getFields();

        // It will get both public and private methods from the class
        Method[] declaredMethods = className.getDeclaredMethods();

        // It will get only public methods
        Method[] methods = className.getMethods();

        Set flagSet = className.accessFlags();

        // It will print the what are the methods inside the Dummyclass
        Stream.of(DummyClass.class.getMethods())
                .forEach(System.out::println);


        // Let us try to access the private Method from dummy class using reflection

        // Load the class from the given package and create the object from that class
        Class<?> cls = Class.forName("com.deeparishi.javaapp.corejavaconcepts.reflection.DummyClass");
        DummyClass dummyClass1 = (DummyClass) cls.newInstance();
        DummyClass dummyClass2 = (DummyClass) cls.newInstance();

        // Below will be used to access the private method
        Method method = cls.getDeclaredMethod("privateMethodWithArg", String.class, int.class); // Initially method will get from that class using method name and parameter type
        method.setAccessible(true); // Setting accessible
        method.invoke(dummyClass1, "Hello", 8); // Invoking that method wth our object

    }

}
