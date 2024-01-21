import java.lang.IllegalArgumentException

fun main(args: Array<String>){
    print("Hello world!\n") // standard output

    println("Hello world 2!") // output with line break >> Hello world!\n

//    print(sum(4, 5))

//    helloWorld()

//    helloWorld2()

    println(multiply(5, 7))

    print(upper("Hello world!"))
}

fun sum(a: Int, b: Int): Int{
    return a + b
}

fun multiply(a: Int, b: Int): Int = a * b // body can be expression

fun upper(s: String) = s.uppercase() // type is inferred

fun helloWorld(): Unit{ // for function that returns no meaningful value
    print("\nhello world func!")
}
fun helloWorld2(){ // Unit can be omitted
    print("\nhello world func 2!")
}


fun typeNothin(): Nothing{ // for exception
    throw IllegalArgumentException()
}