package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompleteStats_noCompleted_returnsHundredZero() {

        // Create an active task (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Check the result
        assertEquals(result.completedTasksPercent, (0f))
        assertEquals(result.activeTasksPercent, (100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = true)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.activeTasksPercent, (0f))
        assertEquals(result.completedTasksPercent,(100f))
    }

    @Test
    fun getActiveAndCompleteStats_both_returnsFortySixty() {
        val tasks = listOf(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.activeTasksPercent, (40f))
        assertEquals(result.completedTasksPercent, (60f))
    }

    @Test
    fun getActiveAndCompleteStats_error_returnsZeros() {
        val result = getActiveAndCompletedStats(null)

        assertEquals(result.activeTasksPercent,(0f))
        assertEquals(result.completedTasksPercent, (0f))
    }

    @Test
    fun getActiveAndCompleteStats_emtpy_returnsZeros() {
        val result = getActiveAndCompletedStats(emptyList())

        assertEquals(result.activeTasksPercent, (0f))
        assertEquals(result.completedTasksPercent, (0f))
    }
}