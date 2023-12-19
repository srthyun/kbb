package com.dhyoon.kbb.core.utils;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class LocalDateUtil {

    public static LocalDate offsetToLocalDate(String date) {
        TemporalAccessor temporalAccessor = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(date);
        OffsetDateTime offset = OffsetDateTime.from(temporalAccessor);
        return offset.atZoneSameInstant(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate toLocalDate(String date) {
        if (date.contains("T")) {
            return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } else if (date.length() == 8) {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        }
        return null;
    }
}
