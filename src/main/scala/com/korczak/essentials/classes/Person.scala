package com.korczak.essentials.classes

class Person {
  val firstName = "James"
  val lastName = "Bond"

  def name: String = s"$firstName $lastName"
}

class PersonWithConstructor(first: String, last: String) {
  val firstName = first
  val lastName = last

  def name: String = s"$firstName $lastName"
}

class PersonFieldGetters(val first: String, val last: String) {
  def name: String = s"$first $last"
}

class PersonDefault(val first: String, val last: String = "Smith") {
  def name: String = s"$first $last"
}

class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

object PersonFieldGetters {
  def apply(lastName: String): PersonFieldGetters = {
    new PersonFieldGetters("John", lastName)
  }
}

