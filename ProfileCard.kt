package com.example.myapplication // نفس package مشروعك

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip

data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)

@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Outer Box: avatar + green status dot
                Box {

                    // Avatar
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF0B2D4D)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "FA",
                            color = Color.White
                        )
                    }

                    // Status dot
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF32D583))
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                    )
                }

                // Required space between avatar and name
                Spacer(modifier = Modifier.width(12.dp))

                // Name + program
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = student.name)
                    Text(text = student.program)
                }

                // GPA on the right
                Text(text = student.gpa)
            }

            HorizontalDivider()

            Text(text = student.email)

            Text(text = student.city)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StudentCardPreview() {
    StudentCard(
        student = Student(
            name = "Fajr Abuzoah",
            program = "Computer Science",
            gpa = "4.50",
            email = "fajr@example.com",
            city = "Jubail, Eastern Province"
        ),
        modifier = Modifier.padding(16.dp)
    )
}