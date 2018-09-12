package zucc.edu.commitment.recycle.Util;

public class ResultUtil {
    /**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result msg=new Result();
        msg.setCode(0);
        msg.setMsg("success");
        msg.setData(object);
        return msg;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code,String resultmsg){
        Result msg=new Result();
        msg.setCode(code);
        msg.setMsg(resultmsg+"1");
        return msg;
    }

}
