package me.miguins.controller.character.dto


import io.micronaut.core.annotation.Introspected
import me.miguins.model.Character
import me.miguins.model.CharacterRace
import me.miguins.model.CharacterType
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class UpdateCharacterRequest(
        @Enumerated(EnumType.STRING)
        @field:NotNull
        val type: CharacterType,

        @Enumerated(EnumType.STRING)
        @field:NotNull
        val race: CharacterRace,

        @field:NotBlank
        val gender: String,

        @field:NotBlank
        val name: String
) {

    fun toCharacter(character: Character): Character {
        character.type = type
        character.race = race
        character.gender = gender
        character.name = name

        return character
    }
}