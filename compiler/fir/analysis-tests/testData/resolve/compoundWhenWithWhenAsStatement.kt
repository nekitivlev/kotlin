fun test(value: Int) {
    when (val t = value+10; t + 10) {
        0 -> {}
        1 -> when (val x = t; x + 1) {
            2 -> false
        }
    }
}