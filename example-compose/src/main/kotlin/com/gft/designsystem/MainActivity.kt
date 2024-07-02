package com.gft.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.designsystem.whitelabel.Button
import com.gft.designsystem.whitelabel.LighterButton
import com.gft.designsystem.whitelabel.LightWhiteLabelColorScheme
import com.gft.designsystem.whitelabel.LocalWhiteLabelSystem
import com.gft.designsystem.whitelabel.WhiteLabelColorScheme
import com.gft.designsystem.whitelabel.WhiteLabelDesignSystem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            AppDesignSystemTest()
        }
    }
}

@Composable
fun ColorSample(
    text: String,
    color: Color
) {
    Row(
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color)
                .size(16.dp)
        ) {}
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = color
        )
    }
}

@Composable
fun AppDesignSystemTest() {
    AppDesignSystem {
        Column {
            Text(text = "Direct WhiteLabel (grey theme)")

            ColorSample(
                text = "WhiteLabelDesignSystem color11 (overriden)",
                color = WhiteLabelDesignSystem.colors.color11
            )
            ColorSample(
                text = "WhiteLabelDesignSystem color12",
                color = WhiteLabelDesignSystem.colors.color12
            )
            ColorSample(
                text = "WhiteLabelDesignSystem color13",
                color = WhiteLabelDesignSystem.colors.color13
            )


            HorizontalDivider()
            Text(text = "App Theme (green theme)")

            Button(onClick = {} ) {
                Text("Button 1")
            }
            LighterButton(onClick = {}) {
                Text("Button 1")
            }


            ColorSample(
                text = "AppDesignSystem color11 (overriden)",
                color = AppDesignSystem.colors.color11
            )
            ColorSample(
                text = "AppDesignSystem color12",
                color = AppDesignSystem.colors.color12
            )
            ColorSample(
                text = "AppDesignSystem color13",
                color = AppDesignSystem.colors.color13
            )
            ColorSample(
                text = "AppDesignSystem color21 (new)",
                color = AppDesignSystem.colors.color21
            )




            HorizontalDivider()
            AppDesignSystem(
                colors = object : AppColorScheme by LocalAppDesignSystem.current.colors {
                    override val color11: Color = Color(0xff1133bb)
                }
            ) {
                Text(text = "App Theme locally overridden (blue theme)")
                Column(
                    Modifier.padding(start = 16.dp)
                ) {
                    Button(onClick = {}) {
                        Text("Button 2")
                    }
                    LighterButton(onClick = {}) {
                        Text("Button 2")
                    }

                    ColorSample(
                        text = "AppDesignSystem color11 (locally overridden)",
                        color = AppDesignSystem.colors.color11
                    )
                    ColorSample(
                        text = "AppDesignSystem color12",
                        color = AppDesignSystem.colors.color12
                    )
                    ColorSample(
                        text = "AppDesignSystem color21",
                        color = AppDesignSystem.colors.color13
                    )
                    ColorSample(
                        text = "AppDesignSystem color21 (new)",
                        color = AppDesignSystem.colors.color21
                    )
                }


                HorizontalDivider()
                AppDesignSystem(
                    colors = object : AppColorScheme by LocalAppDesignSystem.current.colors {
                        override val color21: Color = Color.Red
                    }
                ) {
                    Text(text = "App Theme locally overridden AGAIN (red theme)")
                    Column(
                        Modifier.padding(start = 32.dp)
                    ) {
                        ColorSample(
                            text = "AppDesignSystem color11 (still overridden)",
                            color = AppDesignSystem.colors.color11
                        )
                        ColorSample(
                            text = "AppDesignSystem color12",
                            color = AppDesignSystem.colors.color12
                        )
                        ColorSample(
                            text = "AppDesignSystem color21",
                            color = AppDesignSystem.colors.color13
                        )
                        ColorSample(
                            text = "AppDesignSystem color21 (overridden)",
                            color = AppDesignSystem.colors.color21
                        )

                        Button(onClick = {}) {
                            Text("Button 3")
                        }
                        LighterButton(onClick = {}) {
                            Text("Button 3")
                        }
                    }
                }


                HorizontalDivider()
                AppDesignSystemWithColor1Blue {
                    Text(text = "App Theme locally overridden (blue theme)")
                    Column(
                        Modifier.padding(start = 16.dp)
                    ) {
                        ColorSample(
                            text = "AppDesignSystem color11 (locally overridden)",
                            color = AppDesignSystem.colors.color11
                        )
                        ColorSample(
                            text = "AppDesignSystem color12",
                            color = AppDesignSystem.colors.color12
                        )
                        ColorSample(
                            text = "AppDesignSystem color21",
                            color = AppDesignSystem.colors.color13
                        )
                        ColorSample(
                            text = "AppDesignSystem color21 (new)",
                            color = AppDesignSystem.colors.color21
                        )
                    }


                    HorizontalDivider()
                    AppDesignSystemWithColor21Red {
                        Text(text = "App Theme locally overridden AGAIN (red theme)")
                        Column(
                            Modifier.padding(start = 32.dp)
                        ) {
                            ColorSample(
                                text = "AppDesignSystem color11 (still overridden)",
                                color = AppDesignSystem.colors.color11
                            )
                            ColorSample(
                                text = "AppDesignSystem color12",
                                color = AppDesignSystem.colors.color12
                            )
                            ColorSample(
                                text = "AppDesignSystem color21",
                                color = AppDesignSystem.colors.color13
                            )
                            ColorSample(
                                text = "AppDesignSystem color21 (overridden)",
                                color = AppDesignSystem.colors.color21
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppDesignSystemTest2() {
    AppDesignSystemWithColor1Blue {
        AppDesignSystemWithColor21Red {
            Column {
                ColorSample(
                    text = "AppDesignSystem color11 (overriden)",
                    color = AppDesignSystem.colors.color11
                )
                ColorSample(
                    text = "AppDesignSystem color12",
                    color = AppDesignSystem.colors.color12
                )
                ColorSample(
                    text = "AppDesignSystem color21 (overriden)",
                    color = AppDesignSystem.colors.color21
                )
            }
        }
    }
}

@Composable
fun AppDesignSystemTest3() {
    AppDesignSystem(
        colors = object : AppColorScheme by LightAppColorScheme() {
            override val color11: Color = Color(0xff1133bb)
        }) {
        AppDesignSystem(
            colors = object : AppColorScheme by LocalAppDesignSystem.current.colors {
                override val color21: Color = Color.Red
            }
        ) {
            Column {
                ColorSample(
                    text = "AppDesignSystem color11 (overriden)",
                    color = AppDesignSystem.colors.color11
                )
                ColorSample(
                    text = "AppDesignSystem color12",
                    color = AppDesignSystem.colors.color12
                )
                ColorSample(
                    text = "AppDesignSystem color21 (overriden)",
                    color = AppDesignSystem.colors.color21
                )
            }
        }
    }
}

@Composable
fun WhiteLabelTest() {
    WhiteLabelDesignSystem(
        colors = object : WhiteLabelColorScheme by LightWhiteLabelColorScheme() {
            override val color11: Color = Color.Green
        }
    ) {
        WhiteLabelDesignSystem(
            colors = object : WhiteLabelColorScheme by LocalWhiteLabelSystem.current.colors {
                override val color12: Color = Color.Red
            }
        ) {
            Column {
                Text(text = "Direct WhiteLabel (grey theme)")
                ColorSample(
                    text = "WhiteLabelDesignSystem color11 (overriden)",
                    color = WhiteLabelDesignSystem.colors.color11
                )
                ColorSample(
                    text = "WhiteLabelDesignSystem color12 (overriden)",
                    color = WhiteLabelDesignSystem.colors.color12
                )
                ColorSample(
                    text = "WhiteLabelDesignSystem color13",
                    color = WhiteLabelDesignSystem.colors.color13
                )
            }
        }
    }
}

@Composable
fun WhiteLabelTest2() {
    WhiteLabelGreenSection {
        WhiteLabelRedMarkSection {
            Column {
                Text(text = "Direct WhiteLabel (grey theme)")
                ColorSample(
                    text = "WhiteLabelDesignSystem color11 (overriden)",
                    color = WhiteLabelDesignSystem.colors.color11
                )
                ColorSample(
                    text = "WhiteLabelDesignSystem color12 (overriden)",
                    color = WhiteLabelDesignSystem.colors.color12
                )
                ColorSample(
                    text = "WhiteLabelDesignSystem color13",
                    color = WhiteLabelDesignSystem.colors.color13
                )
            }
        }
    }
}

@Composable
fun WhiteLabelGreenSection(
    content: @Composable () -> Unit,
) {
    WhiteLabelDesignSystem(
        colors = object : WhiteLabelColorScheme by LightWhiteLabelColorScheme() {
            override val color11: Color = Color.Green
        },
        content = content
    )
}

@Composable
fun WhiteLabelRedMarkSection(
    content: @Composable () -> Unit,
) {
    WhiteLabelDesignSystem(
        colors = object : WhiteLabelColorScheme by LocalWhiteLabelSystem.current.colors {
            override val color12: Color = Color.Red
        },
        content = content
    )
}
