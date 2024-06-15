fun <T, R> T.also(block: () -> R): R {
    return null!!
}

fun foo(b: Boolean, a: Int) {
    val x = when (val t = b; !t) {
        true -> a
        else -> null
    }?.also {
        1
    }
}