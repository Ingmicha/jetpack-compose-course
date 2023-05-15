package com.ingmicha.android.udemy.novo.compose.composetesting.components

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

class ComponentsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            Components()
        }
        //Finder
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("icon add")

        composeTestRule.onAllNodesWithText(":")
        composeTestRule.onAllNodesWithTag("componen1")
        composeTestRule.onAllNodesWithContentDescription("icon add")

        //Actions
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performTouchInput {
            doubleClick()
            longClick()
            swipeDown()
            swipeUp()
            swipeRight()
            swipeLeft()
        }
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performClick()
            .performScrollTo()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performClick()
            .performImeAction()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performClick()
            .performTextClearance()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performClick()
            .performTextInput("")
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).performClick()
            .performTextReplacement("")


        //Assertions
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertDoesNotExist()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true)
            .assertContentDescriptionEquals("")
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true)
            .assertContentDescriptionContains("")
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsNotDisplayed()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsEnabled()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsNotEnabled()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsSelected()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsNotSelected()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsOn()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertIsOff()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertTextEquals()
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertTextContains("")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsIngmicha() {
        composeTestRule.setContent {
            Components()
        }
        composeTestRule.onNodeWithText("Ingmicha", ignoreCase = true).assertExists()
    }
}