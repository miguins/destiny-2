package me.miguins.model

import com.sun.istack.NotNull
import io.micronaut.core.annotation.Introspected
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotBlank

@Introspected
data class NewCharacterRequest(
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

    fun toCharacter() = Character(
            type = this.type,
            race = this.race,
            gender = this.gender,
            name = this.name
    )
}