fun <T> materialize(): T = throw Exception()

interface A

fun takeA(a: A) {}

fun test(b : Boolean) {
    takeA(if(val c = b; !c) materialize() else materialize())
}