for (x in 1..21) {
  when (x) {
      in 1..10 -> println("x is in the range")
      !in 10..20 -> println("x is outside the range")
      else -> println("none of the above")
  }
}
