import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class RestaurantRecommandationShould {

    val restaurantRecommander = RestaurantRecommander(
        listOf<Restaurant>(
            Restaurant("O Tokyo", 90F, "$$", setOf("sushi", "halal", "fast food")),
            Restaurant("McDo", 70F, "$", "fast food"),
            Restaurant("Shalizar", 82.5F, "$$$", "iranian"),
            Restaurant("Chavane", 77.7F, "$$", setOf("bio", "food truck")),
            Restaurant("Midi Délices", 50f, "$", setOf("food truck", "fast food"))
        )
    )

    @Test
    fun returnNameAndRatingForOneRestaurant() {
        val restaurantRecommanderWithOne = RestaurantRecommander(listOf<Restaurant>(Restaurant("O Tokyo", 90F, "$", setOf("sushi", "halal", "fast food"))))
        assertThat(restaurantRecommanderWithOne.recommand()).isEqualTo("O Tokyo : 90.0")
    }

    @Test
    fun returnNameAndRatingForSeveralRestaurantNoCriteria() {
        assertThat(restaurantRecommander.recommand()).isEqualTo(
"""O Tokyo : 90.0
Shalizar : 82.5
Chavane : 77.7
McDo : 70.0
Midi Délices : 50.0"""
        )
    }

    @Test
    fun returnNameAndRatingForSeveralRestaurantPriceCriteria() {
        assertThat(restaurantRecommander.recommand(priceCriteria = "$")).isEqualTo(
"""McDo : 70.0
Midi Délices : 50.0"""
        )
    }

    @Test
    fun returnNameAndRatingForSeveralRestaurantCuisineCriteria() {
        assertThat(restaurantRecommander.recommand(cuisine = "food truck")).isEqualTo(
"""Chavane : 77.7
Midi Délices : 50.0"""
        )
    }

    @Test
    fun returnNameAndRatingForSeveralRestaurantTwoCriterias() {
        assertThat(restaurantRecommander.recommand(priceCriteria = "$", cuisine = "fast food")).isEqualTo(
"""McDo : 70.0
Midi Délices : 50.0"""
        )
    }

    @Test
    fun returnEmptyStringWhenNoMatchingRestaurants(){
        assertThat(restaurantRecommander.recommand(cuisine = "savoyard")).isEmpty()
    }

    // todo : list of tags as criteria.
}

