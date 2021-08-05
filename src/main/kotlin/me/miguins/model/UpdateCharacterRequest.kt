package me.miguins.model


import io.micronaut.core.annotation.Introspected
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class UpdateCharacterRequest(
        @field:NotNull
        @Enumerated(EnumType.STRING)
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