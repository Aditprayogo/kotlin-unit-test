package belajar.gradlew.repository

import belajar.gradlew.model.Person

interface PersonRepository {

    fun selectById(id : String) : Person?

    fun insert(person: Person) : Unit

}