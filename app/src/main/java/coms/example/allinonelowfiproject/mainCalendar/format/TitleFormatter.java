package coms.example.allinonelowfiproject.mainCalendar.format;


import coms.example.allinonelowfiproject.mainCalendar.CalendarDay;

/**
 * Used to format a {@linkplain coms.example.allinonelowfiproject.mainCalendar.CalendarDay} to a string for the month/year title
 */
public interface TitleFormatter {

    String DEFAULT_FORMAT = "LLLL yyyy";

    TitleFormatter DEFAULT = new DateFormatTitleFormatter();

    /**
     * Converts the supplied day to a suitable month/year title
     *
     * @param day the day containing relevant month and year information
     * @return a label to display for the given month/year
     */
    CharSequence format(CalendarDay day);
}