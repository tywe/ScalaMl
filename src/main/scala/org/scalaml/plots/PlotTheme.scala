/**
 * Copyright 2013, 2014  by Patrick Nicolas - Scala for Machine Learning - All rights reserved
 *
 * The source code in this file is provided by the author for the only purpose of illustrating the 
 * concepts and algorithms presented in Scala for Machine Learning.
 */
package org.scalaml.plots

import java.awt.{GradientPaint, Color, Stroke, Shape, Paint, BasicStroke}
/**
 *  @author Patrick Nicolas
 *  @date Feb 9, 2014
 *  @project Book
 */

trait PlotTheme {
	protected[this] val strokeList = Array[Stroke](
        new BasicStroke(1.0f),
        new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 8.0f, Array[Float](1.0f, 1.0f), 0.0f),
        new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 8.0f, Array[Float](3.0f, 3.0f), 0.0f)
    )

    def stroke(index: Int) = strokeList(index % strokeList.size)
    def color(index: Int): Color
    def paint(w: Int, h: Int): Paint
}


class BlackPlotTheme extends PlotTheme {
    private[this] val colorList = Array[Color](Color.white, Color.cyan, Color.yellow)
    
    override def color(index: Int): Color = colorList(index % colorList.size)
	override def paint(w: Int, h: Int): Paint = Color.black
}


class LightPlotTheme extends PlotTheme {
	private[this] val colorList = Array[Color](Color.black, Color.red, Color.blue)
    
    override def color(index: Int): Color = colorList(index % colorList.size)
	override def paint(w: Int, h: Int): Paint = new GradientPaint(0, 0, Color.white, w, h, Color.lightGray, false)
}

// ----------------------------------  EOF --------------------------------------------------------------