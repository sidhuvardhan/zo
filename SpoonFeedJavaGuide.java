// --- REFACTORED JAVA STUDY GUIDE: PROGRESSIVE & DETAILED CODE REFERENCE ---
// This file is structured to be read from Section 1 (Basics) down to Section 7 (Advanced Utilities).
// To run: Save as SpoonFeedJavaGuide_Clean.java and compile using: javac SpoonFeedJavaGuide_Clean.java
// Then run using: java SpoonFeedJavaGuide_Clean

// The advanced OOP classes (Sections 4 and 5) are defined at the very bottom for a better learning flow.

public class SpoonFeedJavaGuide {

    /**
     * CONCEPT: STATIC VARIABLE (CLASS VARIABLE)
     * DEFINITION: A variable declared inside the class but outside any method, using the 'static' keyword.
     * PURPOSE: To hold a common value that is shared by ALL instances of this class. It belongs to the class itself.
     * WHY 'static': Allows access to this variable WITHOUT creating an object (loads when the class loads).
     */
    public static final String LANGUAGE = "Java";

    /**
     * CONCEPT: MAIN METHOD
     * DEFINITION: The public static void main(String[] args) method.
     * PURPOSE: The entry point of the entire application. The Java Virtual Machine (JVM) starts execution here.
     * WHY 'static': Allows the JVM to call this method directly without instantiating the class.
     */
    public static void main(String[] args) {

        System.out.println("--- SECTION 1: FUNDAMENTALS (Variables, Data Types, Casting) ---");
        // OUTPUT: --- SECTION 1: FUNDAMENTALS (Variables, Data Types, Casting) ---

        /**
         * CONCEPT: LOCAL VARIABLES
         * DEFINITION: A variable declared inside a method, constructor, or block.
         * SCOPE: Only exists while the block of code it is in is executing.
         */
        int score = 85;

        // --- PRIMITIVE DATA TYPES ---
        // int, long (for whole numbers), double, float (for decimals), boolean, char
        int year = 2025;
        long population = 8_000_000_000L; // Requires 'L' suffix.
        double price = 55999.99;
        boolean isComplete = true;

        System.out.println("Current Year: " + year + ", Price: $" + price);
        // OUTPUT: Current Year: 2025, Price: $55999.99

        /**
         * CONCEPT: NON-PRIMITIVE (REFERENCE) DATA TYPES
         * DEFINITION: Data types that hold references (memory addresses) to objects (Heap).
         * TYPES: Classes (like String), Interfaces, Arrays. String is IMMUTABLE.
         */
        String message = "Welcome to the " + LANGUAGE + " guide!";
        System.out.println(message + " - Complete Status: " + isComplete);
        // OUTPUT: Welcome to the Java guide! - Complete Status: true

        /**
         * CONCEPT: TYPE CASTING
         * PURPOSE: Converting a value from one data type to another.
         * WAYS: Widening (Implicit, safe) and Narrowing (Explicit, requires cast operator `(type)`).
         */
        // TYPE 1: Widening Casting (int to double, Automatic)
        double wideYear = year;
        System.out.println("Widening Cast (int to double): " + wideYear);
        // OUTPUT: Widening Cast (int to double): 2025.0

        // TYPE 2: Narrowing Casting (double to int, Explicit/Manual)
        int narrowPrice = (int) price;
        System.out.println("Narrowing Cast (double to int): " + narrowPrice);
        // OUTPUT: Narrowing Cast (double to int): 55999


        System.out.println("\n--- SECTION 2: LOGIC & FLOW (Decision Making) ---");
        // OUTPUT:
        // OUTPUT: --- SECTION 2: LOGIC & FLOW (Decision Making) ---

        /**
         * CONCEPT: IF-ELSE-IF STATEMENT
         * PURPOSE: To execute different blocks of code based on conditions.
         */
        if (score >= 90) {
            System.out.println("Result: Grade A.");
        } else if (score >= 80) {
            System.out.println("Result: Grade B.");
            // OUTPUT: Result: Grade B.
        } else {
            System.out.println("Result: Grade C.");
        }

        /**
         * CONCEPT: SWITCH STATEMENT
         * PURPOSE: A clean alternative to long if-else-if chains.
         * KEYWORD: 'break' is CRITICAL to prevent "fall-through."
         */
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            default:
                dayName = "Other Day";
                break;
        }
        System.out.println("Day " + day + " is " + dayName);
        // OUTPUT: Day 3 is Wednesday


        System.out.println("\n--- SECTION 3: REPETITION (Arrays and Loops) ---");
        // OUTPUT:
        // OUTPUT: --- SECTION 3: REPETITION (Arrays and Loops) ---

