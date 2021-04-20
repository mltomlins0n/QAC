# Java

## Contents
- [Overview](#overview)
- [Class Members](#member)
- [Packages](#packages)
- [Conditionals](#conditionals)
- [Scope](#scope)
- [Pillars of OOP](#oop)
  - [Abstraction](#abstraction)
    - [Abstract Classes](#abstract)
    - [Interfaces](#interfaces)
  - [Encapsulation](#encapsulation)
  - [Inheritance](#inheritance)
  - [Polymorphism](#polymorphism)
- ["Static" Keyword](#static)
- [Lambda Expressions](#lambda)
- [Streams](#streams)
- [Garbage Collection](#garbage)
- [Debugging](#debugging)
- [Exceptions](#exceptions)
- [Design Patterns](#design)
- [Database Connection](#database)

<a name="overview"></a>
## Overview

Java is a **compiled** programming language, meaning code written in a **.java** file is transformed into *byte code* by the compiler before being executed by the **Java Virtual Machine (JVM)** on a computer.

To compile a file in the terminal, use `javac someFile.java`

If comilation is successful, an executable class is produced, **someFile.class**.

To run an executable from the terminal, use `java someFile`

If you run a file from the termianl and pass in an argument, for example `java someFile Martin`, this argument is passed to the `String[] args` array.

If the program printed `"Hello " + args[0];`, then the result would be `Hello Martin`.

Java is an object-oriented programming language where every program has at least one class. Programs are often built from many classes and objects, which are the instances of a class.

Classes define the **state** and **behavior** of their instances. Behavior comes from methods defined in the class. State comes from instance fields declared inside the class.

Java is:

- **Object Oriented** - Everything is an object in Java, everything inherits from the `Object` class.

- **Platform Independent** - Because Java is compiled into byte code, it is not locked down to a specific machine. Instead, it can be distributed online and interpreted by the JVM on whichever platform it is run on.

- **Multithreaded** - Programs can be built to perform many tasks simultaneously, meaning applications can run smoothly.

- **Architecture-neutral** - The compiler generates an architecture-neutral file format, which makes the code executable on many processors when using the Java runtime system.
___

<a name="member"></a>
## Class Members
A member of a class can be a:
- Variable
- Method

Class members are defined in the body of a class:

``` java
public class test{
  String member;  // member variable
  String member2; // member variable
  int member3;    // member variable

  // member method
  public void getMember(){
    return this.member;
  }
}
```
___

<a name="packages"></a>
## Packages

End of a domain name (.com, .co.uk), is the start of a package name.

Package names go **Domain** > **Company Name** > **Package Name**.

e.g. com.qa.packageName
___

<a name="condition"></a>
## Conditionals
**Difference between “&&/||” and “&/|”.**

If (False && True) - && won’t check second condition because it knows it will evaluate to false overall.

If (True || False) - || Won’t check second condition because the whole expression already evaluates to True.

&& and || are more efficient than & and |, but sometimes you want to check both conditions regardless. So you would use & and | in that case.
___

<a name="scope"></a>
## Scope
The 3 types of scope are:
- Method.
- Class.
- Loop.

Method declarations only exist within the method itself, and can only be accessed by the method.

Class scope declarations are accessible by any methods in the class and persist with the class or object.

Loop declarations only exist within the loop itself, and can only be accessed by the loop.

Curly braces are a good indicator of scope.

Scope has priority. From highest to lowest, it is **loop**, then **method**, then **class**. When looking for a variable, the code will look for it in a loop, then a method, then a class.
___
<a name="modifiers"></a>
## Access Modifiers

The four access modifiers in Java are:

- **Private** - Variables/methods that are private can only be accessed from within the class ion which they are defined.

 - **Default** - Variables/methods with the default modifier can only be accessed from within the package in which they are defined. If you don't define an access level, it is default.

  - **Protected** - Variables/methods that are protected can be accessed from within the package, and from outside of the package **through a child class only**.

  - **Public** - Variables/methods that are public can be accessed everywhere.
___

<a name="oop"></a>
## Pillars of OOP

<a name="abstraction"></a>
## Abstraction
Abstraction is the process of hiding implementation details and showing only the functionality to the user. 

To drive a car, you don't need to know how the engine works, you just need to be able to operate the steering, pedals etc (the interfaces).

The two ways to achieve abstraction are:

- Abstract classes
- Interfaces

<a name="abstract"></a>
### Abstract Classes
Abstract classes are declared by using the `abstract` keyword before a class definition. Abstract methods are declared in the same way.

They can have both abstract and non-abstract (concrete) methods, but must have at least one abstract method to be considered an abstract class.

Abstract classes cannot be instantiated, they must be extended by another class, which must implement its method.

Abstract classes can have constructors and static methods.

``` java
abstract class Car {
  abstract void drive(); // no method body
}
class Alfa extends Car { // class implements abstract method
  void drive() {
    System.out.println("Driving...");
  }
}
public static void main(String[] args) {
  Car alfaBrera = new Alfa();
  alfaBrera.drive();
}
```
<a name="interfaces"></a>
### Interfaces
An interface is a blueprint of a class. It has **static** constants and **abstract** methods.

Interfaces can **only** contain abstract methods with no method body.

Interfaces represent  the **IS-A relationship**.

Interfaces cannot be instantiated.

The three main reasons to use an interface are:

- It achieves abstraction.
- It supports multiple inheritance.
- It can be used to achieve loose coupling.

An interface is declared by using the interface keyword. It provides total abstraction, meaning all the methods in an interface are declared with an empty body, and all the fields are public, static and final by default. 

A class that implements an interface **must** implement **all** the methods declared in the interface.

``` java
interface someInterface {
  void someMethod();
  // methods are public and abstract by default
}
```
A class must use the `implements` keyword to use an interface.
`public class someClass implements someInterface {}`

If a class implements multiple interfaces, or an interface extends multiple interfaces, it is known as **multiple inheritance**.

Multiple inheritance:
` class someClass implements someInterface, someOtherInterface{}`

Interface Inheritance:
``` java
interface someInterface {
  void someMethod();
}

interface someOtherInterface extends someInterface {
  void someOtherMethod();
}

// This class can use methods from both interfaces
class someClass implements someOtherInterface {
  public void someMethod(){};
  public void someOtherMethod(){};

  public static void main(String[] args) {
    SomeClass obj = new SomeClass();

    obj.someMethod();
    obj.someOtherMethod();
  }
}
```
___

<a name="encapsulation"></a>
## Encapsulation
Where methods and classes own their own variables. 
- Uses the private, default, and protected keywords in classes to secure data. 
- Uses public methods, getters and setters, to access private data.

4 types of encapsulation with 4 types of access.

Public – No scope restrictions.
Default – Subclass and world variables cannot be accessed.
Protected – Less restrictive than default. Only world scope is inaccessible.
Private – Only things in the same class can be accessed.

Benefits:

- The fields of a class can be made read or write-only.
- A class can have total copntrol over what is stored in its fields.
___

<a name="inheritance"></a>
## Inheritance
Where a subclass includes methods and variables from a superclass.
Java uses the extends keyword to denote inheritance:

`public class A extends B {}`

A subclass inherits all the members from a superclass, **except** for the constructor (a constructor is not a member of a class). Using the `super` keyword allows a subclass to invoke the superclasse's constructor.

The `super` keyword is also used to differentiate the members of a superclass from those of a subclass, if they have the same name.

Syntax:

``` java
super.variable
super.method();
```

The `instanceof` keyword can be used to check if a subclass inherits from a superclass. It will return `true` or `false`.

`someClass instanceof SomeSuperClass`

Java does not support multiple inheritance:

`public class IllegalClass extends SomeClass, SomeOtherClass {}` is illegal.

Multiple inheritance can be achieved using interfaces.
___

<a name="polymorphism"></a>
## Polymorphism
Polymoprphism is when an object takes on many forms. Subclasses can define their own unique behaviours while inheriting the same functionality of a superclass.

Objects that have more than one **IS-A** relationship are polymorphic. (Technically all objects in Java are polymorphic as they will pass this test for their own type and for the "Object" class).

``` java
public interface Manual{}
public class Vehicle{}
public class Car extends Vehicle implements Manual{}
```

The `Car` class is polymorphic becuase of its multiple inheritance, and becuase it passes multiple **IS-A** tests.

- Car IS-A Manual
- Car IS-A Vehicle
- Car IS-A Car
- Car IS-A Object`

Using reference variables, an object of the `Car` class can be assigned to a different class or interface.

``` java
Car car = new Car();
Vehicle v = car;
Manual m = car;
Object o = car;
```

Two concepts: Over**loading** and Over**riding**.

Overloading is when you have two constructors or methods with the same name, that take a different number of parameters. The one that runs depends on how many parameters are passed in the method call.

``` java
public int add(int a, int b){} // method 1
public int add(int a, int b, int c){} // method 2

System.out.println(add(40, 2)); // Calls method 1
System.out.println(add(30, 8, 4)); // Calls method 2
```
The method signatures are the same, so the one that is called is the one that has the matching number of parameters.

Overriding occurs if a subclass calls a method with the same name as a method in the superclass. The method in the subclass runs, overriding the one in the superclass. The version of a method that runs depends on which object is used to call it.

``` java
public class SuperClass {
  public void method();
}
public class SubClass extends SuperClass {
  public void method(); // This will be called
}

SubClass sub = new SubClass();
sub.method(); // Calls subclass method, overriding superclass method
```
___

<a name="static"></a>
## "Static" Keyword
When a method or variable is static it exists in a single location.
This is shared among all instances of the same class.
Using static variables saves memory in a program.

Static variables and methods belong to a class, not an instance of that class.
To access something in a non-static way, create an instance of it.

``` java
public class App {
main(){
App app = new App();
app.someMethod();
    }
}
```

The Java `main()` method is static because you don't need an object to call a static method. If it weren't static, the JVM would need to create an object before calling `main()`, using unnecessary memory. 
___

<a name="lambda"></a>
## Lambda Expressions
A Java lambda expression is a function that doesn’t belong to any class. It can be passed around as if it was an object. 

Syntax: `parameter -> expression body`

Important features:

- Optional type declaration − No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.

- Optional parenthesis around parameter − No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.

- Optional curly braces − No need to use curly braces in expression body if the body contains a single statement.

- Optional return keyword − The compiler automatically returns the value if the body has a single expression to return the value. Curly braces are required to indicate that expression returns a value.

Lambda expressions are mainly used to define inline implementation of a functional interface (an interface with only one method). 

Lambdas can also be used to reference a `final` variable (which is assigned only once).
___

<a name="streams"></a>
## Streams
Always try to use a stream in place of a for loop when possible.

Elements in a stream do not persist when the stream is finished.

- `.filter()` – uses a lambda function ( `->` ) with a conditional check ( `!string.isEmpty()` ) to create a new filtered list based on whatever the condition is. In this example, the filtered list will only contain elements that are not empty.

- `.collect()` – Processes the stream elements and accumulates them into a "mutable result container." Takes a function as a parameter to do something with the results in the container. Accepts `Containers.toList()`, `.toSet()`, `.toMap()` and more.

- `Container.toList()` - When passed to `.collect()`, returns a new list. Syntax: `someList.stream().collect(Collectors.toList);`

- `.reduce()` – Reduces a stream of elements into a single element. Useful for adding all numbers in a stream.

- `.sorted()` – Sorts data in a stream into alphanumeric order. (0-9, A-Z).

- `.map()` – Manipulate list items using a lambda function.

``` java
List<String> strings = Arrays.asList(“abc”, “”, “bc”, “efg”, “”);

List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

List<Integer> myList = new ArrayList<Integer>();
myList = {42, 6, 3, 44, 2};

myList.stream().sorted().forEach(System.out::println);
myList.stream().filter(element -> element %2 == 0).collect(Collectors.toList()); 
myList.stream().map(num -> num * 10).forEach(System.out::println);
```
___

<a name="garbage"></a>
## Garbage Collection
Done automatically in Java. The garbage collector looks at objects in the heap. Objects that have references that point to them are in use, and those that don't aren't. The garbage collector removes objects that aren't in use, freeing up memory.
___

<a name="debugging"></a>
## Debugging
Errors cause code to stop execution and cause exceptions, bugs do not.

Breakpoints can be set on specific lines of code. When run, the program will pause on these breakpoints, allowing a developer to inspect the code.

Code can then be "stepped through" and the valueof variables etc. can be "watched". This is useful for debugging logical errors (unexpected output for example).

<a name="exceptions"></a>
### Exceptions
An exception in Java is an problem that appears when a program is executed and stops the flow of exceution. 

There are two types of exceptions, **checked** and **unchecked**.

Checked exceptions are known to the compiler at compile time. The compiler notifies the programmer at compile time and they should be handled by the programmer.

Examples include:

- ClassNotFoundException - the program tries to access a class that isn't defined.
- FileNotFoundException - a file is not accessible or doesn't open.
- NoSuchMethodException - a class doesn't contain the method called.

Unchecked exceptions occur at runtime and are ignored at compile time. This includes logic errors, or improper use of an API.

Examples include: 

- ArithmeticException - trying to divide by zero.
- ArrayIndexOutOfBoundsException - trying to access an element in an array that is outside of that array.

There are two ways of handling exceptions, using **try/catch** statements, or **throwing** them.

Syntax:

``` java
try {
  // do something
} catch (someException e) {
  // handle the exception, usually print an error message
}
```
Multiple `catch` blocks can be used to catch different types of exception, and are written like multiple `else if` statements.

Multiple types of exception can also be handled in a single `catch` block, since Java 7, by piping them together:

``` java
catch (IOException|FileNotFoundException e) {
  // handle exception
}
```

At the end of a try/catch block you can use the optional `finally` block. This always exectues regardless of the outcome of the try/catch block.

To throw an exception, append the keyword `throws` at the end of a method signature. This method will not handle the exception and has to declare as such.

The method then uses the `throw` keyword to explicitly invoke an exception.

Syntax:

``` java
public void someMethod() throws FileNotFoundException {
  throw new FileNotFoundException();
}
```

The `throws` keyword is used to declare that this method will create but not handle an exception, while the `throw` keyword is used to actually create and invoke the exception.

A method can declare that is throws multiple exceptions by putting them in a comma seperated list at the end of the method signature:

```public void someMethod() throws FileNotFoundException, IOException {}```
___

<a name="design"></a>
## Design Patterns
Represent the best practices developed and used by experienced OO developers.

Usually solutions to common problems in development. Can be thought of as templates for better code.

Primarily based on two principles of OOP:

- Program to an interface, not an implementation.
- Favour object composition over inheritance.

Design patterns fit into one of these three categories:

- **Creational Pattern** – Creating objects while hiding the logic behind the creation. This gives programs more flexibility in deciding which objects need to be created for a given use case.

- **Structural Pattern** – Focussed on the way classes and objects are structured. Aims to use inheritance and interfaces to define the composition of objects for new functionality.

- **Behavioural Pattern** – Focussed on the communication between objects.

There are many design patterns within these 3 categories. Examples include:

-  **Singleton Pattern** (Creational) - One of the simplest design patterns. Involves a single class which is responsible for creating only one object. This object can be accessed directly without needing to create an object of the class.

Syntax: 

``` java
public class SingleObject {
  // Create an object of the class
  private static SingleObject instance = new SingleObject();

  // Make a private constructor, so the class cannot be instantiated
  private SingleObject(){}

  // Get the only obejct available
  public static SingleObject getInstance() {
    return instance;
  }

  // Declare any methods the object has
}

public static void main(String[] args) {
  // can't use new keyword becuase of private constructor
  SingleObject object = SingleObject.getInstance();

  // Call any methods on object using object.someMethod();
}
```

- **Decorator Pattern** (Structural) - Allows a user to add functionality to an existing object without altering its structure. Creates a decorator class which acts as a wrapper to the original class to provide extra functionality.

Syntax:

``` java
// create an interface
public interface Shape {
  void draw();
}

// create concrete classes implementing the interface
public class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Shape: Rectangle");
  }
}

public class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Shape: Circle");
  }
}

// create abstract decorator class implmenting the same interface
public abstract class ShapeDecorator implements Shape {
  // declare a shape to decorate
  protected Shape decoratedShape;

  // create a constructor for the decorated shape
  public ShapeDecorator(Shape decoratedShape) {
    this.decoratedShape = decoratedShape;
  }

  // draw the shape using the interface's draw() method
  public void draw() {
    decoratedShape.draw();
  }
}

// create a concrete decorator class extending the ShapeDecorator class
public class BlueShapeDecorator extends ShapeDecorator {
  // construct a new shape to decorate
  public BlueShapeDecorator(Shape decoratedShape) {
    super(decoratedShape);
  }

  @Override
  public void draw() {
    decoratedShape.draw();
    // call method to decorate shape
    setBlueBorder(decoratedShape);
  }

  // method to decorate the shape
  public void setBlueBorder(Shape decoratedShape) {
    System.out.println("Border colour: blue");
  }
}

// use the BlueShapeDecorator class to decorate Shape objects
public static void main(String[] args) {
  Shape circle = new Circle();
  Shape blueCirlce = new BlueShapeDecorator(new Circle());
  Shape blueRectangle = new BlueShapeDecorator(new Rectangle());

  circle.draw();
  blueCircle.draw();
  blueRectangle.draw();
}
```

- **Memento Pattern** - (Behavioural) - Used to restore the state of an object to a previous state. Uses three actor classes:

  - **Memento** class - Contains the state of an object to be restored.
  - **Originator** class - Creates and stores states in Memento objects.
  - **Caretaker** class - Restores an object's state from Memento class.

Syntax: 

``` java
// create memento class
public class Memento {
  private String state;

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}

// create Originator class
public class Originator {
  private String state;

  public void setState(String state) {
    this.state = state;
  }

  public void getState() {
    return state;
  }

  // create new Memento object to store the state
  public Memento saveStateToMemento() {
    return new Memento(state);
  }

  public void getStateFromMemento(Memento memento) {
    state = memento.getState();
  }
}

// create CareTaker class
public class CareTaker() {
  private List<Memento> mementoList = new ArrayList<Memento>();

  public void add(Memento state) {
    memntoList.add(state);
  }

  // get a memento from the list
  public Memento get(int index) {
    return mementoList.get(index);
  }
}

// use CareTaker and Originator objects

public static void main(String[] args) {
  Originator originator = new Originator();
  CareTaker careTaker = new CareTaker();

  // set the initial state
  originator.setState("State #1");
  // save the state to a memento
  careTaker.add(originator.saveStateToMemento());

  originator.setState("State #2");
  careTaker.add(originator.saveStateToMemento());

  originator.setState("State #3");
  careTaker.add(originator.saveStateToMemento());

  System.out.println("Current state: " + originator.getState()); // prints state #3

  originator.getStateFromMemento(careTaker.get(0));
  System.out.println("Initial State: " + originator.getState(); // prints state #1

  originator.getStateFromMemento(careTaker.get(1));
  System.out.println("Second state: " + originator.getState()); // prints state #2
}
```
___

<a name="database"></a>
## Database Connection

**C** – Create

**R** – Read

**U** – Update

**D** – Delete