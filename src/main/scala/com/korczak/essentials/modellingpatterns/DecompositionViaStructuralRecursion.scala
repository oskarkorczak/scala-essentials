package com.korczak.essentials.modellingpatterns

sealed trait Food
case object Antelope extends Food
case object TigerFood extends Food
case object Licorice extends Food
final case class CatFood(food: String) extends Food


/**
 * Polymorphic (OO) Style
 * It's easier to add DATA, as it is only extending trait in another class,
 * but difficult to add METHODS, as all existing, derived classes have to change.
  */
class PolymorphismSolutionOne {
  sealed trait Feline {
    def dinner: Food
  }
  final case class Lion() extends Feline {
    def dinner: Food = Antelope
  }
  final case class Tiger() extends Feline {
    def dinner: Food = TigerFood
  }
  final case class Panther() extends Feline {
    def dinner: Food = Licorice
  }
  final case class Cat(favouriteFood: String) extends Feline {
    def dinner: Food = CatFood(favouriteFood)
  }
}

// =================

class PolymorphismSolutionTwo {
  sealed trait Feline {
    def dinner: Food = CatFood("mouse")
  }

  final case class Lion() extends Feline {
    override def dinner: Food = Antelope
  }

  final case class Tiger() extends Feline {
    override def dinner: Food = TigerFood
  }

  final case class Panther() extends Feline // use default food

  final case class Cat(favouriteFood: String) extends Feline {
    override  def dinner: Food = CatFood(favouriteFood)
  }
}

// =================
/**
 * Pattern Matching (FP) Style
 * It's easier to add METHODS, as it is only extending trait with another function (or add one more class with it),
 * but difficult to add DATA, as all existing, methods have to change.
 */

class PatternMatching {
  sealed trait Feline {
    def dinner: Food =
      this match {
        case Lion() => Antelope
        case Tiger() => TigerFood
        case Panther() => Licorice
        case Cat(favouriteFood) => CatFood(favouriteFood)
      }
  }

  final case class Lion() extends Feline
  final case class Tiger() extends Feline
  final case class Panther() extends Feline
  final case class Cat(favouriteFood: String) extends Feline

  // =================

  // There is also a way of putting 'dinner' in separate class,
  // and not just into trait, which can leverage additional information
  // from the contex like spieces and knife
  class AsianChef(spices: Seq[String], knife: String, feline: Feline) {
    def dinner: Food = feline match {
        case Lion() => Antelope
        case Tiger() => TigerFood
        case Panther() => Licorice
        case Cat(favouriteFood) => CatFood(favouriteFood)
    }
  }
}
