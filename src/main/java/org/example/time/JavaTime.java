package org.example.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class JavaTime {

    public static void main(String[] args) {

        //Ways of creating local Date object
        LocalDate date = LocalDate.now();       //Format :: YYYY-MM-DD
        LocalDate date1 = LocalDate.of(2025, 1, 29);
        System.out.println(date);
        System.out.println(date1);
        //Default chronology (calender) ISO
        System.out.println(LocalDate.parse("2025-04-05"));      //LocalDate parse only works for YYYY-MM-DD Format
        System.out.println(LocalDate.parse("07/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(LocalDate.parse("2026-03-04", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        //Ways of creating localTime
        LocalTime time = LocalTime.now();       ///Format :: HH:MM:SS:NS
        LocalTime time1 = LocalTime.of(20, 34);
        System.out.println(time);
        System.out.println(time1);

        System.out.println(Period.between(LocalDate.now(), date1).getDays());
        System.out.println(Duration.between(time, time1).getSeconds());

        //Adjusters

        LocalDate adjust = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).minus(Period.ofDays(1));
        System.out.println(adjust);
    }
}
