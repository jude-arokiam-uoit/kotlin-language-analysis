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

> _Organize your report according to the project description
document_.
