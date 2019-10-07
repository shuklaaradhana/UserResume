package com.resume.app.resume.data

data class UserProfile(
    val name: String,
    val address: Address, val email: String,
    var phoneNumber: String,
    var summary: String, var experiences: List<UserExperience>
)

data class UserExperience(
    val company: String, val year: String, var role: String,
    var responsibility: String, var achievement: String
)

data class Address(val streetName: String, val city: String, val postalCode: String)