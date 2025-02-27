package com.example.barhalfarcsweepleftview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.Color
import android.app.Activity
import android.content.Context

val colors : Array<String> = arrayOf(
    "#1A237E",
    "#EF5350",
    "#AA00FF",
    "#C51162",
    "#00C853"
)
val parts : Int = 5
val sizeFactor : Float = 6.9f
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")
val rot : Float = 90f
val scGap : Float = 0.04f / parts

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawXY(x : Float, y : Float, cb : () -> Unit) {
    save()
    translate(x, y)
    cb()
    restore()
}

fun Canvas.drawBarHalfSweepLeft(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val dsc : (Int) -> Float = {
        scale.divideScale(it, parts)
    }
    drawXY(w / 2 - (w / 2) * dsc(4), h / 2) {
        rotate(rot * dsc(2))
        drawXY(-w / 2 + (w / 2) * dsc(1), 0f) {
            drawRect(RectF(0f, 0f, size, size * dsc(0)), paint)
        }
        drawArc(RectF(-size, -size / 2, 0f, size / 2), 180f, 180f * dsc(3), true, paint)
    }
}

fun Canvas.drawBHSLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    drawBarHalfSweepLeft(scale, w, h, paint)
}
