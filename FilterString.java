 private final int FILTER_LESS_THAN_EQUL_12_HOUR = 0;
    private final int FILTER_LESS_THAN_EQUL_A_DAY = 1;
    private final int FILTER_LESS_THAN_EQUL_8_DAYS = 2;
    private final int FILTER_LESS_THAN_EQUL_2_MONTHS = 3;
    private final int FILTER_UNDEFINE = 4;

    /**
     * This method filters the string based on day/week/month/year and generate the HashMap with
     * the filter string under day/week/month/year
     *
     * @param testHashMap
     * @return HashMap<Integer, ArrayList < Integer>>
     */
    private HashMap<Integer, ArrayList<Integer>> getFinalFilterData(HashMap<Integer, String> testHashMap) {
        HashMap<Integer, ArrayList<Integer>> filterDataHashMap = new HashMap<>();
        for (Integer key : testHashMap.keySet()) {
            String value = testHashMap.get(key);
            FilterDataHolder obj = getFilterData(key, value);
            long duration_in_min = ((obj.value * obj.dataValue) /60);

            if (duration_in_min <= (12*60)) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_12_HOUR) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_12_HOUR, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_12_HOUR);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_12_HOUR, list);
                }
            } else if (duration_in_min <= (24*60)) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_DAY) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_DAY, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_DAY);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_DAY, list);
                }
            } else if (duration_in_min <= (8 * (24*60))) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_8_DAYS) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_8_DAYS, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_8_DAYS);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_8_DAYS, list);
                }
            } else if (duration_in_min <= (2 * 30 * (24*60))) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_2_MONTHS) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_2_MONTHS, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_2_MONTHS);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_2_MONTHS, list);
                }
            } else {
                if (filterDataHashMap.get(FILTER_UNDEFINE) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_UNDEFINE, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_UNDEFINE);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_UNDEFINE, list);
                }
            }

            /*if (duration_in_hr <= 12) {

                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_DAY) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_DAY, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_DAY);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_DAY, list);
                }
            } else if (duration > 1 && duration <= 7) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_WEEK) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_WEEK, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_WEEK);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_WEEK, list);
                }
            }else if (duration > 7 && duration <= 31) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_MONTH) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_MONTH, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_MONTH);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_MONTH, list);
                }
            } else if (duration > 31 && duration <= 366) {
                if (filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_YEAR) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_YEAR, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_LESS_THAN_EQUL_A_YEAR);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_LESS_THAN_EQUL_A_YEAR, list);
                }
            } else {
                if (filterDataHashMap.get(FILTER_UNDEFINE) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_UNDEFINE, list);
                } else {
                    ArrayList<Integer> list = filterDataHashMap.get(FILTER_UNDEFINE);
                    list.add(obj.index);
                    filterDataHashMap.put(FILTER_UNDEFINE, list);
                }
            }*/
        }
        return filterDataHashMap;
    }

    /**
     * It is the data holder which has index, value, data and data value
     */
    private class FilterDataHolder {
        //For row
        int index;
        //For duration
        int value;
        //For day/week/month/year
        String data = "";
        //For data value 1/7/31/365
        long dataValue;

    }


    /**
     * This method has logic to filter data based on day/week/month/year
     *
     * @param index row
     * @param pStr
     * @return FilterDataHolder object
     */
    private FilterDataHolder getFilterData(int index, String pStr) {
        FilterDataHolder holder = new FilterDataHolder();
        holder.index = index;
        String filterStr = pStr.replaceAll("[^0-9]", "");
        //Matcher m = Pattern.compile("([0-9])").matcher(filterStr);
        if (!filterStr.isEmpty()) {
            holder.value = Integer.parseInt(filterStr);
        } else {
            holder.value = 1;
        }

        if (pStr.contains("sec") || pStr.contains("second") || pStr.contains("seconds")) {
            holder.data = "second";
            holder.dataValue = 1;
        } else if (pStr.contains("min") || pStr.contains("minute") || pStr.contains("minutes")) {
            holder.data = "min";
            holder.dataValue = (1 * 60);
        } else if (pStr.contains("hr") || pStr.contains("hour") || pStr.contains("hours")) {
            holder.data = "hour";
            holder.dataValue = (1 * 60 * 60);
        } else if (pStr.contains("day") || pStr.contains("days")) {
            holder.data = "day";
            holder.dataValue = (1 * 24 * 60 * 60);
        } else if (pStr.contains("week") || pStr.contains("weeks")) {
            holder.data = "week";
            holder.dataValue = (7 * 24 * 60 * 60);
        } else if (pStr.contains("month") || pStr.contains("months")) {
            holder.data = "month";
            holder.dataValue = (30 * 24 * 60 * 60);
        } else if (pStr.contains("year") || pStr.contains("years")) {
            holder.data = "year";
            holder.dataValue = (365 * 24 * 60 * 60);
        }
        return holder;
    }