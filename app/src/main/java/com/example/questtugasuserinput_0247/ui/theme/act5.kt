package com.example.questtugasuserinput_0247.ui.theme

@Composable
private fun spResource(@DimenRes id: Int): TextUnit {
    val px = dimensionResource(id)
    return with(LocalDensity.current) { px.toSp() }
}
