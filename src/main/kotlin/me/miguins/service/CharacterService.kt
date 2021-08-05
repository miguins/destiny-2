package me.miguins.service

import me.miguins.model.Character
import me.miguins.model.NewCharacterRequest

interface CharacterService {

    fun create(character: NewCharacterRequest): Character
}