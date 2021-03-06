package com.korczak.essentials.modellingpatterns

class CompositionViaIsAAndHasAPatterns {

  // Below patterns are aiming to combine data together, as oppose to structural recursion, which aims to split larger
  // data structure into smaller pieces

  // ======
  // HAS-A + AND
  // Both are equivalent and mean that a class has featureOne and featureTwo

  // Solution #1
  case class ProductTypeImplementedByCaseClass(featureOne: String, featureTwo: Int)

  // Solution #2
  trait ProductTypeImplementedByTrait {
    def featureOne: String
    def featureTwo: Int
  }

  // ======
  // IS-A + OR

  sealed trait SumType
  final case class eitherThis() extends SumType
  final case class orThat() extends SumType

  // ======
  // LESS USED PATTERNS
  // ======
  // IS-A + AND
  // It means that Aob is Bob and Cob aka Cake Pattern
  trait Bob
  trait Cob
  trait Aob extends Bob with Cob

  // ======
  // HAS-A + OR
  // It means that A has B or C

  // Solution #1
  // We can say that A has a d or type D, where D is a B or C
  trait A {
    def d: D
  }
  sealed trait D
  final case class B() extends D
  final case class C() extends D

  // Solution #2
  sealed trait Alo
  final case class Dlo(b: String) extends Alo
  final case class Elo(c: Int) extends Alo
}