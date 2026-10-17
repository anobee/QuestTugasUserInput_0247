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

                    Spacer(Modifier.height(dimensionResource(R.dimen.space_medium)))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(stringResource(R.string.hint_email)) },
                        singleLine = true,
                        shape = fieldShape,
                        colors = fieldColors,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_medium)))

                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_medium))) {
                        val dateInteraction = remember { MutableInteractionSource() }
                        val isPressed by dateInteraction.collectIsPressedAsState()
                        LaunchedEffect(isPressed) {
                            if (isPressed) showDatePicker = true
                        }
                        OutlinedTextField(
                            value = birthDate,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text(stringResource(R.string.hint_birth_date)) },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = stringResource(R.string.cd_calendar),
                                    tint = colorResource(R.color.icon_tint)
                                )
                            },
                            singleLine = true,
                            shape = fieldShape,
                            colors = fieldColors,
                            interactionSource = dateInteraction,
                            modifier = Modifier.weight(1f)
                        )

                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = it },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text(stringResource(R.string.hint_experience)) },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                singleLine = true,
                                shape = fieldShape,
                                colors = fieldColors,
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                experiences.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option, fontSize = fieldTextSize) },
                                        onClick = {
                                            experience = option
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(dimensionResource(R.dimen.space_medium)))

                    Text(
                        text = stringResource(R.string.label_skill),
                        color = colorResource(R.color.label_color),
                        fontSize = spResource(R.dimen.text_label),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(dimensionResource(R.dimen.space_small)))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )

                    {
                        skills.forEachIndexed { index, skill ->
                            val checked = index in selectedSkills
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable {
                                    if (checked) selectedSkills.remove(index) else selectedSkills.add(index)
                                }
                            ) {
                                Checkbox(
                                    checked = checked,
                                    onCheckedChange = {
                                        if (it) selectedSkills.add(index) else selectedSkills.remove(index)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(R.color.checkbox_checked),
                                        uncheckedColor = colorResource(R.color.checkbox_unchecked)
                                    )
                                )
                                Text(
                                    text = skill,
                                    color = colorResource(R.color.label_color),
                                    fontSize = spResource(R.dimen.text_checkbox)
                                )
                            }
                        }
                    }