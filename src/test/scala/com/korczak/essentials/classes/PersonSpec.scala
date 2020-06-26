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

  "PersonDefault" should "introduce itself" in {
    new PersonDefault("James", "Bond").name shouldBe "James Bond"
    new PersonDefault("James").name shouldBe "James Smith"
  }

  "Adder" should "apply itself to 'in' number" in {
    val adder5 = new Adder(5)

    adder5.apply(3) shouldBe 8
    adder5(3) shouldBe 8
  }

  "PersonFieldGetters" should "fix name and flex surname when applied via companion object" in {
    val bond = PersonFieldGetters("Bond")

    bond.name shouldBe "John Bond"
  }

  "Employee" should "present all case class features" in {
    val dave = Employee("David", "Davidson")
    val anotherDave = Employee("David", "Davidson")

    dave.firstName shouldBe "David"
    dave.surname shouldBe "Davidson"
    dave.toString shouldBe "Employee(David,Davidson)"

    dave.equals(anotherDave)
    dave equals anotherDave
    dave == anotherDave shouldBe true

    dave.copy().eq(anotherDave) shouldBe false
    dave.copy() eq anotherDave shouldBe false
    dave.copy(surname = "Richardson").name shouldBe "David Richardson"

    dave.productArity shouldBe 2
    dave.productElement(1) shouldBe "Davidson"
  }
}