package com.softcross.multilanguage

import android.app.LocaleConfig
import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.LocaleListCompat
import com.softcross.multilanguage.ui.theme.MultiLanguageTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLanguageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.hello))
        Button(onClick = {
            changeLocal(context, "tr")
        }) {
            Text(text = "TR")
        }
        Button(onClick = {
            changeLocal(context, "fr")
        }) {
            Text(text = "FR")
        }
        Button(onClick = {
            changeLocal(context, "en")
        }) {
            Text(text = "EN")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiLanguageTheme {
        Greeting()
    }
}

/*
    Before the this func you must add languages from res>values>string, right click string file and
    open translations editor add new languages.
    After you must add inside gradle android;
    androidResources{
        generateLocaleConfig = true
    }

    after you must right click res folder, click new file, name as resources.properties and add inside
    unqualifiedResLocale=en(languageShortcut)

    For more detail;
    https://developer.android.com/guide/topics/resources/app-languages
 */

// Change language function
fun changeLocal(context: Context, localeString: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        context.getSystemService(LocaleManager::class.java).applicationLocales =
            LocaleList.forLanguageTags(localeString)
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(localeString))
    }
}