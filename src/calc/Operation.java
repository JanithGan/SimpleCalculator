package calc;

// This class contains operations that should be performed on inputs
class Operation {

    // Two Input Operations
    double performOp(double num1, double num2, int operation) {
        double result;
        switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
            case 5:
                result = Math.pow(num1, num2);
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    // One Input Operations
    double performOp(double num, int operation) {
        double result;
        switch (operation) {
            case 6:
                result = Math.sin(num * Math.PI / 180);
                break;
            case 7:
                result = Math.cos(num * Math.PI / 180);
                break;
            case 8:
                result = Math.tan(num * Math.PI / 180);
                break;
            case 9:
                result = factorial(num);
                break;
            case 10:
                result = Math.sqrt(num);
                break;
            case 11:
                result = Math.exp(num);
                break;
            case 12:
                result = Math.log(num);
                break;
            case 13:
                result = Math.pow(10, num);
                break;
            case 14:
                result = Math.log10(num);
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    // No Input Operations
    double performOp(String entry) {
        if (entry.equals("pi"))
            return Math.PI;
        else if (entry.equals("e"))
            return Math.E;
        else
            return 0;
    }

    // Factorial Calculation
    private double factorial(double N) {
        long fact = 1;
        int n = (int) N;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return ((double) fact);
    }

}