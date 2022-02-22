package course.academy.dao.exception;

//Когато наследяваме изключение очакваме то бъде хванато от клиента
//и програмата да продължи да работи!

//Освен ако не е runtime exception!
//Тогава имаме грешка в дезайна на програмата и бихме искали тя да бъде прекъсната!
public class InvalidRepositoryStateException extends Exception {
    public InvalidRepositoryStateException() {
    }

    public InvalidRepositoryStateException(String message) {
        super(message);
    }

    public InvalidRepositoryStateException(String message, Throwable cause) {
        super(message, cause);
    }

    //Cause означава че можем да му подаваме друг вид изключения в конструктора
    public InvalidRepositoryStateException(Throwable cause) {
        super(cause);
    }
}
