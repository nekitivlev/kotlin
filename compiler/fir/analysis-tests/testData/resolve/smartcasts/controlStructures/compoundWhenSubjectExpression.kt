// DUMP_CFG

fun whenWithSubjectExpression(x: Any) {
    when (val y = x; y) {
        !is Double -> -1
        0.0 -> 0 // `subj` in `subj == 0.0` must have type 'double'
        else -> x.toInt()
    }
}

fun whenWithSubjectVariable(x: Any) {
    when (val y = x; y) {
        !is Double -> -1
        0.0 -> 0 // `subj` in `subj == 0.0` must have type 'double'
        else -> y.toInt()
    }
}