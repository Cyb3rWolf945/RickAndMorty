package pt.ipt.dam.rickyandmorty

/***
 * Uma classe sealed nao pode ser herdadda
 */
sealed class ScreenState<T>(val data: T? = null, val message: String? = null) {

    class Sucess<T>(data: T): ScreenState<T>(data)

    class Loading<T>(data: T? = null): ScreenState<T>(data)

    class Error<T>(message: String, data: T? = null): ScreenState<T>(data, message)

}