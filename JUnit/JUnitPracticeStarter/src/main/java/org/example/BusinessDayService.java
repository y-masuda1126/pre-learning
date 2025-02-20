package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BusinessDayService {
    /**
     * 休業日一覧
     * 本来はデータベース等から参照するのが望ましいのですが、簡素化のためSetに保持
     */
    private final Set<LocalDate> holidays = new HashSet<>();

    /**
     * コンストラクタ
     */
    public BusinessDayService() {
        // 休業日一覧データを生成
        createHolidays();
    }

    /**
     * 引数で渡された日付が営業日かどうかを返します
     * @param date 対象日付
     * @return 営業日
     */
    public boolean isBusinessDay(LocalDate date) {

        if (date == null) throw new IllegalArgumentException();

        // 祝日の場合はfalseを返却
        if (holidays.contains(date)) {
            return false;
        }

        var dayOfWeek = date.getDayOfWeek();

        // 土曜日・日曜日以外の場合はtrueを返却
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    /**
     * 引数で渡された日付から検索日数の間で直近の営業日を返します
     * 該当がない場合はNULLを返します
     * @param date 対象日付
     * @param maxDays 検索日数
     * @return 直近の次の営業日
     */
    public LocalDate getNextBusinessDay(LocalDate date, int maxDays) {
        if (maxDays < 0) {
            return null;
        }

        return IntStream.rangeClosed(0, maxDays).boxed().map(date::plusDays).filter(this::isBusinessDay).findFirst().orElse(null);
    }

    public LocalDate[] getBusinessDayArray(LocalDate date, int maxDays) {
        var list = getBusinessDayList(date, maxDays);
        return list.toArray(new LocalDate[0]);
    }

    public List<LocalDate> getBusinessDayList(LocalDate date, int maxDays) {
        if (maxDays < 0) {
            return Collections.emptyList();
        }

        return IntStream.rangeClosed(0, maxDays).boxed().map(date::plusDays).filter(this::isBusinessDay).collect(Collectors.toList());
    }

    private void createHolidays() {
        addHoliday(2022, 1,1); // 元日
        addHoliday(2022, 1,2); // 休業日
        addHoliday(2022, 1,3); // 休業日
        addHoliday(2022, 1,4); // 休業日
        addHoliday(2022, 1,5); // 休業日
        addHoliday(2022, 1,10); // 成人の日
        addHoliday(2022, 2,11); // 建国記念日
        addHoliday(2022, 2,23); // 天皇誕生日
        addHoliday(2022, 3,21); // 春分の日
        addHoliday(2022, 4,29); // 昭和の日
        addHoliday(2022, 5,3); // 憲法記念日
        addHoliday(2022, 5,4); // みどりの日
        addHoliday(2022, 5,5); // こどもの日
        addHoliday(2022, 7,18); // 海の日
        addHoliday(2022, 8,11); // 山の日
        addHoliday(2022, 8,12); // 休業日
        addHoliday(2022, 8,15); // 休業日
        addHoliday(2022, 8,16); // 休業日
        addHoliday(2022, 9,19); // 敬老の日
        addHoliday(2022, 9,23); // 秋分の日
        addHoliday(2022, 10,10); // スポーツの日
        addHoliday(2022, 11,3);  // 文化の日
        addHoliday(2022, 11,23); // 勤労感謝の日
        addHoliday(2022, 12,28); // 休業日
        addHoliday(2022, 12,29); // 休業日
        addHoliday(2022, 12,30); // 休業日
        addHoliday(2022, 12,31); // 休業日
    }

    private void addHoliday(int year, int month, int dayOfMonth) {
        holidays.add(LocalDate.of(year, month, dayOfMonth));
    }
}
