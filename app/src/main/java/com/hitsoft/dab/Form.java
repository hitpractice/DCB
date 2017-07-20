package com.hitsoft.dab;



    import java.net.URLEncoder;
    import java.util.ArrayList;
    import java.util.List;

    @SuppressWarnings({"WeakerAccess", "unused"})
    public final class Form {

        private final String encoding;
        private final List<Entry> entries;

        public Form() {
            entries = new ArrayList<>();
            encoding = "UTF-8";
        }



        public Form add(String name, Object value) {
            entries.add(new Entry(name, value));
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder result = new StringBuilder();
            for (int i = 0; i < entries.size(); i++) {
                if (i > 0) result.append("&");
                final Entry entry = entries.get(i);
                try {
                    result.append(URLEncoder.encode(entry.name, encoding));
                    result.append("=");
                    result.append(URLEncoder.encode(entry.value + "", encoding));
                } catch (Exception e) {
                    // This should never happenjjj
                    throw new RuntimeException(e);
                }
            }
            return result.toString();
        }

        @SuppressWarnings("WeakerAccess")
        public static class Entry {

            public final String name;
            public final Object value;

            public Entry(String name, Object value) {
                this.name = name;
                this.value = value;
            }
        }
    }