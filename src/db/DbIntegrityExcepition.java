package db;

public class DbIntegrityExcepition extends RuntimeException {

    public DbIntegrityExcepition(String msg) {
        super(msg);
    }

}
