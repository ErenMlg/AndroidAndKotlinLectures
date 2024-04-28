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
import android.util.Log
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlin.math.max
import kotlin.math.min

class OnePieceWantedCustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    init {
        setWillNotDraw(false)
    }

    //Bitmap
    private var bitmap: Bitmap? = null

    private var characterName = "NONE"

    private var characterBounty = "0.0"

    //Rectangles & Paths
    private val viewRectF = RectF()

    private val bitmapRectF = RectF()

    private val framePath = Path()

    //Matrix
    private val bitmapMatrix = Matrix()

    //Paints
    private val gradientPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val nailPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.TRANSPARENT
        style = Paint.Style.FILL
        strokeWidth = 5f
    }

    private val diamondPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 3f
    }

    private val imagePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var gradient: RadialGradient? = null

    //TextPaints
    private val wantedTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc_black
        )
        textAlign = Paint.Align.CENTER
        color = context.getColor(R.color.black)
    }

    private val deadOrAliveTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = ResourcesCompat.getFont(
            context,
            R.font.playfair_display_sc
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

    private val bountyTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
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

    //Vals
    private val clipSpace = 3.toDp

    //Binder Function
    fun setCharacter(bitmap: Bitmap?, characterName: String, characterBounty: String) {
        Log.e("setCharacter", "Started")
        this.characterBounty = characterBounty
        this.characterName = characterName
        this.bitmap = bitmap
        initImageMatrix()
        initFramePath()
        initTextPaints()
        Log.e("setCharacter", "Finished")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        Log.e("onSizeChanged", "Started")
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
        initTextPaints()
        initFramePath()
        Log.e("onSizeChanged", "Finished")
    }

    override fun onDraw(canvas: Canvas) {
        Log.e("OnDraw", "Started")
        canvas.drawPaint(gradientPaint)
        canvas.clipPath(framePath)
        bitmap?.let { canvas.drawBitmap(it, bitmapMatrix, imagePaint) }
        canvas.drawCircle(
            (viewRectF.width() / 2f),
            viewRectF.height() * 3 / 100,
            min(
                viewRectF.width(), viewRectF.height()
            ) * 1.5f / 100,
            nailPaint
        )
        drawTexts(canvas)
        drawDiamond(
            canvas,
            viewRectF.width() * 22 / 100,
            (viewRectF.height() * 8 / 100) + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) + (viewRectF.height() * 16 / 100) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100) - (bountyTextPaint.textSize/3f)
            )
        Log.e("OnDraw", "Finished")
    }

    private fun drawTexts(canvas: Canvas) {
        Log.e("drawTexts", "Started")
        canvas.save()
        canvas.scale(1f, 2f)
        canvas.drawText(
            "WANTED",
            viewRectF.width() / 2f,
            (viewRectF.height() * 16 / 100) / 4f + (min(
                width.toFloat() / 2f,
                height.toFloat() / 2f
            ) * 3f / 100 * resources.displayMetrics.scaledDensity),
            wantedTextPaint
        )

        canvas.drawText(
            characterName,
            viewRectF.width() / 2f,
            (viewRectF.height() * 8 / 100) / 2f + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) / 2f + (viewRectF.height() * 16 / 100) / 2f + (viewRectF.height() * 10 / 100) / 2f,
            characterTextPaint
        )

        canvas.drawText(
            "MARINE",
            (viewRectF.width() * 70f / 100),
            (viewRectF.height() * 16 / 100) / 2f + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) / 2f + (viewRectF.height() * 16 / 100) / 2f + (viewRectF.height() * 8 / 100) / 2f + (viewRectF.height() * 8 / 100) / 2f,
            characterTextPaint
        )
        canvas.restore()

        canvas.drawText(
            "DEAD OR ALIVE",
            viewRectF.width() / 2f,
            viewRectF.height() * 8 / 100 + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) + (viewRectF.height() * 16 / 100),
            deadOrAliveTextPaint
        )

        canvas.drawText(
            characterBounty,
            viewRectF.width() / 2f + bountyTextPaint.textSize,
            (viewRectF.height() * 8 / 100) + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) + (viewRectF.height() * 16 / 100) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            bountyTextPaint
        )

        canvas.drawText(
            "KONO SAK UHI HA FICTO",
            viewRectF.width() * 19f / 100,
            (viewRectF.height() * 12 / 100) + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) + (viewRectF.height() * 16 / 100) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            subtextPaint
        )

        canvas.drawText(
            "JIMBUTSU DANTAI SONTOA",
            viewRectF.width() * 19f / 100,
            (viewRectF.height() * 14 / 100) + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) + (viewRectF.height() * 16 / 100) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            subtextPaint
        )

        canvas.drawText(
            "JITSSUZAUSIR NASHOY GA",
            viewRectF.width() * 19f / 100,
            (viewRectF.height() * 16 / 100) + (bitmapRectF.height() *
                    min(
                        viewRectF.height() / bitmapRectF.height(),
                        viewRectF.width() / bitmapRectF.width() * 80 / 100
                    )) + (viewRectF.height() * 16 / 100) + (viewRectF.height() * 8 / 100) + (viewRectF.height() * 8 / 100),
            subtextPaint
        )
        Log.e("drawTexts", "Finished")
    }

    private fun drawDiamond(
        canvas: Canvas,
        midX: Float,
        midY: Float
    ) {

        val leftMidCornerX = midX - viewRectF.width() * 3 / 100
        val leftMidCornerY = midY

        val rightMidCornerX = midX + viewRectF.width() * 3 / 100
        val rightMidCornerY = midY

        val bottomCornerX = midX
        val bottomCornerY = midY + viewRectF.height() * 2 / 100

        val midRightCornerX = midX + viewRectF.width() * 1 / 100
        val midRightCornerY = midY

        val midLeftCornerX = midX - viewRectF.width() * 1 / 100
        val midLeftCornerY = midY

        val midTopLeftCornerX = midX - viewRectF.width() * 0.5f / 100
        val midTopLeftCornerY = midY - viewRectF.height() * 1 / 100

        val midTopRightCornerX = midX + viewRectF.width() * 0.5f / 100
        val midTopRightCornerY = midY - viewRectF.height() * 1 / 100

        val topLeftCornerX = (leftMidCornerX + midLeftCornerX) / 2
        val topLeftCornerY = midY - viewRectF.height() * 1 / 100

        val topRightCornerX = (midRightCornerX + rightMidCornerX) / 2
        val topRightCornerY = midY - viewRectF.height() * 1 / 100

        canvas.drawLine(leftMidCornerX, leftMidCornerY, bottomCornerX, bottomCornerY, diamondPaint)
        canvas.drawLine(
            bottomCornerX,
            bottomCornerY,
            rightMidCornerX,
            rightMidCornerY,
            diamondPaint
        )
        canvas.drawLine(
            rightMidCornerX,
            rightMidCornerY,
            topRightCornerX,
            topRightCornerY,
            diamondPaint
        )
        canvas.drawLine(
            topRightCornerX,
            topRightCornerY,
            topLeftCornerX,
            topLeftCornerY,
            diamondPaint
        )
        canvas.drawLine(
            topLeftCornerX,
            topLeftCornerY,
            leftMidCornerX,
            leftMidCornerY,
            diamondPaint
        )

        canvas.drawLine(
            bottomCornerX,
            bottomCornerY,
            midLeftCornerX,
            midLeftCornerY,
            diamondPaint
        )
        canvas.drawLine(
            midLeftCornerX,
            midLeftCornerY,
            midTopLeftCornerX,
            midTopLeftCornerY,
            diamondPaint
        )

        canvas.drawLine(
            bottomCornerX,
            bottomCornerY,
            midRightCornerX,
            midRightCornerY,
            diamondPaint
        )
        canvas.drawLine(
            midRightCornerX,
            midRightCornerY,
            midTopRightCornerX,
            midTopRightCornerY,
            diamondPaint
        )

        canvas.drawLine(
            rightMidCornerX,
            rightMidCornerY,
            leftMidCornerX,
            leftMidCornerY,
            diamondPaint
        )
    }


    private fun initImageMatrix() {
        Log.e("initImageMatrix", "Started")
        bitmap?.let {
            bitmapRectF.set(0f, 0f, it.width.toFloat(), it.height.toFloat())

            val widthScale = viewRectF.width() / bitmapRectF.width() * 80 / 100
            val heightScale = viewRectF.height() / bitmapRectF.height()

            val scaleFactor = min(widthScale, heightScale)

            val bitmapTranslateX = (viewRectF.width() - scaleFactor * bitmapRectF.width()) / 2f
            val bitmapTranslateY = viewRectF.height() * 16 / 100

            bitmapMatrix.setScale(scaleFactor, scaleFactor)
            bitmapMatrix.postTranslate(bitmapTranslateX, bitmapTranslateY)
            invalidate()
        }
        Log.e("initImageMatrix", "Finished")
    }

    private fun initTextPaints() {
        Log.e("initTextPaints", "Started")
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

        bountyTextPaint.textSize =
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
        invalidate()
        Log.e("initTextPaints", "Finished")
    }

    private fun initFramePath() {
        Log.e("initFramePath", "Started")
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

        Log.e("initFramePath", "Finished")
    }
}

val Int.toDp: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()