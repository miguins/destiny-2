package me.miguins.model

import java.time.LocalDateTime
import java.util.*

data class Character(
        val id: UUID? = UUID.randomUUID(),
        val createdAt: String? = LocalDateTime.now().toString(),
        var type: CharacterType? = null,
        var race: CharacterRace? = null,
        var gender: String? = null,
        var name: String? = null
)