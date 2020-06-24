package exercise2;

public class Statically {
    private static String glue = "Epoxy";
    private static String jello = "Jello";

    private static void moveAndShake() {
        System.out.println("Never stagnate in life.  Be agile, change, and improve...");
    }

    private static void stubborn() {
        Statically.moveAndShake();
        System.out.println("Please don't make me change... I just don't like it...");
    }

    private static void explain() {
        Statically.stubborn();
        System.out.println(Statically.glue);
        console.log("The static keyword is utilized in classes in both Java and Javascript. However, the static keyword is important in Java because the language focuses primarily on objected oriented programming, and is used to manipulate date within the classes.")
    }

    public static void main(String[] args) {
        Statically stats = new Statically();

        Statically.moveAndShake();
        Statically.stubborn();
        Statically.explain();

        System.out.println(Statically.glue);
        System.out.println(stats.jello);
    }

    //Once you have finished getting statistically.js to run, refactor the code here in Java.

}