        /**
         * CONCEPT: ARRAYS
         * DEFINITION: Stores a fixed number of elements of the same type, accessed via a 0-based index.
         */
        int[] numbers = {10, 20, 30, 40};
        System.out.println("Array Size: " + numbers.length);
        // OUTPUT: Array Size: 4

        /**
         * CONCEPT: STANDARD FOR LOOP (Index-based iteration)
         * WHY: Used when you need precise control over the index (i).
         * KEYWORDS: 'continue' (skips current iteration), 'break' (terminates entire loop).
         */
        System.out.print("Standard Loop Output: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 30) { continue; }
            if (numbers[i] == 40) { break; }
            System.out.print(numbers[i] + " ");
        }
        // OUTPUT: Standard Loop Output: 10 20
        System.out.println();

        /**
         * CONCEPT: ENHANCED FOR LOOP (Foreach)
         * WHY: Simpler way to iterate when you only need the element value (not the index).
         */
        System.out.print("Enhanced Loop Output: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        // OUTPUT: Enhanced Loop Output: 10 20 30 40
        System.out.println();

        /**
         * CONCEPT: WHILE LOOP
         * DEFINITION: A pre-test loop that executes as long as a condition is true.
         * WHY: Used when the number of iterations is UNKNOWN.
         */
        int counter = 0;
        System.out.print("While Loop Output: ");
        while (counter < 3) {
            System.out.print("Count " + counter + " ");
            counter++;
        }
        // OUTPUT: While Loop Output: Count 0 Count 1 Count 2
        System.out.println();


        System.out.println("\n--- SECTION 4 & 5: OOP IN ACTION (Abstraction, Inheritance, etc.) ---");
        // OUTPUT:
        // OUTPUT: --- SECTION 4 & 5: OOP IN ACTION (Abstraction, Inheritance, etc.) ---

        /**
         * CONCEPT: OBJECT INSTANTIATION
         */
        Car sedan = new Car("Honda Civic", 60, 4);
        // OUTPUT (from constructor): LOG: Vehicle created: Honda Civic

        /**
         * Testing Encapsulation (using Setter to validate data)
         */
        try {
            sedan.setSpeed(250); // Speed validation check inside the setter
        } catch (IllegalArgumentException e) {
             System.out.println("Caught an exception: " + e.getMessage());
        }
        // OUTPUT (from setter): Warning: Cannot exceed max speed of 200. Setting to max.
        System.out.println("Final Speed (via Getter): " + sedan.getSpeed());
        // OUTPUT: Final Speed (via Getter): 200

        /**
         * Testing Polymorphism - Overloading (Compile-Time)
         */
        sedan.accelerate();
        // OUTPUT: Honda Civic accelerated by 10 km/h (default).
        sedan.accelerate(50);
        // OUTPUT: Honda Civic accelerated with a boost of 50 km/h.

        /**
         * Testing Polymorphism - Overriding (Run-Time)
         */
        sedan.displayStatus();
        // OUTPUT (from super): Honda Civic is currently traveling at 260 km/h.
        // OUTPUT (from Car): It is a 4-door Car.

        /**
         * Runtime Polymorphism via Parent Reference
         */
        Vehicle genericVehicle = new Car("Ford Fiesta", 80, 2);
        // OUTPUT (from constructor): LOG: Vehicle created: Ford Fiesta

        System.out.println("\n--- Polymorphic Call via Parent Reference ---");
        // OUTPUT:
        // OUTPUT: --- Polymorphic Call via Parent Reference ---

        genericVehicle.displayStatus();
        // OUTPUT (from super): Ford Fiesta is currently traveling at 80 km/h.
        // OUTPUT (from Car): It is a 2-door Car.


        System.out.println("\n--- SECTION 7: ADVANCED UTILITIES ---");
        // OUTPUT:
        // OUTPUT: --- SECTION 7: ADVANCED UTILITIES ---

        /**
         * 7.1. Collections: ArrayList (Dynamic Data Structure)
         * PURPOSE: A list that can grow and shrink dynamically (unlike Arrays).
         */
        java.util.ArrayList<String> tasks = new java.util.ArrayList<>();
        tasks.add("Study OOP");
        tasks.add("Write Report");
        tasks.set(0, "Master Collections"); // Replace index 0
        tasks.remove(1); // Remove item at index 1

        System.out.println("List Size: " + tasks.size());
        // OUTPUT: List Size: 1
        System.out.println("List Content: " + tasks);
        // OUTPUT: List Content: [Master Collections]


        /**
         * 7.2. Exception Handling (Robustness)
         * PURPOSE: To gracefully recover from errors (preventing crashes).
         * KEYWORDS: 'try', 'catch', 'finally'.
         */
        int x = 10;
        int y = 0; // Will cause ArithmeticException

        try {
            System.out.println("\nAttempting division...");
            // OUTPUT:
            // OUTPUT: Attempting division...
            int result = x / y; // Exception occurs here.
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("ERROR CAUGHT: Arithmetic problem. Cannot divide by zero.");
            // OUTPUT: ERROR CAUGHT: Arithmetic problem. Cannot divide by zero.
            System.out.println("Exception Message: " + e.getMessage());
            // OUTPUT: Exception Message: / by zero

        } finally {
            System.out.println("FINALLY BLOCK: Execution finished.");
            // OUTPUT: FINALLY BLOCK: Execution finished.
        }

        System.out.println("Program successfully continued.");
        // OUTPUT: Program successfully continued.
    }
}


