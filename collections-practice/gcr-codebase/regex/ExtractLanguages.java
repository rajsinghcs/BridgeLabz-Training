class ExtractLanguages {

    public static void main(String[] args) {

        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift"};

        for (String lang : languages) {
            if (text.contains(lang)) {
                System.out.print(lang + ", ");
            }
        }
    }
}
