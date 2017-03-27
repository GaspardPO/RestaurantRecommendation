import exceptions.RestaurantException
import java.io.File

fun parseFile(filePath: String): MutableList<Restaurant> {

    val file = File(filePath)
    if(! file.isFile){
        throw RestaurantException()
    }

    val arrayList = arrayListOf<Restaurant>()

    val lines = file.readLines()
    for (i in lines.indices step 5){
        arrayList.add(createRestaurantFromLines(i, lines))
    }

    return arrayList
}

private fun createRestaurantFromLines(i: Int, lines: List<String>): Restaurant {
    val name = lines[i]
    val rating = lines[i + 1].toFloat()
    val priceCategory = lines[i + 2]
    val tags = lines[i + 3].split(", ").toSet()
    val newRestaurant = Restaurant(name, rating, priceCategory, tags)
    return newRestaurant
}