import dev.alejo.exercism.Acronym
import junit.framework.TestCase.assertEquals
import org.junit.Test

class AcronymTest {
    @Test
    fun `capitalized words`(): Unit = assertAcronymEquals(
        "Portable Network Graphics",
        "PNG")

    @Test
    fun `lowercase word in the middle`(): Unit = assertAcronymEquals(
        "Ruby on Rails",
        "ROR")

    @Test
    fun `punctuation is ignored`(): Unit = assertAcronymEquals(
        "First In, First Out",
        "FIFO")

    @Test
    fun `uppercased word at the start`(): Unit = assertAcronymEquals(
        "GNU Image Manipulation Program",
        "GIMP")

    @Test
    fun `hyphen is ignored`(): Unit = assertAcronymEquals(
        "Complementary metal-oxide semiconductor",
        "CMOS")

    @Test
    fun `lots of words`(): Unit = assertAcronymEquals(
        "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me",
        "ROTFLSHTMDCOALM")

    @Test
    fun `consecutive delimiters`(): Unit = assertAcronymEquals(
        "Something - I made up from thin air",
        "SIMUFTA")

    @Test
    fun `apostrophe is ignored`(): Unit = assertAcronymEquals(
        "Halley's Comet",
        "HC")

    @Test
    fun `underscore emphasis is ignored`(): Unit = assertAcronymEquals(
        "The Road _Not_ Taken",
        "TRNT")
}
private fun assertAcronymEquals(origin: String, acronym: String) = assertEquals(acronym, Acronym.generate(origin))
