package com.kaydu.sampleandroidlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kaydu.sampleandroidlibrary.ui.theme.SampleAndroidLibraryTheme
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAndroidLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = {
                            selector(this@MainActivity)
                        }){
                            Text(text = "Texting")
                        }
                    }
                }
            }
        }
    }
}
fun selector(activity: MainActivity){
    PictureSelector.create(activity)
        .openGallery(SelectMimeType.TYPE_ALL)
        .setImageEngine(GlideEngine.createGlideEngine())
        .forResult(object : OnResultCallbackListener<LocalMedia?> {
            override fun onResult(result: ArrayList<LocalMedia?>?) {}
            override fun onCancel() {}
        })
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleAndroidLibraryTheme {
    }
}