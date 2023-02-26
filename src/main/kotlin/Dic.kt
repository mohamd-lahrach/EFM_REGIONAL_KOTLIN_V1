
// Define a class for the English-French dictionary
class Dic {

    // ArrayList to store the dictionary entries
    private val entries = ArrayList<Ent>()

    // Method to return the number of entries in the dictionary
    fun numberOfEntries(): Int {
        return entries.size
    }

    // Method to add an entry to the dictionary
    fun addEntry(entry: Ent) {
        if (entries.contains(entry)) {
            throw Exception("Entry already exists in dictionary")
        }
        entries.add(entry)
    }

    // Method to remove an entry from the dictionary
    fun removeEntry(entry: Ent): Boolean {
        return entries.remove(entry)
    }

    // Method to remove an entry based on the English word
    fun removeEntry(englishWord: String): Boolean {
        val entry = entries.find { it.englishWord == englishWord }
        return if (entry != null) {
            entries.remove(entry)
            true
        } else {
            false
        }
    }

    // Method to return a list of English words equivalent to a given French word
    fun frAn(frenchWord: String): ArrayList<String> {
        val englishWords = ArrayList<String>()
        for (entry in entries) {
            if (entry.frenchWord == frenchWord) {
                englishWords.add(entry.englishWord)
            }
        }
        return englishWords
    }

    // Method to return a list of all French words in the dictionary
    fun frenchWords(): ArrayList<String> {
        val frenchWords = HashSet<String>()
        for (entry in entries) {
            frenchWords.add(entry.frenchWord)
        }
        return ArrayList(frenchWords)
    }

    // Method to return a map of French words and their corresponding English words
    fun dictionaryFrAn(): Map<String, ArrayList<String>> {
        val dictionary = HashMap<String, ArrayList<String>>()
        for (entry in entries) {
            if (dictionary.containsKey(entry.frenchWord)) {
                dictionary[entry.frenchWord]?.add(entry.englishWord)
            } else {
                dictionary[entry.frenchWord] = arrayListOf(entry.englishWord)
            }
        }
        return dictionary
    }

    // toString method to return the dictionary as a String
    override fun toString(): String {
        var dictionaryString = ""
        for (entry in entries) {
            dictionaryString += "${entry.toString()}\n"
        }
        return dictionaryString
    }
}
