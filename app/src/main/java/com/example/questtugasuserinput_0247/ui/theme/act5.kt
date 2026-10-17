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

}