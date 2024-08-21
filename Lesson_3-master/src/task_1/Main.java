package task_1;
// Основной класс Животных
class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + "м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + "м.");
    }
}

// Класс Собака
class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    public static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + "м.");
        }
    }
}

// Класс Кот
class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    public static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + "м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            this.isFull = true;
            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println(name + " хотел покушать, но в миске недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

// Класс Миска с едой
class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }

    public void addFood(int amount) {
        food += amount;
    }

    public void info() {
        System.out.println("В миске осталось " + food + " еды.");
    }
}

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.run(150);
        catMurzik.run(250);

        dogBobik.swim(5);
        catMurzik.swim(5);

        Bowl bowl = new Bowl(30);
        Cat[] cats = {catMurzik, catBarsik};

        for (Cat cat : cats) {
            cat.eat(bowl, 20);
        }

        bowl.info();

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Всего собак: " + Dog.dogCount);
        System.out.println("Всего котов: " + Cat.catCount);
    }
}
