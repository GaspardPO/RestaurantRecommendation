class RestaurantRecommander(val restaurants: List<Restaurant>) {

    fun recommand(priceCriteria: String? = null, cuisine: String? = null): String {

        return restaurants
                .filter { it.filterByPrice(priceCriteria) }
                .filter { it.filterByCuisine(cuisine) }
                .sortedByDescending(Restaurant::rating)
                .map(Restaurant::todisplay)
                .joinToString(separator = "\n")
    }

}

private fun Restaurant.filterByCuisine(cuisine: String?): Boolean = cuisine == null || this.tags.contains(cuisine)

private fun Restaurant.filterByPrice(priceCriteria: String?): Boolean = priceCriteria == null || this.priceCategory == priceCriteria

private fun Restaurant.todisplay(): String = name + " : " + rating
