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

            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(R.dimen.sheet_bottom_margin))
                    .shadow(
                        elevation = dimensionResource(R.dimen.sheet_elevation),
                        shape = RoundedCornerShape(
                            topStart = dimensionResource(R.dimen.sheet_corner),
                            topEnd = dimensionResource(R.dimen.sheet_corner)
                        )
                    ),
                color = colorResource(R.color.sheet_background),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.sheet_corner),
                    topEnd = dimensionResource(R.dimen.sheet_corner)
                )
            )

            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.sheet_padding))
                ) {
                    Text(
                        text = stringResource(R.string.form_title),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.title_color),
                        fontSize = spResource(R.dimen.text_title),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(dimensionResource(R.dimen.space_small)))
                    Text(
                        text = stringResource(R.string.form_subtitle),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.subtitle_color),
                        fontSize = spResource(R.dimen.text_subtitle)
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_large)))


                Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_medium))) {
                    OutlinedTextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text(stringResource(R.string.hint_first_name)) },
                        singleLine = true,
                        shape = fieldShape,
                        colors = fieldColors,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text(stringResource(R.string.hint_last_name)) },
                        singleLine = true,
                        shape = fieldShape,
                        colors = fieldColors,
                        modifier = Modifier.weight(1f)
                    )
                }