package com.example.guessquiz.frontend;

import org.junit.jupiter.api.Test;
import org.xmlunit.diff.Diff;

import java.util.EnumSet;

import static com.example.guessquiz.frontend.Difficulty.*;
import static org.junit.jupiter.api.Assertions.*;

class DifficultyTest {

    @Test
    void calculateNextDifficulty_easy() {
        EnumSet<Difficulty> given = EnumSet.of(EASY);
        Difficulty result = calculateNextDifficulty(given);
        assertEquals(MEDIUM, result);
    }

    @Test
    void calculateNextDifficulty_null(){
        EnumSet<Difficulty> given = null;
        Difficulty difficulty = calculateNextDifficulty(given);
        assertNull(difficulty);
    }

    @Test
    void calculateNextDifficulty_none(){
        EnumSet<Difficulty> given = EnumSet.noneOf(Difficulty.class);
        Difficulty difficulty = calculateNextDifficulty(given);
        assertNull(difficulty);
    }

    @Test
    void calculateNextDifficulty_medium(){
        EnumSet<Difficulty> given = EnumSet.of(MEDIUM);
        Difficulty difficulty = calculateNextDifficulty(given);
        assertEquals(HARD, difficulty);
    }

    @Test
    void calculateNextDifficulty_hard(){
        EnumSet<Difficulty> given = EnumSet.of(HARD);
        Difficulty difficulty = calculateNextDifficulty(given);
        assertEquals(MEDIUM, difficulty);
    }

    @Test
    void calculateNextDifficulty_easy_hard(){
        EnumSet<Difficulty> easy = EnumSet.of(EASY, HARD);
        Difficulty difficulty = calculateNextDifficulty(easy);
        assertEquals(MEDIUM, difficulty);
    }

    @Test
    void calculateNextDifficulty_medium_hard(){
        EnumSet<Difficulty> medium = EnumSet.of(MEDIUM, HARD);
        Difficulty difficulty = calculateNextDifficulty(medium);
        assertEquals(EASY, difficulty);
    }

    @Test
    void calculateNextDifficulty_hard_easy(){
        EnumSet<Difficulty> hard = EnumSet.of(HARD, EASY);
        Difficulty difficulty = calculateNextDifficulty(hard);
        assertEquals(MEDIUM, difficulty);
    }

    @Test
    void calculateNextDifficulty_all(){
        EnumSet<Difficulty> easy = EnumSet.of(EASY, MEDIUM, HARD);
        Difficulty difficulty = calculateNextDifficulty(easy);
        assertNull(difficulty);
    }

}



