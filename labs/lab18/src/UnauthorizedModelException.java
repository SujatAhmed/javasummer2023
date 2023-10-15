public class UnauthorizedModelException extends Exception{

    UnauthorizedModelException(String model){
        super("Unauthorized model: " + model);
    }

}
