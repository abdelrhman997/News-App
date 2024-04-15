package com.example.newsapp.data.manager

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.utils.Constants
import com.example.newsapp.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserManagerImplementation @Inject constructor(
    private val application: Application
):LocalUserManager {
    override suspend fun saveAppEntry() {
        application.dataStore.edit {settings->
            settings[PreferencesKeys.APP_ENTRY]=true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return application.dataStore.data.map{preferences->
            preferences[PreferencesKeys.APP_ENTRY]?:false
        }
    }
}

private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}