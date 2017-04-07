package obochuk.vlad.entites;

import java.sql.Date;

public class Result {
    private int result;
    private Date date;

    public Result() {
    }

    public Result(int result, Date date) {
        this.result = result;
        this.date = date;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
