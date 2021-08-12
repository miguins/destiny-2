package me.miguins.controller.character.dto

import me.miguins.model.Character

class CharacterResponse(character: Character) {

    val id = character.id

    val type = character.type

    val race = character.race

    val gender = character.gender

    val name = character.name

    val createdAt = character.createdAt
}
