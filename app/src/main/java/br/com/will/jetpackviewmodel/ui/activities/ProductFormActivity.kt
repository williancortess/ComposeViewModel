package br.com.will.jetpackviewmodel.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import br.com.will.jetpackviewmodel.ui.screens.ProductFormScreen
import br.com.will.jetpackviewmodel.ui.theme.MyTheme
import br.com.will.jetpackviewmodel.ui.viewmodels.ProductFormScreenViewModel

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface {
                    val viewModel: ProductFormScreenViewModel by viewModels()
                    ProductFormScreen(
                        viewModel = viewModel,
                        onSaveClick = {
                            finish()
                        })
                }
            }
        }
    }

}