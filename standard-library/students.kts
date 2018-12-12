class Student(
    val name: String,
    val surname: String,
    val passing: Boolean,
    val averageGrade: Double
)

val students: MutableList<Student> = mutableListOf<Student>()

students.add(Student("Jude", "Arokiam", true, 4.3))
students.add(Student("John", "Smith", false, 1.3))
students.add(Student("Jane", "Doe", true, 3.7))
students.add(Student("Jacky", "Chan", true, 4.1))


val result = students.filter { it.passing && it.averageGrade > 4.0 } // 1
    .sortedBy { it.averageGrade } // 2
    .take(10) // 3
    .sortedWith(compareBy({ it.surname }, { it.name })) // 4

for (person in result) println(person.name)
