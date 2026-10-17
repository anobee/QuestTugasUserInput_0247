package com.example.questtugasuserinput_0247.ui.theme

@Composable
private fun spResource(@DimenRes id: Int): TextUnit {
    val px = dimensionResource(id)
    return with(LocalDensity.current) { px.toSp() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun act5(modifier: Modifier = Modifier) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var birthDate by rememberSaveable { mutableStateOf("") }
    var experience by rememberSaveable { mutableStateOf("") }
    val selectedSkills = remember { mutableStateListOf<Int>() }

    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    val skills = stringArrayResource(R.array.skill_options)
    val experiences = stringArrayResource(R.array.experience_options)

    val isFormValid = firstName.isNotBlank() &&
            lastName.isNotBlank() &&
            email.isNotBlank() &&
            birthDate.isNotBlank() &&
            experience.isNotBlank() &&
            selectedSkills.isNotEmpty()

    val fieldShape = RoundedCornerShape(dimensionResource(R.dimen.field_corner))
    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colorResource(R.color.field_border_focused),
        unfocusedBorderColor = colorResource(R.color.field_border),
        focusedLabelColor = colorResource(R.color.field_border_focused),
        unfocusedLabelColor = colorResource(R.color.field_text),
        focusedTextColor = colorResource(R.color.field_text),
        unfocusedTextColor = colorResource(R.color.field_text),
        cursorColor = colorResource(R.color.field_border_focused)
    )

    val fieldTextSize = spResource(R.dimen.text_field)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.screen_background)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Image(
                painter = painterResource
                    (R.drawable.bg_spider_neon),
                contentDescription = stringResource
                    (R.string.cd_banner),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource
                        (R.dimen.banner_height))
            )


}