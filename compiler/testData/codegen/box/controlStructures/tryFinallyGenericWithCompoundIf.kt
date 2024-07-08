    // TARGET_BACKEND: JVM
// WITH_STDLIB

val stack = mutableListOf<Int>()

fun <E> MutableList<E>.pop() = this.removeAt(size - 1)

fun foo() {}

fun getBoolean(): Boolean = true

fun box(): String {
    if (val b = getBoolean(); b == true) {
        stack.add(1)
        try {
            return "OK"
        } finally {
            stack.pop()
        }
    } else {
        return "OK"
    }
    return "FAIL"
}
