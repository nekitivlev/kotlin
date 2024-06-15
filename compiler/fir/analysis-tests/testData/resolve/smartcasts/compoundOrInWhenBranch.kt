fun String.foo() {}

fun test_1(a: Any?) {
    when (val b = a; b) {
        is String, is Any -> a.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>foo<!>() // Should be Bad
    }
}

fun test_2(a: Any?) {
    if (val b = a ; b is String || b is Any) {
        a.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>foo<!>() // Should be Bad
    }
}

fun test_3(a: Any?, b: Boolean) {
    when (val c = a; c) {
        is String, b -> a.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>foo<!>() // Should be Bad
    }
}

fun test_4(a: Any?, b: Boolean) {
    if (val c = a; val d = b; c is String || d) {
        c.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>foo<!>() // Should be Bad
    }
}