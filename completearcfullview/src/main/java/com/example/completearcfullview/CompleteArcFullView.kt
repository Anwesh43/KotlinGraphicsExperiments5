package com.example.completearcfullview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val colors : Array<String> = arrayOf(
    "#1A237E",
    "#EF5350",
    "#AA00FF",
    "#C51162",
    "#00C853"
)
val parts : Int = 4
val scGap : Float = 0.04f / parts
val strokeFactor : Float = 90f
val rot : Float = -90f
val sizeFactor : Float = 4.9f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawXY(x : Float, y : Float, cb : () -> Unit) {
    save()
    translate(x, y)
    cb()
    restore()
}

fun Canvas.drawCompleteArcFull(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / strokeFactor
    val dsc : (Int) -> Float = {
        scale.divideScale(it, parts)
    }
    drawXY(w / 2 + (w / 2), h / 2 - (h / 2) * dsc(3)) {
        for (j in 0..1) {
            paint.style = Paint.Style.STROKE
            drawXY(0f, 0f) {
                rotate(rot * dsc(1) * (1 - j))
                drawArc(RectF(-size, -size / 2, 0f, size / 2), 180f * j, 180f * dsc(0).divideScale(j, 2), false, paint)
            }
            paint.style = Paint.Style.FILL
            drawXY(-size + size * j, 0f) {
                drawArc(RectF(0f, -size / 2, size, size / 2), 180f, 180f * dsc(2).divideScale(j, 2), true, paint)
            }
        }
    }
}

fun Canvas.drawCAFNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawCompleteArcFull(scale, w, h, paint)
}
