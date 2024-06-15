fun foo() = if (true) 1 else 0

fun bar(arg: Int) {
    when (val res = arg; res + 10) {
        <!USELESS_IS_CHECK!>is Int<!> -> arg <!USELESS_CAST!>as Int<!>
        else -> 42
    }
}
