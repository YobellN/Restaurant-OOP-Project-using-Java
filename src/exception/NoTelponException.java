package exception;

public class NoTelponException extends Exception{
    public String message(){
        return "No Telpon Hanya Boleh Terdiri dari angka / diawali +";
    }
}