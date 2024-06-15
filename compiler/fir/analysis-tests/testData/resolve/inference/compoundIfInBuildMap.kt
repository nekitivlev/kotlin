// WITH_STDLIB

fun main() {
    buildMap {
        if (val t = false; !t) {
            println("test")
        } else {
            put("foo", "bar")
        }
    }
}