fun test() {
    var str = "this is top level"

    run {
        val str = "new scope"
        println(str)
    }
    println(str)
}

test()
