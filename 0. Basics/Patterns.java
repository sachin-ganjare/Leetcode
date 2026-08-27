
class Patterns {

    static void num_left_pyramid(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void inverted_pyramid(int rows) {
        for (int i = rows; i >= 0; i--) {
            for (int j = rows; j >= rows - i; j--) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    static void complete_pyramid(int rows) {
        for (int mid = 1; mid <= rows; mid++) {
            // space left 25
            for (int left = rows; left >= mid; left--) {
                System.out.print(' ');
            }

            // stars mid 50
            for (int i = 0; i < mid; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void inverted_and_rotated_pyramid(int rows) {
        for (int i = rows; i >= 0; i--) {
            // spaces
            for (int s = rows - i; s >= 0; s--) {
                System.out.print(" ");
            }
            // stars
            for (int j = rows - i; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void butterfly_patttern(int rows) {
        for(int i = 1; i <= rows ; i++) {
            // left wing
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            
            // space
            for(int s = i; s < rows; s++) {
                System.out.print("  ");
            }
            // right wing
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void hollow_rect(int length, int breadth) {
        for (int l = 1; l <= length; l++) {
            // borders
            System.out.print("* ");

            for (int j = 1; j < breadth - 1; j++) { 
                // mid portion
                if(l == 1 || l == length) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("* ");
            System.out.println();
        }
    } 

    static void palindromic_pyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void palindromic_pyramid_2(int rows) {
        for (int i = 1; i <= rows; i++) {
            StringBuilder line = new StringBuilder();
            line.append(" ".repeat(rows - i));

            int total = 2 * i - 1;
            for (int pos = 0; pos < total; pos++) {
                int mirror = pos < i ? pos : total - pos - 1;
                int num = i - mirror;
                line.append(num).append(' ');
            }

            System.out.println(line);
        }
    }

    static void num_rect(int n) {
        int totalRows = n * 2;
        for(int rows = 0; rows <= totalRows; rows++) {
            for(int col = 0; col <= totalRows; col++) {
                int num = Math.min(Math.min(rows, col), Math.min(totalRows - rows, totalRows - col));
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        num_left_pyramid(5);
        inverted_pyramid(5);
        inverted_and_rotated_pyramid(4);
        complete_pyramid(4);
        butterfly_patttern(5);
        hollow_rect(10, 4);
        palindromic_pyramid(4);
        palindromic_pyramid_2(5);
        num_rect(5);
    }
}