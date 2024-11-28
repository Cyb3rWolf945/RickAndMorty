package pt.ipt.dam.rickyandmorty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pt.ipt.dam.mvvm_project_example.network.ApiClient
import pt.ipt.dam.mvvm_project_example.network.Character
import pt.ipt.dam.mvvm_project_example.network.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository = Repository(ApiClient.apiService)) : ViewModel() {

    private var _charactersLiveData = MutableLiveData<ScreenState<List<Character>?>>()
    val characterLiveData: LiveData<ScreenState<List<Character>?>>
        get() = _charactersLiveData

    init {
        fetchCharacter()
    }

    private fun fetchCharacter(){
        val client = repository.getCharacters("1")
        _charactersLiveData.postValue(ScreenState.Loading(null))
        client.enqueue(object : Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if(response.isSuccessful){
                    _charactersLiveData.postValue(ScreenState.Sucess(response.body()?.result))
                }else{
                    _charactersLiveData.postValue(ScreenState.Error(response.code().toString(), null ))
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                _charactersLiveData.postValue(ScreenState.Error(t.message.toString(), null ))
            }
        })
    }


}