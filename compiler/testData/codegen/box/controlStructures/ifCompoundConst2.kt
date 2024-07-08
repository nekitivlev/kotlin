fun foo(b: Boolean): String {
    return if (val a = !b; a) {
        "fail: reached unexpected code at line 3"
    } else if (false) {
        "fail: reached unreachable code at line 5"
    } else if (true) {
        "OK"
    } else if (true) {
        "fail: reached unreachable code at line 9"
    } else if (a) {
        "fail: reached unreachable code at line 11"
    } else {
        "fail: reached unreachable code at line 13"
    }
}

fun box(): String {
    return foo(true)
}
