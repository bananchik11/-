public class primer7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1" );
            throw new ArithmeticException(); //для перехвата данного исключения необходимо создать новый обработчик
        }catch (ArithmeticException e) {
            System.out.println("2" );
        }
        System.out.println("3");
    }
}
