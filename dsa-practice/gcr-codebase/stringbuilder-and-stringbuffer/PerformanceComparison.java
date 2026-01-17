public class PerformanceComparison {
    public static void main(String[] args) {

        int n = 1_000_000;

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append("hello");
        }
        long endBuilder = System.nanoTime();

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb2.append("hello");
        }
        long endBuffer = System.nanoTime();

        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder));
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer));
    }
}
