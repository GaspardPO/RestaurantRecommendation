data class Restaurant(val name: String, val rating: Float, val priceCategory: String, val tags: Set<String>) {
    constructor(name: String, rating: Float, priceCategory: String, tag: String ) : this(name, rating, priceCategory, setOf(tag))
}