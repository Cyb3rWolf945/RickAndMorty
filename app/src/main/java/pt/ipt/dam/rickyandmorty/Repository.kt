package pt.ipt.dam.rickyandmorty

import pt.ipt.dam.mvvm_project_example.network.ApiService


/***
 * Caso se tenha duas fontes de dados
 * esta classe vai fazer uma gestao dessas fontes
 * para o caso por exemplo de termos uma fonte API e outra local.
 *
 */
class Repository(private val apiService: ApiService) {

    fun getCharacters(page: String) = apiService.fetchCharacter(page)

}