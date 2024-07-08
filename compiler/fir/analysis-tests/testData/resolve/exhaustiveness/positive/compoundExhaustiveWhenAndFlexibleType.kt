// IGNORE_LIGHT_TREE

// FILE: Utils.java

public class Utils {
    public static E getEnum() {
        return null;
    }
}

// FILE: main.kt

enum class E {
    A, B, C
}

fun test_1() {
    val s = when (val e = Utils.getEnum(); e) {
        null -> return
        E.A -> ""
        E.B -> ""
        E.C -> ""
    }
    s.length
}

fun test_2() {
    val s = when (val e = Utils.getEnum(); e) {
        E.A -> ""
        E.B -> ""
        E.C -> ""
    }
    s.length
}