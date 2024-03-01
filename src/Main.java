import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // review of primitive types casting
        float d = 2.5f; // float is not default so we need to use f, simply usage of 2.5 literal is producing a double

        int x = (int) d; // narrowing
        System.out.println(x);

        System.out.println(d);

        double d2 = d; // widening

        Integer i = new Integer(5);

        int a1 = 5; // autoboxing
        Integer a = Integer.valueOf(a1);

        short b = (short) 32769;
        System.out.println(b);
        // -32768 ... -120 ... -1 0 1 ... 120 ... 32767
        // ===============================================

        // upcasting
        // Object is the root class of all classes in Java, so this is upcasting
        // not something you would want to do, because of narrowed functionality
        Object stringBuffer = new StringBuffer();
        // stringBuffer.append we are not able to call append, because of upcasting,
        // append is defined in StringBuffer but not in Object
        StringBuffer sb = new StringBuffer();
        sb.append("whatever");
        Animal dogo = new Dog("Dogo", "white", "dogo");

        // good example of upcasting, using just one level above for the variable
        List<Integer> arrayList = new ArrayList<>();
        arrayList = new LinkedList<>();

        Animal animal = new Animal();

        // forsing the cast of parent object into the child, resul ClassCastExection
//        Dog dog3 = (Dog) new Animal("Dogo", "brown");

        //downcasting
        Animal dog = new Dog("Dogo", "black", "blacky"); // upcasting
        Dog dog2 = new Dog("Jacky", "black", "jacky boy"); // exact type
        // dog.bark not available
        Dog dog1 = (Dog) dog; // downcasting
        dog1.bark();
        ((Dog) dog).bark(); // if we really don't want to introduce child type variable, we can do this ugly cast

        if (dog instanceof Cat) {
            Cat cat = (Cat) dog; // ClassCastException, because we are not using exact type nor parent type for the variable
        }

        // external calls, we don't know what exact type we will get
        Animal randomAnimal = AnimalHelper.createRandomAnimal(); // imagine that createRandomAnimal method's code is not avaialbe to us
        if (randomAnimal instanceof Dog) {
            System.out.println("Random animal is a Dog");
        } else if (randomAnimal instanceof Cat) {
            System.out.println("Random animal is a Cat");
        }

        Dog dog12 = null;
        Cat cat1 = null;
        if (Dog.class.isInstance(randomAnimal)) {
            dog12 = Dog.class.cast(randomAnimal);
        } else if (randomAnimal instanceof Cat) {
            cat1 = Cat.class.cast(randomAnimal);
        }
        System.out.println(dog12.getName());
        // System.out.println(cat1.getName()); NullPointerException
    }

}