package exceptions

class RestaurantException(msg: String? = null, key: String? = null, cause: Throwable? = null): Exception(msg, cause)