package me.miguins.controller.character

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import me.miguins.controller.character.dto.CharacterResponse
import me.miguins.controller.character.dto.NewCharacterRequest
import me.miguins.controller.character.dto.UpdateCharacterRequest
import me.miguins.service.CharacterService
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/api/v1/characters")
class CharacterController(private val characterService: CharacterService) {

    @Post
    fun create(@Body @Valid request: NewCharacterRequest): HttpResponse<Any> {

        val character = characterService.create(request)

        val location = HttpResponse.uri("/api/v1/characters/${character.id}")

        return HttpResponse.created(location)
    }

    @Get("/{id}")
    fun find(@PathVariable id: UUID): HttpResponse<Any> {

        val character = characterService.findById(id) ?: return HttpResponse.notFound()

        return HttpResponse.ok(CharacterResponse(character))
    }

    @Get
    fun list(): HttpResponse<List<Any>> {

        val characters = characterService.listAll().map {
            CharacterResponse(it)
        }

        return HttpResponse.ok(characters)
    }

    @Put("/{id}")
    fun update(@PathVariable id: UUID, @Body @Valid request: UpdateCharacterRequest): HttpResponse<Any> {
        val character = characterService.findById(id) ?: return HttpResponse.notFound()

        val updatedCharacter = characterService.update(request.toCharacter(character))

        return HttpResponse.ok(CharacterResponse(updatedCharacter))
    }

    @Delete("{id}")
    fun delete(@PathVariable id: UUID): HttpResponse<Any> {
        characterService.findById(id) ?: return HttpResponse.notFound()
        characterService.delete(id)

        return HttpResponse.ok()
    }
}