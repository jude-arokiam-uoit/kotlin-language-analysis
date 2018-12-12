# _Kotlin Language Analysis_

- _Jude Arokiam_
- _jude.arokiam@uoit.net_

## About the language

JetBrains started the Kotlin project in 2010 and released the first version in 2016. Kotlin supports both functional and object oriented constructs.

## About the syntax

### Defining variables

There are two variables available: `val` (immutable) and `var` (mutable). JetBrains recommends using `val` whenever possible.

```kotlin
/* notice comments are the same as Java */
val num = 10          // notice type is not needed
val otherNum: Int = 5 // can still include for readability but optional
val laterNum: Int     // or can defer assignment later but must include type
laterNum = 2


/*Reassigning `var` variables is similar to Java as well*/
var reNum = 7
reNum -= 3              // simply assign new value
```

### Checking for null
Functions can only return `null` if explicitly specified. Compiler will give an error if `null` return value is possible.

```kotlin
// cannot return a null value
fun canNotBeNull(a: Int, b: Int) :Int {
	return a + b
}

// specify a null value can be returned with `?`
fun canBeNull(a: Int, b: Int) :Int? {
	if (a > b) return null else return a + b
}
```

### When expression
Kotlin's approach to switch statements is very easy to read and write.

```kotlin
when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}
```

## About the tools

Kotlin can be used for many purposes such as:
* Android development
* Server-side development
* Web development
* Native applications

### Android
Google has made Kotlin an officially supported language and therefore natively supported by their IDE Android studio. To program in Kotlin, simply create a new project and select `enable Kotlin support`.

### Command line compiler
The compiler can be installed following the instructions from the official Kotlin website. Once installed the files created should end with the extension `.kt`. To manually run files created the following command can be used to create a jar file. The jar file can be run using the usual JVM method. Similar commands can also be run for developing a library and running scripts. A REPL can be used by running the compiler without arguments.

```console
$ kotlinc hello.kt -include-runtime -d hello.jar
$ java -jar hello.jar
```

Manually typing out these commands to run your programs is not that useful for large scale projects. An IDE that utilizes the Kotlin compiler should be used for any kind of serious work. In recent versions of IntelliJ, Kotlin support is natively supported. The compiler is already bundled in with the IDE. Start a new Java project and select the Kotlin SDK. Eclipse is also supported but the Kotlin plugin must first be installed from the marketplace.

### Build tools
Any projects that utilize the JVM can use the major build tools available:
* Gradle
* Maven
* Ant

## About the standard library

The Kotlin standard library provides many useful functions for everyday programming. Jetbrains has categorized them as:
* Higher order functions
* Collections and lazy sequences
* String manipulations
* Extensions for JDK classes

### Run

Run is a simple way to create new scopes

```kotlin
fun test() {
    var str = "this is top level"

    run {
        val str = "new scope"
        println(str)
    }
    println(str)
}
```

Output:
```console
> new scope
> this is top level
```

### List, sets and maps

```kotlin
// this is a list
val list = listOf(1, 2, 3, 2)

// this is a set
val uniqueNum = setOf(1, 2, 3)

// this is a map with type : Map<String, String>
val students = hashMapOf("first name" to "John", "last name" to "Smith")
```

### Lazy sequence

```kotlin
val list = listOf(1, 2, 3, 4, 5, 6)
val result = list.asSequence()
        .map{ println("In Map"); it * 2 }
        .filter { println("In Filter");it % 3  == 0 }
println("Before Average")      // prints right away
println(result.average())      // result is computed here
```

### Reading files

All Java libraries are available to use but Kotlin has some simple functions for quick file manipulation. The maximum file size is 2 GB.

```kotlin
val strFile = File("file.txt").readText(Charsets.UTF_8)
```

## About open source library

### Kotson library

_Kotson enables you to parse and write JSON with Google's Gson using a conciser and easier syntax._

_Kotson is a set of extension functions, meaning that it adds utility functions and syntactic sugars to Gson in Kotlin. It does not add new features to Gson nor does it creates new types. It is therefore usable on any Gson object, whether created from java or kotlin in source or library._

