// TARGET_BACKEND: JVM

fun StringBuilder.takeFirst(): Char {
    if (this.length == 0) return 0.toChar()
    val c = this.get(0)
    this.deleteCharAt(0)
    return c
}

fun foo(expr: StringBuilder): Int {

    if(val c = expr.takeFirst(); c.toChar() == 0) {
        throw Exception("zero")
    }else{
        throw Exception("nonzero" + c)
    }

}

fun box(): String {
    try {
        foo(StringBuilder())
        return "Fail"
    }
    catch (e: Exception) {
        return "OK"
    }
}