// --------------------------------------------------------
// SECTION 4: ABSTRACTION & INTERFACES (DEFINITIONS)
// --------------------------------------------------------

/**
 * 4.0. Interface Definition (The Contract)
 * DEFINITION: A blueprint of a class containing only abstract methods.
 * PURPOSE: To enforce a contract and achieve 100% abstraction.
 */
interface Drivable {
    void accelerateHard();
    int getMaxRange();
}

/**
 * 4.1. Defining an Abstract Class
 * DEFINITION: A class declared with 'abstract'; cannot be instantiated.
 * PURPOSE: Provides a common base for related subclasses.
 */
abstract class Vehicle {

    // INSTANCE VARIABLES: Unique to each object (Encapsulated)
    private String brand;
    private int speed;
    protected int currentGear = 0;
    private final int MAX_SPEED = 200;

    /**
     * 4.1.2. Abstract Method (Abstraction)
     * PURPOSE: Enforces that every subclass must implement this behavior.
     */
    abstract void startEngine();

    /**
     * 4.1.3. Concrete Method
     */
    public void displayStatus() {
        System.out.println(brand + " is currently traveling at " + speed + " km/h.");
    }

    /**
     * 4.1.4. Encapsulation: Getter (Safe access)
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * 4.1.4. Encapsulation: Setter (Controlled mutation/validation)
     */
    public void setSpeed(int newSpeed) {
        if (newSpeed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        if (newSpeed > MAX_SPEED) {
            System.out.println("Warning: Cannot exceed max speed of " + MAX_SPEED + ". Setting to max.");
            // KEYWORD 'this': Refers to the current object instance.
            this.speed = MAX_SPEED;
        } else {
            this.speed = newSpeed;
        }
    }

    /**
     * 4.1.5. Method Overloading (Compile-time Polymorphism)
     * DEFINITION: Same name, different signature (parameters).
     */
    public void accelerate() {
        this.speed += 10;
        System.out.println(brand + " accelerated by 10 km/h (default).");
    }

    public void accelerate(int boost) {
        this.speed += boost;
        System.out.println(brand + " accelerated with a boost of " + boost + " km/h.");
    }

    /**
     * CONCEPT: CONSTRUCTOR
     * PURPOSE: Initializes the object instance.
     */
    public Vehicle(String brand, int initialSpeed) {
        this.brand = brand;
        this.speed = initialSpeed;
        System.out.println("LOG: Vehicle created: " + this.brand);
    }
}


// --------------------------------------------------------
// SECTION 5: INHERITANCE AND POLYMORPHISM (DEFINITIONS)
// --------------------------------------------------------

/**
 * 5.0. Concrete Class Definition
 * KEYWORD 'extends': Establishes INHERITANCE (Car is a Vehicle).
 * KEYWORD 'implements': Fulfills the INTERFACE contract.
 */
class Car extends Vehicle implements Drivable {

    private int doorCount;
    private final int range = 500;

    /**
     * 5.1. Constructor
     * KEYWORD 'super()': Calls the parent's constructor. MUST be the first line.
     */
    public Car(String brand, int initialSpeed, int doors) {
        super(brand, initialSpeed);
        this.doorCount = doors;
    }

    /**
     * 5.2. Completing Abstraction
     * Implements the abstract method inherited from Vehicle.
     */
    @Override
    void startEngine() {
        System.out.println("Car engine started: Vroom! Gear is " + this.currentGear);
    }

    /**
     * 5.3. Method Overriding (Run-time Polymorphism)
     * DEFINITION: Redefining a parent method with the same signature.
     */
    @Override
    public void displayStatus() {
        // KEYWORD 'super': Calls the parent's implementation first.
        super.displayStatus();
        System.out.println("It is a " + doorCount + "-door Car.");
    }

    /**
     * 5.4. Implementing Interface Methods
     * Fulfills the contract required by the Drivable interface.
     */
    @Override
    public void accelerateHard() {
        System.out.println("!!! Flooring the pedal for max performance !!!");
        super.accelerate(75);
    }

    @Override
    public int getMaxRange() {
        return this.range;
    }
}
