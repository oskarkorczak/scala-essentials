package com.korczak.essentials.modellingpatterns

class Pattern {

  // Both are equivalent and mean that a class has featureOne and featureTwo

  case class ProductTypeImplementedByCaseClass(featureOne: String, featureTwo: Int)

  trait ProductTypeImplementedByTrait {
    def featureOne: String
    def featureTwo: Int
  }

}
