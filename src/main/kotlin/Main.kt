fun main() {
    // Create a new dictionary
    val dictionary = Dic()

    // Add some entries to the dictionary
    dictionary.addEntry(Ent("cat", "chat"))
    dictionary.addEntry(Ent("dog", "chien"))
    dictionary.addEntry(Ent("fish", "poisson"))
    dictionary.addEntry(Ent("bird", "oiseau"))
    dictionary.addEntry(Ent("mouse", "souris"))

    // Print the number of entries in the dictionary
    println("Number of entries: ${dictionary.numberOfEntries()}")

    // Remove an entry from the dictionary
    val removed = dictionary.removeEntry(Ent("cat", "chat"))
    if (removed) {
        println("Entry removed successfully.")
    } else {
        println("Entry not found in dictionary.")
    }

    // Remove an entry by its English word
    val removed2 = dictionary.removeEntry("dog")
    if (removed2) {
        println("Entry removed successfully.")
    } else {
        println("Entry not found in dictionary.")
    }

    // Add a new entry to the dictionary
    dictionary.addEntry(Ent("horse", "cheval"))

    // Print all the French words in the dictionary
    println("French words: ${dictionary.frenchWords()}")

    // Find all the English words equivalent to "oiseau"
    val equivalents = dictionary.frAn("oiseau")
    if (equivalents.isNotEmpty()) {
        println("English equivalents: ${equivalents.joinToString(", ")}")
    } else {
        println("No English equivalent found.")
    }

    // Print the dictionary as a string
    println("Dictionary: ${dictionary.toString()}")

    // Get a map of all the French words and their English equivalents
    val map = dictionary.dictionaryFrAn()
    for ((french, englishList) in map) {
        println("$french: ${englishList.joinToString(", ")}")
    }
}

fun String.isEmptyOrBlank(): Boolean {
    return this.isEmpty() || this.isBlank()
}
fun String.acronym(): String {
    return this.trim().split("\\s+".toRegex())
        .map { it.trim().first().toUpperCase() }
        .joinToString("")
}


