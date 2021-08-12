package me.miguins.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import me.miguins.model.Character
import java.util.*
import javax.inject.Singleton

@Singleton
interface CharacterRepository {

    fun save(character: Character): Character
    fun findById(id: UUID): Character?
    fun findAll(character: Character): List<Character>
    fun update(character: Character): Character
    fun deleteById(id: UUID)
}