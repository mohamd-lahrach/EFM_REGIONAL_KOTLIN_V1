// Define a class for dictionary entries (English word and its French equivalent)
class Ent(var englishWord: String, var frenchWord: String) {

    // Setters for English and French words
    @JvmName("setEnglishWord1")
    fun setEnglishWord(englishWord: String) {
        if (englishWord.trim().isEmpty()) {
            throw IllegalArgumentException("English word cannot be empty")
        }
        this.englishWord = englishWord.trim()
    }

    @JvmName("setFrenchWord1")
    fun setFrenchWord(frenchWord: String) {
        if (frenchWord.trim().isEmpty()) {
            throw IllegalArgumentException("French word cannot be empty")
        }
        this.frenchWord = frenchWord.trim()
    }

    // toString method to return the entry as a String
    override fun toString(): String {
        return "$englishWord:$frenchWord"
    }

    // equals method to compare two entries
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Ent) {
            return false
        }
        return this.englishWord == other.englishWord
    }

    override fun hashCode(): Int {
        var result = englishWord.hashCode()
        result = 31 * result + frenchWord.hashCode()
        return result
    }
}
