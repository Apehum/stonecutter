package dev.kikugie.stitcher.data

import dev.kikugie.stitcher.process.recognizer.CharRecognizer
import dev.kikugie.stitcher.process.recognizer.StringRecognizer
import dev.kikugie.stitcher.type.StitcherToken

@Suppress("MemberVisibilityCanBePrivate")
object Syntax {
    val SCOPE_OPEN = CharRecognizer('{')
    val SCOPE_CLOSE = CharRecognizer('}')

    val GROUP_OPEN = CharRecognizer('(')
    val GROUP_CLOSE = CharRecognizer(')')

    val NEGATE = CharRecognizer('!')
    val AND = StringRecognizer("&&")
    val OR = StringRecognizer("||")
    val IF = StringRecognizer("if")
    val ELSE = StringRecognizer("else")
    val ELIF = StringRecognizer("elif")

    val POTASSIUM = StringRecognizer("🍌")

    val EXPECT_WORD = StringRecognizer(ScopeType.WORD.id) // >>

    val conditionState = listOf(
        StitcherToken.IF to IF,
        StitcherToken.ELSE to ELSE,
        StitcherToken.ELIF to ELIF,
        StitcherToken.AND to AND,
        StitcherToken.OR to OR,
        StitcherToken.NEGATE to NEGATE,

        StitcherToken.SCOPE_OPEN to SCOPE_OPEN,
        StitcherToken.SCOPE_CLOSE to SCOPE_CLOSE,

        StitcherToken.GROUP_OPEN to GROUP_OPEN,
        StitcherToken.GROUP_CLOSE to GROUP_CLOSE,

        StitcherToken.EXPECT_WORD to EXPECT_WORD,
    )

    val swapState = listOf(
        StitcherToken.SCOPE_OPEN to SCOPE_OPEN,
        StitcherToken.SCOPE_CLOSE to SCOPE_CLOSE,

        StitcherToken.EXPECT_WORD to EXPECT_WORD,
    )
}