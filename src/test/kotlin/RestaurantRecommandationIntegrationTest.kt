import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class RestaurantRecommandationIntegrationTest{
    val RESOURCES_PATH = "src/test/resources/"

    @Test
    fun displayNameAndRatingForOneRestaurant() {
        val restaurantRecommander = RestaurantRecommander(parseFile(RESOURCES_PATH + "exampleFile"))
        assertThat(restaurantRecommander.recommand(priceCriteria = "$", cuisine = "fast food")).isEqualTo(
"""McDo : 70.0
Midi Délices : 50.0""")

        assertThat(restaurantRecommander.recommand(cuisine = "savoyard")).isEmpty()
    }

}

