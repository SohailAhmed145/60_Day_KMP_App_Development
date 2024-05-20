package Day_1_Kotlin_Basics

fun collections(){

    //LIST

    //to access any item in list
    val readOnlyShapes = listOf("triangle", "square", "circle")
    println("The first item in the list is: ${readOnlyShapes[0]}")

    //To get the first or last item in a list, use .first() and .last() functions respectively.
    println("The first item in the list is: ${readOnlyShapes.first()}")
    println("The first item in the list is: ${readOnlyShapes.last()}")

    //To get the number of items in a list, use the .count() function:
    println("This list has ${readOnlyShapes.count()} items")

    //To check that an item is in a list, use the in operator:
    println("circle" in readOnlyShapes)

    //To add or remove items from a mutable list, use .add() and .remove() functions respectively.
    val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
// Add "pentagon" to the list
    shapes.add("pentagon")
    println(shapes)

// Remove the first "pentagon" from the list
    shapes.remove("pentagon")
    println(shapes)

    //SET

    // Read-only set
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    // Mutable set with explicit type declaration
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    println(readOnlyFruit)

    //To get the number of items in a set, use the .count() function:
    println("This set has ${readOnlyFruit.count()} items")

    println("banana" in readOnlyFruit)

    fruit.add("dragonfruit")    // Add "dragonfruit" to the set
    println(fruit)              // [apple, banana, cherry, dragonfruit]

    fruit.remove("dragonfruit") // Remove "dragonfruit" from the set
    println(fruit)

    //MAP

// Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu)


// Mutable map with explicit type declaration
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(juiceMenu)
//access any item
    println("The value of apple juice is: ${readOnlyJuiceMenu["apple"]}")

    // total number count
    println("This map has ${readOnlyJuiceMenu.count()} key-value pairs")

    //To add or remove items

    juiceMenu.put("coconut", 150) // Add key "coconut" with value 150 to the map
    println(juiceMenu)

    juiceMenu.remove("orange")    // Remove key "orange" from the map
    println(juiceMenu)

    //To check if a specific key is already included in a map, use the .containsKey() function:
    println(readOnlyJuiceMenu.containsKey("kiwi"))

    // To obtain a collection of the keys or values of a map, use the keys and values properties respectively:
    println(readOnlyJuiceMenu.keys)
    println(readOnlyJuiceMenu.values)

    //to check keys and values if exist in map
    println("orange" in readOnlyJuiceMenu.keys)
    println(200 in readOnlyJuiceMenu.values)
}

fun main() {

    collections()

}















