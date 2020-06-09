public class primer1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка"); //создан экземпляр RuntimeException с сообщением
            // "брошено" исключение
        } catch (RuntimeException e) {      // исключение перехвачено
            System.out.println("1 "+ e);    // исключение обработано
        }
        System.out.println("2");
    }
}