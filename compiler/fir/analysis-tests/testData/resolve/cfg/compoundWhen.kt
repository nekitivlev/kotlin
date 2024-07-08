// !DUMP_CFG
fun test_1(x: Int) {
    val y = when(val z = x; z*1) {
        1 -> 10
        2 -> 20
        else -> 5
    }
}

interface A
interface B

fun test_2(x: Any?) {
    if (x is A && x is B) {
        <!USELESS_IS_CHECK!>x is A<!>
    }
}