package belajar.gradlew.service

import belajar.gradlew.model.Person
import belajar.gradlew.repository.PersonRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.lang.IllegalArgumentException

@Extensions(value = [
    ExtendWith(MockitoExtension::class)
])
class PersonServiceTest {

    @Mock
    lateinit var personRepository: PersonRepository

    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach() {
        personService = PersonService(personRepository)
    }

    @Test
    fun testGetPersonIdIsNotValid() {
        assertThrows<IllegalArgumentException>() {
            //blacnk
            personService.get(" ")
        }
    }

    @Test
    fun testGetPersonNotFound() {
        assertThrows<Exception> {
            //not found
            personService.get(" not found ")
        }
    }

    @Test
    fun testGetPersonSuccess() {
        Mockito.`when`(personRepository.selectById("adit"))
                .thenReturn(Person(id = "adit", name = "aditiya prayogo"))

        val person = personService.get("adit")
        Assertions.assertEquals("adit", person.id)
        Assertions.assertEquals("aditiya prayogo", person.name)
    }

    @Test
    fun testRegisterPersonNameIsBlank() {
        assertThrows<IllegalArgumentException> {
            personService.register(" ")
        }
    }

    @Test
    fun testRegisterSuccess() {
        val person = personService.register("Aditiya")

        //verify mocking object
        Mockito.verify(personRepository, Mockito.times(1)).insert(Person(person.id, person.name))
    }

}