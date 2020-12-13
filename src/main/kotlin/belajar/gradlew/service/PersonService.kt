package belajar.gradlew.service

import belajar.gradlew.model.Person
import belajar.gradlew.repository.PersonRepository
import java.lang.IllegalArgumentException
import java.util.*

class PersonService(
        private val personRepository: PersonRepository
) {

    fun get(id : String) : Person {
        if (id.isBlank()) {
            throw IllegalArgumentException("This id is not valid")
        }

        val person = personRepository.selectById(id)

        if (person != null) {
            return person
        }else {
            throw Exception("person not found")
        }

    }

    fun register(name : String) : Person {
        if (name.isBlank()) {
            throw IllegalArgumentException("This name is not valid")
        }

        val id = UUID.randomUUID().toString()
        val person = Person(id, name)

        personRepository.insert(person)
        return person
    }

}