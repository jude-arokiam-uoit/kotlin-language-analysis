fun totalLetters(name: String, surname: String): Int {
  return name.length + surname.length
}

val name: String = "Jude"
var surname: String

surname = "Watson"

if (name.length > 3) {
  surname = "Arokiam"
  println(name + " " + surname)
} else {
  println(totalLetters(name, surname))
}
