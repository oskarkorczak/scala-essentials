package com.korczak.essentials.classes

import com.korczak.essentials.UnitSpec

class PersonSpec  extends UnitSpec {

  "Person" should "introduce itself" in {
    new Person().name shouldBe "James Bond"
  }

  "PersonWithConstructor" should "introduce itself" in {
    new PersonWithConstructor("James", "Bond").name shouldBe "James Bond"
  }

  "PersonFieldGetters" should "introduce itself and have getters" in {
    val bond = new PersonWithConstructor("James", "Bond")

    bond.name shouldBe "James Bond"
    bond.firstName shouldBe "James"
    bond.lastName shouldBe "Bond"
  }
}