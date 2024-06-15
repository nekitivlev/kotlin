fun box(): String {

        try {
            when (val a = 10; val b = 0; val result = a / b; result) {
                null -> return "FAIL"
                else -> return "OK"
            }
        } catch (e: Exception) {
            return "OK"
        }


}