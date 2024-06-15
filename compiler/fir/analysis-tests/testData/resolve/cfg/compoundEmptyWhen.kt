// !DUMP_CFG
fun test_1() {
    when(val x = 5; x) {}
}

fun test_2(x: Int) {
    when (val y = x; x) {}
}

fun test_3(x: Int) {
    when (val y = x; val z = y; z) {}
}