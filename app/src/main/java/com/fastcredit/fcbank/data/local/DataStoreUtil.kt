package com.fastcredit.fcbank.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.fastcredit.fcbank.common.constant.Constants.DataStore.Companion.FAST_BANK_PREFERENCES
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
@Singleton
class DataStoreUtil @Inject constructor(context: Context) {

    private val Context._dataStore: DataStore<Preferences> by preferencesDataStore(
        FAST_BANK_PREFERENCES
    )
    private val dataStore: DataStore<Preferences> = context._dataStore

    suspend fun saveStringInDataStore(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun readStringFromDataStore(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun saveIntInDataStore(key: String, value: Int) {
        val dataStoreKey = intPreferencesKey(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun readIntFromDataStore(key: String): Int? {
        val dataStoreKey = intPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

}