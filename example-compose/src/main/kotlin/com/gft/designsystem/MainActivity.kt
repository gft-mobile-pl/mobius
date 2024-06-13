package com.gft.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.designsystem.whitelabel.WhiteLabelDesignSystem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            AppDesignSystem(
                remember { AppDesignSystem() }
            ) {
                Column {
                    Text(
                        text = "AppDesignSystem.colors.primaryColor",
                        color = AppDesignSystem.colors.primaryColor
                    )
                    Text(
                        text = "AppDesignSystem.colors.secondaryColor",
                        color = AppDesignSystem.colors.secondaryColor
                    )
                    Text(
                        text = "AppDesignSystem.colors.tertiaryColor",
                        color = AppDesignSystem.colors.tertiaryColor
                    )
                    HorizontalDivider()
                    Text(
                        text = "WhiteLabelDesignSystem.colors.primaryColor",
                        color = WhiteLabelDesignSystem.colors.primaryColor
                    )
                    Text(
                        text = "WhiteLabelDesignSystem.colors.secondaryColor",
                        color = WhiteLabelDesignSystem.colors.secondaryColor
                    )


                    HorizontalDivider()
                    AppDesignSystem(
                        designSystem = remember {
                            object : AppDesignSystem() {
                                override val colors: AppColorScheme = object : AppColorScheme() {
                                    override val primaryColor: Color = Color.Cyan
                                }
                            }
                        }
                    ) {
                        Column(
                            Modifier.padding(start = 40.dp)
                        ) {
                            Text(
                                text = "AppDesignSystem.colors.primaryColor",
                                color = AppDesignSystem.colors.primaryColor
                            )
                            Text(
                                text = "AppDesignSystem.colors.secondaryColor",
                                color = AppDesignSystem.colors.secondaryColor
                            )
                            Text(
                                text = "AppDesignSystem.colors.tertiaryColor",
                                color = AppDesignSystem.colors.tertiaryColor
                            )
                        }


                        HorizontalDivider()
                        AppDesignSystem(
                            // MAJOR DRAWBACK - anonymous overrides do not sum up!
                            designSystem = remember {
                                object : AppDesignSystem() {
                                    override val colors: AppColorScheme = object : AppColorScheme() {
                                        override val tertiaryColor: Color = Color.Red
                                    }
                                }
                            }
                        ) {
                            Column(
                                Modifier.padding(start = 80.dp)
                            ) {
                                Text(
                                    text = "AppDesignSystem.colors.primaryColor",
                                    color = AppDesignSystem.colors.primaryColor
                                )
                                Text(
                                    text = "AppDesignSystem.colors.secondaryColor",
                                    color = AppDesignSystem.colors.secondaryColor
                                )
                                Text(
                                    text = "AppDesignSystem.colors.tertiaryColor",
                                    color = AppDesignSystem.colors.tertiaryColor
                                )
                            }
                        }

                    }


                    HorizontalDivider()
                    Text(
                        text = "AppDesignSystem.colors.primaryColor",
                        color = AppDesignSystem.colors.primaryColor
                    )
                    Text(
                        text = "AppDesignSystem.colors.secondaryColor",
                        color = AppDesignSystem.colors.secondaryColor
                    )
                    Text(
                        text = "AppDesignSystem.colors.tertiaryColor",
                        color = AppDesignSystem.colors.tertiaryColor
                    )
                }
            }
        }
    }
}
