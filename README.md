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
```

Manually typing out these commands to run your programs is not that useful for large scale projects. An IDE that utilizes the Kotlin compiler should be used for any kind of serious work. In recent versions of IntelliJ, Kotlin support is natively supported. The compiler is already bundled in with the IDE. Start a new Java project and select the Kotlin SDK. Eclipse is also supported but the Kotlin plugin must first be installed from the marketplace.

### Build tools
Any projects that utilize the JVM can use the major build tools available:
* Gradle
* Maven
* Ant

## About the standard library

> _Give some examples of the functions and data structures
> offered by the standard library_.


## About open source library

> _Describe at least one contribution by the open source
community written in the language._

# Analysis of the language

> _Organize your report according to the project description
document_.
