/*
 * Image.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil3.compose.AsyncImage
import com.kmp.core.design.dimen.Dimens
import inventario.sharedui.generated.resources.Res
import inventario.sharedui.generated.resources.ic_example
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun Image(
    modifier: Modifier = Modifier,
    size: Dp,
    image: Painter,
) {
    Image(
        modifier = modifier
            .size(size = size),
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun Image(
    modifier: Modifier = Modifier,
    size: Dp,
    image: DrawableResource,
) {
    Image(
        modifier = modifier
            .size(size = size),
        painter = painterResource(resource = image),
        contentDescription = null,
    )
}

@Composable
fun ImageCircular(
    modifier: Modifier = Modifier,
    size: Dp,
    image: Painter,
) {
    Image(
        modifier = modifier
            .size(size = size)
            .clip(shape = CircleShape),
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun ImageCircular(
    modifier: Modifier = Modifier,
    size: Dp,
    image: DrawableResource,
) {
    Image(
        modifier = modifier
            .size(size = size)
            .clip(shape = CircleShape),
        painter = painterResource(resource = image),
        contentDescription = null,
    )
}

@Composable
fun ImageAsync(
    modifier: Modifier = Modifier,
    size: Dp,
    placeholder: Painter,
    image: String?,
) {
    AsyncImage(
        modifier = modifier.size(size),
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        fallback = placeholder,
        error = placeholder,
    )
}

@Composable
fun ImageAsync(
    modifier: Modifier = Modifier,
    size: Dp,
    placeholder: DrawableResource,
    image: String?,
) {
    AsyncImage(
        modifier = modifier.size(size),
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        fallback = painterResource(placeholder),
        error = painterResource(placeholder),
    )
}

@Composable
fun ImageCircularAsync(
    modifier: Modifier = Modifier,
    size: Dp,
    placeholder: Painter,
    image: String?,
) {
    AsyncImage(
        modifier = modifier
            .size(size)
            .clip(CircleShape),
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        fallback = placeholder,
        error = placeholder,
    )
}

@Composable
fun ImageCircularAsync(
    modifier: Modifier = Modifier,
    size: Dp,
    placeholder: DrawableResource,
    image: String?,
) {
    AsyncImage(
        modifier = modifier
            .size(size)
            .clip(CircleShape),
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        fallback = painterResource(placeholder),
        error = painterResource(placeholder),
    )
}

@Preview(
    showBackground = true,
)
@Composable
private fun ButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
    ) {
        Image(
            size = Dimens.height96,
            image = painterResource(Res.drawable.ic_example),
        )
        ImageCircular(
            size = Dimens.height96,
            image = painterResource(Res.drawable.ic_example),
        )
        ImageCircularAsync(
            size = Dimens.height96,
            placeholder = painterResource(Res.drawable.ic_example),
            image = "",
        )
    }
}
