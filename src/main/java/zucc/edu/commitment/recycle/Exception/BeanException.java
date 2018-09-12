package zucc.edu.commitment.recycle.Exception;

public class BeanException extends RuntimeException{
    private Integer code;
    private String msg;
    private Object obj;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public BeanException(Integer code, String msg, Object obj){
        this.code = code;
        this.msg = msg;
        this.obj=obj;
    }
}
