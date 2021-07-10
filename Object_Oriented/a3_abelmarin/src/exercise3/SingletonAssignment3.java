// Abel Marin
// Exercise 3
package exercise3;

public class SingletonAssignment3 {
    private static SingletonAssignment3 [ ] instance = new SingletonAssignment3[3];


    public SingletonAssignment3() {
        System.out.println("Instance created at: " + System.currentTimeMillis());
    }

    public static Object getInstance(String input) {
        if (input.equals("Yes")) {

            for (int i =0; i < 3; i++) {
                if (instance[i] == null) {
                    instance[i] = new SingletonAssignment3();
                    return instance[i];
                }
            }
            System.out.println("Cannot create any more instances");
            return instance[2];
        } else {
            System.out.println("No instance is requested");
            return null;
        }

    }

}
