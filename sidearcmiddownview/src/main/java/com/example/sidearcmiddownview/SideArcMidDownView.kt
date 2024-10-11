package com.example.sidearcmiddownview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Color
import android.graphics.Canvas

val colors : Array<String> = arrayOf(
    "#1A237E",
    "#EF5350",
    "#AA00FF",
    "#C51162",
    "#00C853"
)
val rot : Float = -90f
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")
val sizeFactor : Float = 4.9f
val strokeFactor : Float = 90f
val parts : Int = 4
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

fun Canvas.drawSideArcMidDown(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val dsc : (Int) -> Float = {
        scale.divideScale(it, parts)
    }
    drawXY(w / 2, h / 2) {
        drawXY(size * 0.5f, 0f) {
            for (j in 0..1) {
                drawXY(-size + size * j, 0f) {
                    rotate(rot * (1 - j) * (dsc(1)))
                    drawArc(
                        RectF(-size, -size / 2, 0f, size / 2),
                        180f * dsc(3),
                        180f * (dsc(0).divideScale(j, 2) - dsc(3)),
                        false,
                        paint
                    )
                }
            }
        }
    }
}

fun Canvas.drawSAMDNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawSideArcMidDown(scale, w, h, paint)
}

class SideArcMidDownView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}