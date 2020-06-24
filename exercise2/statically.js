class Statically {
    //fix this code, so all of the instantiation and console.logs() work.  Try not to change the signature of the class, unless absolutely necessary.
    static glue = "Epoxy";
    jello = "Jello";

    static moveAndShake() {
        console.log("Never stagnate in life.  Be agile, change, and improve...");
    }

    static stubborn() {
        Statically.moveAndShake();
        console.log("Please don't make me change... I just don't like it...");
    }

    static explain() {
        Statically.stubborn();
        console.log(Statically.glue);
        console.log("The static keyword is utilized in classes in both Java and Javascript. However, the static keyword is important in Java because the language focuses primarily on objected oriented programming, and is used to manipulate date within the classes.")
        //write an explanation for how the keyword static behaves differently in javascript vs. java.
    }
}

//get the below code to run correctly without errors:  Make sure you explain what you did in the the explain() method, defined in the class.  Do NOT remove the 'static' keyword from the explain() method.

const stats = new Statically();

Statically.moveAndShake();
Statically.stubborn();
Statically.explain();

console.log(Statically.glue);
console.log(stats.jello);

//Once you have finished getting statistically.js to run, refactor the code here in Java.
