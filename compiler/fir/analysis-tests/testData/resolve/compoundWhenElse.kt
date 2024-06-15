enum class A {
    A1,
    A2,
}
class B()
class C(val b : B)
fun get(f: Boolean) = if (f) {A.A1} else {""}

<!CONFLICTING_OVERLOADS!>fun case2()<!> {

    val l1 = <!NO_ELSE_IN_WHEN!>when<!> (val flag: Any = get(false); flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) { // should be NO_ELSE_IN_WHEN
        A.A1 -> B()
        A.A2 -> B()
    }

    val l2 = <!NO_ELSE_IN_WHEN!>when<!> (val flag: Any = get(false); flag) {// should be NO_ELSE_IN_WHEN
        A.A1 -> B()
        A.A2 -> B()
    }
}

<!CONFLICTING_OVERLOADS!>fun case2()<!> {

    val l1 = <!NO_ELSE_IN_WHEN!>when<!> (val flag: Any = get(true); flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {// should be NO_ELSE_IN_WHEN
        A.A1 -> B()
        A.A2 -> B()
    }

    val l2 = <!NO_ELSE_IN_WHEN!>when<!> (val flag: Any = get(true); flag) {// should be NO_ELSE_IN_WHEN
        A.A1 -> B()
        A.A2 -> B()
    }
}

fun case3() {

    val l1 = <!NO_ELSE_IN_WHEN!>when<!> (val flag = ""; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {// should be NO_ELSE_IN_WHEN
        <!INCOMPATIBLE_TYPES!>A.A1<!> -> B() //should be INCOMPATIBLE_TYPES
        <!INCOMPATIBLE_TYPES!>A.A2<!> -> B() //should be INCOMPATIBLE_TYPES
    }

    val l2 = <!NO_ELSE_IN_WHEN!>when<!> (val flag = ""; flag) {// should be NO_ELSE_IN_WHEN
        <!INCOMPATIBLE_TYPES!>A.A1<!> -> B() //should be INCOMPATIBLE_TYPES
        <!INCOMPATIBLE_TYPES!>A.A2<!> -> B() //should be INCOMPATIBLE_TYPES
    }
}
