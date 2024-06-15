// !DUMP_CFG

enum class SomeEnum {
    A1, A2;
}

class B()

fun takeB(b: B) {}

fun test_1() {
    val b: B = when (val flag = SomeEnum.A1; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {
        SomeEnum.A1 -> B()
        SomeEnum.A2 -> B()
    }
    takeB(b) // should be OK
}

fun test_2() {

    val b = when (val flag = SomeEnum.A1; flag<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) {
        SomeEnum.A1 -> B()
        SomeEnum.A2 -> B()
    }
    takeB(b) // should be OK
}

fun test_3() {
    val b = when (val flag = SomeEnum.A1;flag) { //there is no null-assertion! , no explicit type
        SomeEnum.A1 -> B()
        SomeEnum.A2 -> B()
    }
    takeB(b) // should be OK
}