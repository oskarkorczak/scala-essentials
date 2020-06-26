package com.korczak.essentials.traits

import java.util.Date
import com.korczak.essentials.UnitSpec

class VisitorSpec extends UnitSpec {

  "Visitor" should "have age" in {
    val before = new Date(new Date().getTime - 1)

    Anonymous("anon123", before).age should be >= 1L
  }
}