package com.korczak.essentials.classes

import com.korczak.essentials.UnitSpec

class PersonSpec  extends UnitSpec {

  behavior of "Person"

  it should "introduce itself" in {
    new Person().name shouldBe "James Bond"
  }
}