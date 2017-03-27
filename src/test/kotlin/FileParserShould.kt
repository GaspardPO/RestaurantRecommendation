import exceptions.RestaurantException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FileParserShould {

    val RESOURCES_PATH = "src/test/resources/"

    @Test(expected = RestaurantException::class)
    fun throwAnExceptionWhenNoFile() {
        parseFile(RESOURCES_PATH + "noFile")
    }

    @Test(expected = RestaurantException::class)
    fun throwAnExceptionWhenDirectory() {
        parseFile(RESOURCES_PATH + "leDirectory")
    }

    @Test
    fun returnAnEmptyListWhenEmptyFile() {
        assertThat(parseFile(RESOURCES_PATH + "emptyFile")).hasSize(0)
    }

    @Test
    fun returnARestaurantWhenOneInFile() {
        assertThat(parseFile(RESOURCES_PATH + "oneInFile")).containsExactly(Restaurant("leName", 50F, "$", "cuisineTag1"))
    }

    @Test
    fun returnTwoRestaurantsWhenTwoInFile() {
        assertThat(parseFile(RESOURCES_PATH + "twoInFile")).containsExactly(Restaurant("leName", 50F, "$", "cuisineTag1"), Restaurant("McDo", 70F, "$", "fast food"))
    }

    @Test
    fun returnARestaurantWithTagList() {
        assertThat(parseFile(RESOURCES_PATH + "withTagList")).containsExactly(Restaurant("O Tokyo", 90F, "$", setOf("sushi", "halal", "fast food")))
    }

    @Test
    fun returnARestaurantWithDecimalRating() {
        assertThat(parseFile(RESOURCES_PATH + "decimalRating")).containsExactly(Restaurant("Shalizar", 82.5F, "$$", "iranian"))
    }
}

