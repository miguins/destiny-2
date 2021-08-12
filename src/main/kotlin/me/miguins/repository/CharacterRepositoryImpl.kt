package me.miguins.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import me.miguins.model.Character
import me.miguins.model.CharacterRace
import me.miguins.model.CharacterType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl(private val cqlSession: CqlSession) : CharacterRepository {

    val LOG: Logger = LoggerFactory.getLogger(CharacterRepositoryImpl::class.java)

    override fun save(character: Character): Character {

        cqlSession.execute(
                SimpleStatement
                        .newInstance(
                                "INSERT INTO destiny2.characters(id, createdAt, gender, name, race, type) " +
                                        "VALUES (?,?,?,?,?,?)",
                                character.id,
                                character.createdAt,
                                character.gender,
                                character.name,
                                character.race?.name,
                                character.type?.name
                        )
        )

        LOG.info("task successfully sent to the database {}", "save")

        return character
    }

    override fun findById(id: UUID): Character? {
        val selectResult = cqlSession.execute(
                (SimpleStatement.newInstance("SELECT * FROM destiny2.characters WHERE id = ?", id))
        )
        return selectResult.map {
            Character(
                    it.getUuid("id"),
                    it.getString("createdAt"),
                    CharacterType.valueOf(it.getString("type")!!),
                    CharacterRace.valueOf(it.getString("race")!!),
                    it.getString("gender")!!,
                    it.getString("name")!!
            )
        }.one()
    }

    override fun findAll(character: Character): List<Character> {
        val selectResult = cqlSession.execute(
                (SimpleStatement.newInstance("SELECT * FROM destiny2.characters"))
        )
        return selectResult.map {
            Character(
                    it.getUuid("id"),
                    it.getString("createdAt"),
                    CharacterType.valueOf(it.getString("type")!!),
                    CharacterRace.valueOf(it.getString("race")!!),
                    it.getString("gender")!!,
                    it.getString("name")!!
            )
        }.toList()
    }

    override fun update(character: Character): Character {
        cqlSession.execute(
                SimpleStatement
                        .newInstance(
                                "UPDATE destiny2.characters SET gender = ?, name = ?, race = ?, type = ? " +
                                        "WHERE id = ?",
                                character.gender,
                                character.name,
                                character.race?.name,
                                character.type?.name,
                                character.id
                        )
        )
        return character
    }

    override fun deleteById(id: UUID) {
        cqlSession.execute(SimpleStatement.newInstance("DELETE FROM destiny2.characters WHERE id = ?", id))
    }
}
