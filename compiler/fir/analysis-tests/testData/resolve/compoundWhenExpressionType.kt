enum class A() {
    A1, A2;
}

class B()
class C(val b: B)

// TESTCASE NUMBER: 1
fun case1() {

    val l0: B = when (val flag = A.A1; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {
        A.A1 -> B()
        A.A2 -> B()
    }
    val x1 = C(l0) //ok (l0 is B)
}

// TESTCASE NUMBER: 2
fun case2() {

    val l0: B = when (val flag = A.A1; flag) {
        A.A1 -> B()
        A.A2 -> B()
    }
    val x1 = C(l0) //ok (l0 is B)
}

// TESTCASE NUMBER: 3
fun case3() {

    val l1 = when (val flag = A.A1; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {
        A.A1 -> B()
        A.A2 -> B()
    }
    val x1 = C(l1)
}

// TESTCASE NUMBER: 4
fun case4() {

    val l2 = when (val flag = A.A1; flag) {
        A.A1 -> B()
        A.A2 -> B()
    }
    val x2 = C(l2)
}


// TESTCASE NUMBER: 5
fun case5() {

    val l1 = when (val flag: Any = A.A1; flag) {
        A.A1 -> B()
        A.A2 -> B()
        else -> B()
    }
    val x1 = C(l1)
}


// TESTCASE NUMBER: 6
fun case6() {
    val l1 = when (val flag: Any = A.A1; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {
        A.A1 -> B()
        A.A2 -> B()
        else -> B()
    }
    val x1 = C(l1)
}

// TESTCASE NUMBER: 7
fun case7() {
    val l1: B = when (val flag: Any = A.A1; flag) {
        A.A1 -> B()
        A.A2 -> B()
        else -> B()
    }
    val x1 = C(l1)
}


// TESTCASE NUMBER: 8
fun case8() {
    val l1: B = when (val flag: Any = A.A1; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {
        A.A1 -> B()
        A.A2 -> B()
        else -> B()
    }
    val x1 = C(l1)
}

// TESTCASE NUMBER: 9
fun case9() {
    val l1 = <!NO_ELSE_IN_WHEN!>when<!> (val flag: Any = A.A1; flag) {
        A.A1 -> B()
        A.A2 -> B()
    }
    val x1 = C(l1)
}
