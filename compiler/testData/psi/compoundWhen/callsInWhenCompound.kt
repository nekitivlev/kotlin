fun foo() {
    when (val a = true; a) {
        a.foo -> a
        a.foo() -> a
        a.foo<T> -> a
        a.foo<T>(a) -> a
        a.foo<T>(a, d) -> a
        a.{bar} -> a
        a.{!bar} -> a
        a.{ -> !bar} -> a
        else -> a
    }
}