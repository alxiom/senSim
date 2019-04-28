package alx.nlp

/**
  * Created by Alex on 28/04/2019.
  */

import com.google.inject.{Guice, Injector}

class CalculateNGram {

  def apply(sourceText: String, targetText: String, nGram: Int = 1): Double = {
    val slideSourceText = (" " * (nGram - 1) + sourceText + " " * (nGram - 1)).sliding(nGram).toSet
    val slideTargetText = (" " * (nGram - 1) + targetText + " " * (nGram - 1)).sliding(nGram).toSet
    (slideSourceText & slideTargetText).size / (slideSourceText | slideTargetText).size.toDouble
  }

}

object CalculateNGram {

  val inject: Injector = Guice.createInjector()
  val calculateNGram: CalculateNGram = inject.getInstance(classOf[CalculateNGram])

  def main(args: Array[String]): Unit = {

    val sourceText = "안녕하세요"
    val targetText = "안녕하세"
    val nGramScore = calculateNGram(sourceText, targetText)

    println(nGramScore)

  }

}