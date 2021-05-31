package com.passion.models

data class Country(
    val name: String,
    val capital: String,
    val altSpellings: List<String>,
    val region: String,
    val subregion: String,
    val population: Long,
    val borders: List<String>,
    val nativeName: String,
  //  val currencies: List<String>,
    //val languages: List<String>,
)

data class Translations(
    val de: String,
    val es: String,
    val fr: String,
    val ja: String,
    val it: String
)