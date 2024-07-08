
fun test_1(name: String?) {
    when (val x = name; x) {
        null -> return
    }
    name.length
}

fun test_2(name: String?) {
    when (val s = name; s?.length) {
        null -> return
    }
    name.length
}