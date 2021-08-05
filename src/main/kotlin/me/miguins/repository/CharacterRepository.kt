package me.miguins.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import me.miguins.model.Character

@Repository
interface CharacterRepository : JpaRepository<Character, Long> {
}