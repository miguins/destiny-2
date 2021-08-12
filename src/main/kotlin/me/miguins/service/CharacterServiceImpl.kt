package me.miguins.service

import me.miguins.model.Character
import me.miguins.controller.character.dto.NewCharacterRequest
import me.miguins.repository.CharacterRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class CharacterServiceImpl(
        private val characterRepository: CharacterRepository) : CharacterService {

    override fun create(character: NewCharacterRequest): Character {
        return characterRepository.save(character.toCharacter())
    }

    override fun findById(id: UUID): Character? {
        return characterRepository.findById(id)
    }

    override fun listAll(): List<Character> {
        return characterRepository.findAll(Character())
    }

    override fun update(character: Character): Character {
        return characterRepository.update(character)
    }

    override fun delete(id: UUID) {
        characterRepository.deleteById(id)
    }
}