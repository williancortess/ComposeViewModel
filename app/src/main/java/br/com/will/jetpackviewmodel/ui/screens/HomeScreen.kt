package br.com.will.jetpackviewmodel.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.will.jetpackviewmodel.sampledata.sampleSections
import br.com.will.jetpackviewmodel.ui.components.CardProductItem
import br.com.will.jetpackviewmodel.ui.components.ProductsSection
import br.com.will.jetpackviewmodel.ui.components.SearchTextField
import br.com.will.jetpackviewmodel.ui.states.HomeScreenUiState
import br.com.will.jetpackviewmodel.ui.theme.MyTheme
import br.com.will.jetpackviewmodel.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = state.searchedProducts
        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange,
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    MyTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    MyTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(
                    searchText = "a",
                    sections = sampleSections
                ),
            )
        }
    }
}