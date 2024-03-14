package com.softcross.customviews

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.graphics.RadialGradient
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import java.lang.Float.min
import kotlin.math.max


class RickyCharacterView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    init {
        setWillNotDraw(false)
    }

    private var bitmap: Bitmap? = null

    private val viewRectF = RectF()

    private val imageRectF = RectF()

    private val matrix = Matrix()

    private val framePath = Path()

    private val clipSpace = 5.toDp

    private val frameStrokeWidth = 8.toDp

    private val gradientPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var curlyLinePath = Path()

    private val firstLinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        strokeWidth = 5f
    }

    private val imagePaint = Paint().apply {
        isAntiAlias = true
    }

    private val framePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.color_frame)
        style = Paint.Style.STROKE
        strokeWidth = frameStrokeWidth.toFloat()
    }

    private var gradient: RadialGradient? = null

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewRectF.set(0f, 0f, w.toFloat(), h.toFloat())
        gradient = RadialGradient(
            viewRectF.width() / 2,
            viewRectF.height() / 2,
            max(viewRectF.width(), viewRectF.height()),
            ContextCompat.getColor(context, R.color.color_character_gradient_start),
            ContextCompat.getColor(context, R.color.color_character_gradient_center),
            Shader.TileMode.CLAMP
        )
        gradientPaint.shader = gradient
        initImageMatrix()
        initFramePath()
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawPaint(gradientPaint)
        canvas.drawLine(50f, 50f, width - 50f, height / 2f, firstLinePaint)
        canvas.drawCircle((width*70/100).toFloat(),(height*80/100).toFloat(),15f,firstLinePaint)
        canvas.drawCircle((width*30/100).toFloat(),(height*80/100).toFloat(),15f,firstLinePaint)
        canvas.clipPath(framePath)
        bitmap?.let {
            canvas.drawBitmap(it, matrix, imagePaint)
        }
        canvas.drawPath(framePath, framePaint)
        invalidate()
    }

    fun setBitmap(bitmap: Bitmap?) {
        this.bitmap = bitmap
        initImageMatrix()
        initFramePath()
        invalidate()
    }

    private fun initImageMatrix() {
        bitmap?.let {
            imageRectF.set(0f, 0f, it.width.toFloat(), it.height.toFloat())

            val widthScale = viewRectF.width() / imageRectF.width() * 5 / 100
            val heightScale = viewRectF.height() / imageRectF.height()

            val scaleFactor = min(widthScale, heightScale)

            val translateX = (viewRectF.width() - scaleFactor * imageRectF.width()) / 2f
            val translateY = (viewRectF.height() - scaleFactor * imageRectF.height()) / 2f

            matrix.setScale(scaleFactor, scaleFactor)
            matrix.postTranslate(translateX, translateY)
            invalidate()
        }
    }

    private fun initFramePath() {
        framePath.reset()

        framePath.moveTo(viewRectF.left, viewRectF.top + clipSpace)

        framePath.lineTo(viewRectF.left, viewRectF.bottom)

        framePath.lineTo(viewRectF.right - clipSpace, viewRectF.bottom)

        framePath.lineTo(viewRectF.right, viewRectF.bottom - clipSpace)

        framePath.lineTo(viewRectF.right, viewRectF.top)

        framePath.lineTo(viewRectF.left + clipSpace, viewRectF.top)

        framePath.lineTo(viewRectF.left, viewRectF.top + clipSpace)

        invalidate()
    }
}

val Int.toDp: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()