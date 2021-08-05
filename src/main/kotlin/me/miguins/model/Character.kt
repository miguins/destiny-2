package me.miguins.model

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Character(

        @field:NotNull
        @Enumerated(EnumType.STRING)
        var type: CharacterType,

        @Enumerated(EnumType.STRING)
        @field:NotNull
        var race: CharacterRace,

        @field:NotBlank
        var gender: String,

        @field:NotBlank
        var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val createdAt: LocalDateTime = LocalDateTime.now()
}