interface Box<T>

public fun <T> foo(nextFunction: (T) -> T): Box<T> = null!!

fun leaves(value: String, forward: Boolean): Box<String> {
    if (val x = forward; <!SENSELESS_COMPARISON!>x!= null<!>) {
        return foo { "" }
    } else {
        return foo { "" }
    }
}
