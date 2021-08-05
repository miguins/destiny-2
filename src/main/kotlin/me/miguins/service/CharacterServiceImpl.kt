package me.miguins.service

import me.miguins.model.Character
import me.miguins.model.NewCharacterRequest
import me.miguins.repository.CharacterRepository
import javax.inject.Singleton

@Singleton
class CharacterServiceImpl(
        private val characterRepository: CharacterRepository) : CharacterService {

    override fun create(character: NewCharacterRequest): Character {
        return characterRepository.save(character.toCharacter())
    }
}