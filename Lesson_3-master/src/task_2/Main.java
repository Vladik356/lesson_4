package task_2;

// Интерфейс для геометрических фигур
    interface Shape {
        // Метод для расчета периметра
        default double calculatePerimeter() {
            return 0.0;
        }

        // Метод для расчета площади
        default double calculateSquare() {
            return 0.0;
        }

        // Установка и получение цвета заливки
        void setFillColor(String color);
        String getFillColor();

        // Установка и получение цвета границы
        void setBorderColor(String color);
        String getBorderColor();
    }

    // Реализация круга
    class Circle implements Shape {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;  // C = 2ПR
        }

        @Override
        public double calculateSquare() {
            return Math.PI * Math.pow(radius, 2); // A = ПR^2
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    // Реализация прямоугольника
    class Rectangle implements Shape {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateSquare() {
            return width * height;
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    // Реализация треугольника
    class Triangle implements Shape {
        private double sideA;
        private double sideB;
        private double sideC;
        private String fillColor;
        private String borderColor;

        public Triangle(double sideA, double sideB, double sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double calculateSquare() {
            double p = calculatePerimeter() / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)); // S = √(p * (p - a) * (p - b) * (p - c))
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    // Главный класс
    public class Main {
        public static void main(String[] args) {
            Shape circle = new Circle(5);
            circle.setFillColor("Red");
            circle.setBorderColor("Black");

            Shape rectangle = new Rectangle(7, 3);
            rectangle.setFillColor("Green");
            rectangle.setBorderColor("Yellow");

            Shape triangle = new Triangle(2, 4, 3);
            triangle.setFillColor("Blue");
            triangle.setBorderColor("White");

            // Вывод характеристик круга
            System.out.println("Circle: ");
            System.out.println("Perimeter: " + circle.calculatePerimeter());
            System.out.println("Square: " + circle.calculateSquare());
            System.out.println("Fill Color: " + circle.getFillColor());
            System.out.println("Border Color: " + circle.getBorderColor());
            System.out.println();

            // Вывод характеристик прямоугольника
            System.out.println("Rectangle: ");
            System.out.println("Perimeter: " + rectangle.calculatePerimeter());
            System.out.println("Square: " + rectangle.calculateSquare());
            System.out.println("Fill Color: " + rectangle.getFillColor());
            System.out.println("Border Color: " + rectangle.getBorderColor());
            System.out.println();

            // Вывод характеристик треугольника
            System.out.println("Triangle: ");
            System.out.println("Perimeter: " + triangle.calculatePerimeter());
            System.out.println("Square: " + triangle.calculateSquare());
            System.out.println("Fill Color: " + triangle.getFillColor());
            System.out.println("Border Color: " + triangle.getBorderColor());
        }
    }
