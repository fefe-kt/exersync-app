package br.com.exersync_app.core.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import exersync_app.composeapp.generated.resources.Res
import exersync_app.composeapp.generated.resources.visibility
import exersync_app.composeapp.generated.resources.visibility_off
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun DefaultTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    placeholder: String?,
    isError: Boolean = false,
    errorMessage: String? = null,
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = modifier.semantics {
            error(errorMessage.orEmpty())
        }.minimumInteractiveComponentSize()
            .background(Color.White),
        placeholder = { Text(text = placeholder.orEmpty()) },
        leadingIcon = {
            Icon(
                Icons.Default.Edit,
                null
            )
        },
        singleLine = true,
        isError = isError,
    )
}

@Composable
fun DefaultSecureTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    placeholder: String?,
    isError: Boolean = false,
    errorMessage: String? = null,
    isPasswordVisible: Boolean = true,
    onChangeVisibility: () -> Unit
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = modifier.semantics {
            error(errorMessage.orEmpty())
        }.minimumInteractiveComponentSize()
            .background(Color.White),
        placeholder = { Text(text = placeholder.orEmpty()) },
        leadingIcon = {
            Icon(
                Icons.Default.Edit,
                null
            )
        },
        singleLine = true,
        isError = isError,
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onChangeVisibility()
                },
                content = {
                    AnimatedContent(targetState = isPasswordVisible) { state ->
                        Icon(
                            painterResource(
                                if (state) {
                                    Res.drawable.visibility_off
                                } else {
                                    Res.drawable.visibility
                                }
                            ),
                            contentDescription = "Mudar visibilidade da senha"
                        )
                    }
                }
            )
        }
    )
}