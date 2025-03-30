package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4
        val cardsAmount: Int
            get() = words.size / WORDS_IN_CARD
    }

    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled()
        return (0 until cardsAmount).map { index ->
            val wordList = shuffledWords.subList(index * WORDS_IN_CARD, (index + 1) * WORDS_IN_CARD).toWords()
            Card(identifierFactory.uniqueIdentifier(), wordList)
        }
    }

    fun getCardByIndex(index: Int): Card {
        return cards.getOrElse(index) { throw IllegalArgumentException("Card at index $index does not exist.") }
    }
}
