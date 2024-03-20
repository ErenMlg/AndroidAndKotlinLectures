package com.softcross.customviews

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RadialGradient
import android.graphics.RectF
import android.graphics.Shader
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import java.lang.Float.min
import kotlin.math.max


class OnePieceWantedCustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    init {
        setWillNotDraw(false)
    }

    private var bitmap: Bitmap? = null

    private val viewRectF = RectF()

    private var bitmapTranslateY = 0f

    private var bitmapTranslateX = 0f

    private val imageRectF = RectF()

    private val matrix = Matrix()

    private var scaleFactor = 1f

    private val framePath = Path()

    private val clipSpace = 3.toDp

    private val gradientPaint = Paint(Paint.ANTI_ALIAS_FLAG)


    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        strokeWidth = 10f
    }

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 3f
    }

    private val imagePaint = Paint().apply {
        isAntiAlias = true
    }

    private val deadOrAliveTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc
        )
        textAlign = Paint.Align.CENTER
        color = context.getColor(R.color.black)
    }

    private val bountyTextPath = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc
        )
        textAlign = Paint.Align.CENTER
        color = context.getColor(R.color.black)
        letterSpacing = 0.3f
    }

    private val subtextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc
        )
        color = context.getColor(R.color.black)
    }

    private val deadOrAliveTextPath = Path()

    private val wantedTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc_black
        )
        textAlign = Paint.Align.CENTER
        color = context.getColor(R.color.black)
    }

    private val characterTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc_black
        )
        textAlign = Paint.Align.CENTER
        color = context.getColor(R.color.black)
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
        initTextPaints()
        initImageMatrix()
        initFramePath()
    }


    override fun onDraw(canvas: Canvas) {
        canvas.clipPath(framePath)
        canvas.drawPaint(gradientPaint)
        canvas.drawCircle(
            (viewRectF.width() / 2f),
            viewRectF.height() * 3 / 100,
            min(
                viewRectF.width(), viewRectF.height()
            ) * 1.5f / 100,
            circlePaint
        )

        bitmap?.let {
            canvas.drawBitmap(it, matrix, imagePaint)
            canvas.drawTextOnPath(
                "DEAD OR ALIVE",
                deadOrAliveTextPath,
                0f,
                0f,
                deadOrAliveTextPaint
            )
        }
        canvas.drawLine(
            viewRectF.width() * 22 / 100,
            (viewRectF.height() * 8 / 100) * 3 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY),
            viewRectF.width() * 19 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 22 / 100,
            (viewRectF.height() * 8 / 100) * 3 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY),
            viewRectF.width() * 25 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            linePaint
        )

        canvas.drawLine(
            viewRectF.width() * 25 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            viewRectF.width() * 24 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 5 / 100),
            linePaint
        )

        canvas.drawLine(
            viewRectF.width() * 19 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            viewRectF.width() * 20 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 5 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 20 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 5 / 100),
            viewRectF.width() * 24 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 5 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 19 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            viewRectF.width() * 25 / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 22 / 100,
            (viewRectF.height() * 8 / 100) * 3 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY),
            viewRectF.width() * 23f / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 22 / 100,
            (viewRectF.height() * 8 / 100) * 3 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY),
            viewRectF.width() * 21f / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 21f / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            viewRectF.width() * 21.5f / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 5 / 100),
            linePaint
        )
        canvas.drawLine(
            viewRectF.width() * 23f / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 6 / 100),
            viewRectF.width() * 22.5f / 100,
            (viewRectF.height() * 8 / 100) * 2 + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 5 / 100),
            linePaint
        )

        drawText(
            "WANTED",
            canvas,
            wantedTextPaint,
            viewRectF.width() / 2f,
            (bitmapTranslateY) / 4f + (min(
                width.toFloat() / 2f,
                height.toFloat() / 2f
            ) * 3f / 100 * resources.displayMetrics.scaledDensity)
        )
        drawText(
            "MONKEY D. LUFFY",
            canvas,
            characterTextPaint,
            viewRectF.width() / 2f,
            (viewRectF.height() * 8 / 100) / 2f + (imageRectF.height() * scaleFactor) / 2f + (bitmapTranslateY) / 2f + (viewRectF.height() * 10 / 100) / 2f
        )
        canvas.drawText(
            "1.300.000",
            viewRectF.width() / 2f + bountyTextPath.textSize,
            (viewRectF.height() * 8 / 100) + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            bountyTextPath
        )
        canvas.drawText(
            "KONO SAK UHI HA FICTO",
            viewRectF.width() * 19f / 100,
            (viewRectF.height() * 12 / 100) + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            subtextPaint
        )
        canvas.drawText(
            "JIMBUTSU DANTAI SONTOA",
            viewRectF.width() * 19f / 100,
            (viewRectF.height() * 14 / 100) + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            subtextPaint
        )
        canvas.drawText(
            "JITSSUZAUSIR NASHOY GA",
            viewRectF.width() * 19f / 100,
            (viewRectF.height() * 16 / 100) + (imageRectF.height() * scaleFactor) + (bitmapTranslateY) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            subtextPaint
        )
        drawText(
            "MARINE",
            canvas,
            characterTextPaint,
            (viewRectF.width() * 70f / 100),
            (viewRectF.height() * 16 / 100) / 2f + (imageRectF.height() * scaleFactor) / 2f + (bitmapTranslateY) / 2f + (viewRectF.height() * 8 / 100) / 2f + (viewRectF.height() * 8 / 100) / 2f
        )
        invalidate()
    }

    fun setBitmap(bitmap: Bitmap?) {
        this.bitmap = bitmap
        initImageMatrix()
        initTextPaints()
        initFramePath()
        invalidate()
    }

    private fun drawText(text: String, canvas: Canvas, textPaint: TextPaint, x: Float, y: Float) {
        canvas.save()
        canvas.scale(1f, 2f)
        canvas.drawText(
            text, x,
            y,
            textPaint
        )
        canvas.restore()
    }

    private fun initImageMatrix() {
        bitmap?.let {
            // set imageRectF to bitmap sizes
            imageRectF.set(0f, 0f, it.width.toFloat(), it.height.toFloat())
            // Calculate the scale ratio with canvas size and image size
            val widthScale = viewRectF.width() / imageRectF.width() * 80 / 100
            val heightScale = viewRectF.height() / imageRectF.height()
            // Take minimum scale ratio for the image can be fit canvas
            scaleFactor = min(widthScale, heightScale)
            // Calculate translate ratio, Y axis calculated with text size
            bitmapTranslateX = (viewRectF.width() - scaleFactor * imageRectF.width()) / 2f
            bitmapTranslateY = viewRectF.height() * 16 / 100
            deadOrAliveTextPath.moveTo(
                viewRectF.width() * 10 / 100,
                viewRectF.height() * 8 / 100 + it.height * scaleFactor + bitmapTranslateY
            )
            deadOrAliveTextPath.lineTo(
                viewRectF.width() * 90 / 100,
                viewRectF.height() * 8 / 100 + it.height * scaleFactor + bitmapTranslateY
            )
            matrix.setScale(scaleFactor, scaleFactor)
            matrix.postTranslate(bitmapTranslateX, bitmapTranslateY)
            invalidate()
        }
    }

    private fun initTextPaints() {
        wantedTextPaint.textSize =
            (min(
                viewRectF.width(),
                viewRectF.height()
            ) * 3f / 100) * resources.displayMetrics.scaledDensity

        deadOrAliveTextPaint.textSize =
            (min(
                viewRectF.width(),
                viewRectF.height()
            ) * 3f / 100) * resources.displayMetrics.scaledDensity

        bountyTextPath.textSize =
            (min(
                viewRectF.width(),
                viewRectF.height()
            ) * 3f / 100) * resources.displayMetrics.scaledDensity

        characterTextPaint.textSize =
            (min(
                viewRectF.width(),
                viewRectF.height()
            ) * 2.8f / 100) * resources.displayMetrics.scaledDensity

        subtextPaint.textSize =
            (min(
                viewRectF.width(),
                viewRectF.height()
            ) * 1f / 100) * resources.displayMetrics.scaledDensity

    }

    private fun initFramePath() {
        framePath.reset()

        framePath.moveTo(viewRectF.left, viewRectF.top + clipSpace)

        framePath.lineTo(viewRectF.left, viewRectF.height() * 10 / 100)

        framePath.lineTo(
            viewRectF.left + viewRectF.width() * 15 / 100,
            viewRectF.height() * 10 / 100
        )

        framePath.lineTo(
            viewRectF.left,
            viewRectF.height() * 12 / 100
        )

        framePath.lineTo(viewRectF.left, viewRectF.bottom - clipSpace)

        framePath.lineTo(viewRectF.left + clipSpace, viewRectF.bottom)

        framePath.lineTo(viewRectF.right - clipSpace, viewRectF.bottom)

        framePath.lineTo(viewRectF.right, viewRectF.bottom - clipSpace)

        framePath.lineTo(viewRectF.right, viewRectF.top + clipSpace)

        framePath.lineTo(viewRectF.right - clipSpace, viewRectF.top)

        framePath.lineTo(viewRectF.left + clipSpace, viewRectF.top)

        framePath.lineTo(viewRectF.left, viewRectF.top + clipSpace)

        invalidate()
    }
}


val Int.toDp: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()