Please see the official github page for the official github: https://github.com/SalomonBrys/Kotson

### How to setup

Simply add the dependencies in Maven or Gradle.

### Useful features

Many of JSON related tasks require significantly less code compared to both Java and Kotlin. This allows the developer to focus more on what they are trying to do rather than what code they need.

```kotlin
import com.github.salomonbrys.kotson.*

// java: int greenComp = json .getAsJsonObject()
//                            .getAsJsonObject("colors")
//                            .getAsJsonArray("orange")
//                            .get(1)
//                            .getAsInt();

val greenComp = json["colors"]["orange"][1].int
```

# Analysis of the language

## Functional vs procedural programming

Kotlin provides both procedural and functional programming constructs. Most of the object oriented functionality Java provides can be found in Kotlin as well. The basic syntax of the language is also simpler and is not as strongly typed. Little things such as preventing functions from returning null or not needing to call `get` and `set` function from java classes immediately makes the code more readable and faster to implement.

Although Kotlin is strong in its object oriented features, it provides many functional programming constructs that can be taken advantage of. Some of the useful features Kotlin provides are lazy evaluation, returning a function and giving a function as an argument. These types of feature gives more control and opportunity for good programmers to create cool projects.

Here is an example of nice functional programming in Kotlin.

```kotlin
class Student(
    val name: String,
    val surname: String,
    val passing: Boolean,
    val averageGrade: Double
)
```

```kotlin
students.filter { it.passing && it.averageGrade > 4.0 } // 1
    .sortedBy { it.averageGrade } // 2
    .take(10) // 3
    .sortedWith(compareBy({ it.surname }, { it.name })) // 4
```

_Example taken from:_ https://medium.freecodecamp.org/my-favorite-examples-of-functional-programming-in-kotlin-e69217b39112

## Meta-programming

Kotlin currently does not support macros.

## Symbols resolution and closure

Immediate symbol resolution or lazy evaluation is available. The syntax varies greatly and makes it clear to the programmer what they are trying to do. Closure is also supported and behaves similar to Clojure.

## Scoping

Dynamic scoping is not supported in Kotlin and therefore only lexical scoping can be used.

## Functional programming constructs

There are many programming constructs available to use but Kotlin does not force the programmer to use them. There is almost always an object oriented approach that is viable. Here are some of the common constructs one can use:
* let
* run
* apply
* lazy evaluation
* anonymous functions

## Types

Both static and dynamic types are both supported. Throughout the Kotlin reference site, you are encouraged to use static whenever possible.

## Strengths and weaknesses

Kotlin is a relatively new language that has been adopted quiet quickly. This must be because there are enough strengths to the languages that lure programmers to switch over. Perhaps the best feature Kotlin provides is its compatibility with Java and the JVM. This allows Kotlin to seamlessly integrate with existing projects without breaking them. This is part of the reason Android application have become the main use for the language. In addition to the its compatibility, Kotlin provides an easy to learn, write, and read syntax. Java is strongly typed and hated because of this. Being able to provide the same functionality with nicer looking code is a very good thing. Programmers who use Kotlin have the choice to use object oriented coding style or mix in functional. This makes the learning curve less steep but provides enough power for advanced users.

Being a general purpose language that seems to do it all must have some downsides. Right from the beginning one can see that Kotlin is slow. Whether it be using the compiler to convert to a jar, or using the compiler to run scripts, or building in Gradle with Android Studio, or even simply using the REPL. Kotlin is very slow in comparison to Java and even Clojure. Running the command line compiler would lag for a few seconds even for the simple hello world program. Comparing the Gradle build times of a fully Java project to Kotlin sees a significant difference as well.

For the time being, I am going to stick with Java for Android development due to the reasons mentioned above. But perhaps the biggest reason to consider whether to use Kotlin over Java is that it does not force you to use functional programming constructs. Since its does everything Java can do in a nicer form, I found myself tempted to just program the object oriented way. This was especially true in cases where the functional programming required as much typing or more. In these cases, blocks of code could also be hard to read and unsuitable for larger teams that continuously add and remove team members.
