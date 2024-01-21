// some net information
// Kotlin is statically typed language, in all moment when we do not specify type, Kotlin inferred type
// 'val' using for define Read-Only variable
// 'var' using for reassign able variable
// 'const' using for create variable that should be assigned in compile-time and that variable cannot be local
const val e: Int = 5;


fun main(){
    // VAL
    val a: Int = 5 // specify
    val b = 6 // inferred Int type by Kotlin auto
    val c: Int; // if we only initialize variable, we *must* specify tye
    c =7

    // VAR
    var d = 6
    d += 1

    print(d)


}


