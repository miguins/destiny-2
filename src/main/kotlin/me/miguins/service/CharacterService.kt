package me.miguins.service

import me.miguins.model.Character
import me.miguins.controller.character.dto.NewCharacterRequest
import java.util.*

interface CharacterService {

    fun create(character: NewCharacterRequest): Character

    fun findById(id: UUID): Character?

    fun listAll(): List<Character>

    fun update(character: Character): Character

    fun delete(id: UUID)
}