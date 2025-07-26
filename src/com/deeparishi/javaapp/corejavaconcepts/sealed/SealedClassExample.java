package com.deeparishi.javaapp.corejavaconcepts.sealed;

public class SealedClassExample {

    public static void main(String[] args) {

        A a = new B();
        a.aMethod();

        B b = new B();
        b.aMethod();

        D d = new D();
        d.aMethod();

        A a2 = new F();
        a2.aMethod();

        F f = new F();
        f.aMethod();
    }
}

/**
    Purpose:
            Abstract base class for the sealed hierarchy. Declares common state and behavior.
    Details:
            Contains two integer fields: a1, a2.
            Declares a method aMethod() that is overridden in subclasses.
            Marked sealed to restrict subclassing to only B, C, and E.
 */
sealed class A permits B, C, E {

    int a1;
    int a2;

    public A(){}

    public A(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    void aMethod(){
        System.out.println("A Method!");
    }
}

/**
 * Purpose: A subclass of A that cannot be extended further.
 * Details:
     * Overrides aMethod() to print "B Method!".
     * Marked final to close extension, which is one of the three legal options for sealed subclasses
       (along with non-sealed and sealed).
 */
final class B extends A {

    @Override
    void aMethod() {
        System.out.println("B Method!");
    }
}

/*
Purpose: A subclass of A that opens up for further subclassing.
Details:
    Overrides aMethod() to print "C Method!".
    Marked non-sealed to lift the restriction on inheritance for future classes.
 */
non-sealed class C extends A {

    @Override
    void aMethod() {
        System.out.println("C Method!");
    }

}


/*
Purpose: A regular class extending C.
Details:
    Inherits from C, which is non-sealed — so no restrictions on extending.
    Overrides aMethod() to print "D Method!".
 */
class D extends C {

    @Override
    void aMethod() {
        System.out.println("D Method!");
    }

}

/*
    Purpose: Another sealed subclass of A, which only allows F to extend it.
    Details:
        Overrides aMethod() to print "B Method!".
        Continues sealed behavior but limits it to F
 */
sealed class E extends A permits F{

    @Override
    void aMethod() {
        System.out.println("B Method!");
    }

}

/*
    Purpose: The only permitted subclass of E, and it opens up inheritance again.
    Details:
        Overrides aMethod() to print "F Method!".
        Marked non-sealed to allow more flexibility and extension by other classes.
 */
non-sealed class F extends E {

    @Override
    void aMethod() {
        System.out.println("F Method!");
    }

}



/*
    Sealed:
        To control and limit inheritance.
        Enforces architectural or API design rules.
        Prevents unwanted subclassing (e.g., for security, domain constraints).

    non-sealed
        To lift the restriction from a sealed superclass.
        Allows open inheritance again.

    | Keyword      | Inheritance Allowed? | Allows Further Extension? | Use Case Example              |
    | ------------ | -------------------- | ------------------------- | --------------------------------- |
    | `sealed`     | Limited to permitted | Only to listed subclasses | Domain models, compiler design    |
    | `non-sealed` | Yes                  | Yes                       | Frameworks, extensible models     |
    | `final`      | Yes (once)           | No                        | Utility classes, security classes |


 */