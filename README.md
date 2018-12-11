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

> _Describe the compiler or interpreter needed_.

## About the standard library

> _Give some examples of the functions and data structures
> offered by the standard library_.

### Android async
Kotlin has a much easier way to create async tasks in Android.

## About open source library

> _Describe at least one contribution by the open source
community written in the language._

# Analysis of the language

> _Organize your report according to the project description
document_.
