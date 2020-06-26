package com.korczak.essentials.modellingpatterns

class StructuralRecursionPolymorphism {

  // Structural recursion aims to decompose larger data structure into smaller pieces.
  // There are two approaches ie by using polymorphism and by using pattern matching

  sealed trait A {
    def foo: String = "It's A!"
  }

  final case class B() extends A {
    override def foo: String = "It's B!"
  }

  final case class C() extends A {102
    override def foo: String = "It's C!"
  }
}
