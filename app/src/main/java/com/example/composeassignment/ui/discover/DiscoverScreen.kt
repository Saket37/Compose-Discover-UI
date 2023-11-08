package com.example.composeassignment.ui.discover

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeassignment.R
import com.example.composeassignment.data.entity.Discover
import com.example.composeassignment.ui.component.CircularImage
import com.example.composeassignment.ui.component.OutlineButton
import com.example.composeassignment.ui.component.Subtitle
import com.example.composeassignment.ui.component.Title
import com.example.composeassignment.ui.component.gridItems
import com.example.composeassignment.viewmodel.DiscoverUiState
import com.example.composeassignment.viewmodel.DiscoverViewModel

@Composable
fun DiscoverScreen() {
    val viewModel: DiscoverViewModel = hiltViewModel()
    DiscoverScreenContent(uiState = viewModel.uiState.collectAsState().value)
}

@Composable
fun DiscoverScreenContent(modifier: Modifier = Modifier, uiState: DiscoverUiState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Title(title = "Discover", textSize = 36.sp, textColor = Color.Black)
            Spacer(modifier = Modifier.height(32.dp))
            Subtitle(title = "WHAT’S NEW TODAY", textSize = 13.sp, textColor = Color.Black)
            Spacer(modifier = Modifier.height(24.dp))
            DiscoverCarousels(uiState.discoverItem)
            Spacer(modifier = Modifier.height(48.dp))
            Subtitle(title = "BROWSE ALL", textSize = 13.sp, textColor = Color.Black)
            Spacer(modifier = Modifier.height(24.dp))
        }
        gridItems(
            browsableImages,
            2,
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            modifier = Modifier
        ) {
            BrowseImage(image = it)
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
            OutlineButton(text = "SEE MORE", backgroundColor = Color.White, textColor = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


private val browsableImages = listOf(
    R.drawable.b_1,
    R.drawable.b_2,
    R.drawable.b_3,
    R.drawable.b_4,
    R.drawable.b_5,
    R.drawable.b_6,
    R.drawable.b_7,
    R.drawable.b_8
)

@Composable
fun Browse(images: List<Int>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 9.dp,
        horizontalArrangement = Arrangement.spacedBy(9.dp)
    ) {

        items(images) {
            BrowseImage(image = it)
        }
    }
}

@Composable
fun BrowseImage(image: Int) {
    Image(painter = painterResource(id = image), contentDescription = null)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiscoverCarousels(discover: List<Discover>) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        discover.size
    }

    HorizontalPager(state = pagerState) { page ->
        val item = discover[page]
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(343.dp),
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CircularImage(modifier = Modifier.size(28.dp), image = item.userImage)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = item.userName, style = TextStyle(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(700),
                                color = Color.Black,
                            )
                        )
                        Text(
                            text = item.userHandle, style = TextStyle(
                                fontSize = 11.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                fontWeight = FontWeight(400),
                                color = Color.Black,
                            )
                        )
                    }
                }
            }
        }

    }
}

