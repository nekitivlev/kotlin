fun box(): String {
    try {
        if (val a = 10; val b = 0; val result = a / b; result == null) {
            return "FAIL"
        }else{
            return "OK"
        }
    } catch (e: Exception) {
        return "OK"
    }
    return "OK"
}
