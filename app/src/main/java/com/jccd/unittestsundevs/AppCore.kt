package com.jccd.unittestsundevs

import android.app.Application
import android.content.Context
import com.jccd.unittestsundevs.net.ApiMaps
import com.jccd.unittestsundevs.net.repository.MapsRepository

class AppCore: Application() {

    private var sContext: Context? = null

    companion object {
        lateinit var sInstance: AppCore
        fun getInstance() = sInstance
        private lateinit var mapsRepository: MapsRepository
       // private lateinit var schedulesViewModel: SchedulesViewModel

      //  fun injectSchedulesViewModel() = schedulesViewModel

        fun injectMapsRepository() = mapsRepository

    }

    override fun onCreate() {
        super.onCreate()
        setAppContext(this)
        sInstance = this
        di()
    }

    fun getContext(): Context? {
        return sContext
    }


    fun setAppContext(context: Context) {
        sContext = context
    }

    private fun di(){
        val apiMap = ApiMaps()
        apiMap.buildRetrofit()
        mapsRepository = MapsRepository(apiMap)
    }
}