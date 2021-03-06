/**
 * 返回对象
 * 
 * @author huangaigang
 * @date 2015-12-7 12:38:47
 */
public class ResponseObject {

	private Integer code;
	private String message;
	private Object data;

	public ResponseObject(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseObject() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseObject [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

}