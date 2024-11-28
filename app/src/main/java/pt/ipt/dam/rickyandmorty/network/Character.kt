package pt.ipt.dam.mvvm_project_example.network


import com.squareup.moshi.Json

/***
 * Não e necessario adicionar a anotacao json mas e boa pratica
 * pois podemos definir a que variavel do json nos estamos a referir.
 */
data class Character (
    @Json(name="name")
    val name: String,
    @Json(name="image")
    val image: String
)

/***
 * Estamos apenas a ir buscar o result que é nada
 * menos que uma lista da classe acima!
 */
data class CharacterResponse(
    @Json(name = "results")
    val result: List<Character>
)
