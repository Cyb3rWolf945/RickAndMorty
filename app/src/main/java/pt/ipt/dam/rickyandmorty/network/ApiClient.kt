package pt.ipt.dam.mvvm_project_example.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/***
 * Api client que usa a keyword object para
 * que se possa chamar o apiservice diretamente
 * sem que se tenha de inicializar a classe.
 */
object ApiClient {

    private val BASE_URL = "https://rickandmortyapi.com/api/"

    /***
     * Variavel para o moshi builder
     */
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    /***
     * Criamos uma instancia do retrofit de forma a que possa
     * ser inicializada quando é necessaria.
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService{

    @GET("character")
    fun fetchCharacter(@Query("page") page: String): Call<CharacterResponse>
}