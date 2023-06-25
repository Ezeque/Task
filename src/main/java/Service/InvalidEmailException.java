package Service;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(int code){
        super(getErrorMessage(code));
    }

    public static String getErrorMessage(int code){
        if(code == 1){
            return "Este e-mail já está sendo utilizado! Por favor escolha um diferente.";
        }
        else if(code == 2){
            return "Este e-mail contém caractéres inválidos!";
        }
        else{
            return "Erro desconhecido";
        }
    }
}
