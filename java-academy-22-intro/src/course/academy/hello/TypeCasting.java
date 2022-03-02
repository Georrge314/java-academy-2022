package course.academy.hello;

import java.util.Date;

public class TypeCasting {
    public static void main(String[] args) {
        //От по-малък към по-голям няма проблем, но от по-голям към по-малък,
        //има шанса да се загубят данни!
        byte b = 124;
        short s = b;
        System.out.printf("byte to short: %d\n", s);
        int i = b;
        System.out.printf("byte to int: %d\n", i);
        long l = b;
        System.out.printf("byte to long: %d\n", l);

        //може да изгубим данни
        int i2 = (int) 435335343444534454L;
        System.out.printf("long to int: %d\n", i2);

        String str = "Hello Java!";
        Object obj = str; // Upcasting is automatic
        System.out.println("Upcasting String -> Object: " + str);

        /**
         Upcasting is casting a subtype to a supertype,
         going up in the inheritance tree.
         It is done implicitly
         in order to use method available on any
         interface/class, the object should be of
         same class or of class implementing the interface.
         WebDriver driver = new ChromeDriver();
         or
         TakeScreenShot ts = new ChromeDriver();

         Downcasting is casting to a subtype,
         going down in the inheritance tree.
         It is done to access sub class features.
         It has to be done manually
         */

        Object obj2 = new Date();
        if (obj2 instanceof String) {
            //можем да получим изключение
            String str2 = (String) obj2;
            System.out.println("Downcasting Object -> String: " + str2);
        } else {
            System.out.printf("Imposible to cast %s to %s",
                    obj2.getClass().getSimpleName(), String.class.getSimpleName());
        }

    }
}
